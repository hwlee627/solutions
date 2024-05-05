package BAEK_15683_감시_15w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Cctv{
		int r, c, t;

		public Cctv(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}
		
		
	}
	static int[] type1, type2, type3, type4, type5, tmp, camArr, dr, dc;
	static int N, M, cnt, min, cameraCnt;
	static int[][] map, tmpMap;
	static List<Cctv> cameraList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		cameraList = new ArrayList<Main.Cctv>();
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<M; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] != 0 && map[r][c] != 6) {
					Cctv cam = new Cctv(r, c, map[r][c]);
					cameraList.add(cam);
				}
			}
		}
		//1 - 4  2 - 2  3 - 4 4 - 4 5 - 1
		cameraCnt = cameraList.size();
		
		tmp = new int[cameraCnt];
		camArr = new int[cameraCnt];
		int idx = 0;
		for(Cctv c : cameraList) {
			camArr[idx] = c.t;
			idx++;
		}
//		System.out.println(Arrays.toString(camArr));
		type1 = new int[] {0,1,2,3};
		type2 = new int[] {0,1};
		type3 = new int[] {0,1,2,3};
		type4 = new int[] {0,1,2,3};
		type5 = new int[] {0};
		cnt = 0;
		min = 100;
		dfs(0);
		
		System.out.println(min);
	}
	private static void dfs(int depth) {
		if(depth == cameraCnt) {
			cnt = 0;
			tmpMap = new int[N][M];
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<M; c++) {
					tmpMap[r][c] = map[r][c];
				}
			}
			for(int i = 0; i<cameraCnt; i++) {
				int type = cameraList.get(i).t;
				int number = tmp[i];
				check(type, number, i);
				
			}
//			System.out.println("tmp : " + Arrays.toString(tmp));
//			for(int i = 0; i<N; i++) {
//				System.out.println(Arrays.toString(tmpMap[i]));
//			}
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<M; c++) {
					if(tmpMap[r][c] == 0) {
						cnt++;
					}
				}
			}
			if(min > cnt) {
				min = cnt;
			}
			return;
		}
		
		if(camArr[depth] == 1) {
			for(int i = 0; i<4; i++) {
				tmp[depth] = i;
				dfs(depth+1);
			}
		}else if(camArr[depth] == 2) {
			for(int i = 0; i<2; i++) {
				tmp[depth] = i;
				dfs(depth + 1);
			}
		}else if(camArr[depth] == 3) {
			for(int i = 0; i<4; i++) {
				tmp[depth] = i;
				dfs(depth + 1);
			}
		}else if(camArr[depth] == 4) {
			for(int i = 0; i<4; i++) {
				tmp[depth] = i;
				dfs(depth + 1);
			}
		}else if(camArr[depth] == 5) {
			for(int i = 0; i<1; i++) {
				tmp[depth] = i;
				dfs(depth + 1);
			}
		}
		
	}
	private static void check(int type, int number, int idx) {
		if(type == 1) {
			if(number == 0) {
				//우
				watch(idx, 0);
			}else if(number == 1) {
				//하
				watch(idx, 1);
			}else if(number == 2) {
				//좌
				watch(idx, 2);
			}else if(number == 3) {
				//상
				watch(idx, 3);
			}
		}else if(type == 2) {
			if(number == 0) {
				//좌 우
				watch(idx,2);
				watch(idx,0);
			}else if(number == 1) {
				//상 하
				watch(idx,3);
				watch(idx,1);
			}
		}else if(type == 4) {
			if(number == 0) {
				//좌상우
				watch(idx,2);
				watch(idx,3);
				watch(idx,0);
			}else if(number == 1) {
				//상우하
				watch(idx,3);
				watch(idx,0);
				watch(idx,1);
			}else if(number == 2) {
				//우하좌
				watch(idx,0);
				watch(idx,1);
				watch(idx,2);
			}else if(number == 3) {
				//하좌상
				watch(idx,1);
				watch(idx,2);
				watch(idx,3);
			}
		}else if(type == 3) {
			if(number == 0) {
				//상우
				watch(idx,3);
				watch(idx,0);
			}else if(number == 1) {
				//우하
				watch(idx, 0);
				watch(idx, 1);
			}else if(number == 2) {
				//하좌
				watch(idx, 1);
				watch(idx, 2);
			}else if(number == 3) {
				//좌상
				watch(idx, 2);
				watch(idx, 3);
			}
		}else if(type == 5) {
			if(number == 0) {
				//상하좌우
				watch(idx, 0);
				watch(idx, 1);
				watch(idx, 2);
				watch(idx, 3);
			}
		}
		
	}
	private static void watch(int idx, int i) {
		int r = cameraList.get(idx).r;
		int c = cameraList.get(idx).c;
		
		dr = new int[] {0, 1, 0, -1}; //우 하 좌 상
		dc = new int[] {-1, 0, 1, 0};
		
		for(int l = 1; l<=8; l++) {
			int nr = r + dr[i] * l;
			int nc = c + dc[i] * l;
			if(nr >= 0 && nr<N && nc>=0 && nc<M) {
				if(tmpMap[nr][nc] == 6) {
					break;
				}else if(tmpMap[nr][nc] == 0) {
					tmpMap[nr][nc] = -1;
				}
			}else {
				break;
			}
		}
		}
		
	}



