package BAEK_21608_상어초등학교_12w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] map, students;
	static int[] dr, dc;
	static int N;
	static List<Point> list;
	static class Point{
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		students = new int[N*N][4];
		int stu[] = new int[N*N];
		for(int i = 0; i<N*N; i++) {
			int stuNum = sc.nextInt()-1;
			stu[i] = stuNum;
			for(int j = 0; j<4; j++) {
				students[stuNum][j] = sc.nextInt()-1;
			}
			
		}
		map = new int[N][N];
		for (int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				map[r][c] = -1;
			}
		}
		
		dr = new int[] {-1, 1, 0, 0};
		dc = new int[] {0, 0, -1, 1};
		map[1][1] = stu[0];
//		System.out.println(Arrays.toString(stu));
		for(int i = 1; i<N*N; i++) {
			list = new ArrayList<Point>();
			make(stu[i]);
		}
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		int ans = 0;
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				int cnt =0;
				for(int d = 0; d<4; d++) {
					int nr = dr[d] + r;
					int nc = dc[d] + c;
					
					if(nr>=0 && nr<N && nc>=0 && nc<N) {
						for(int i = 0; i<4; i++) {
							if(map[nr][nc] == students[map[r][c]][i]) {
								cnt++;
							}
						}
					}
				}
				if(cnt == 0) {
					
				}else if(cnt == 1) {
					ans += 1;
				}else if(cnt == 2) {
					ans += 10;
				}else if(cnt == 3) {
					ans += 100;
				}else {
					ans += 1000;
				}
			}
		}
		System.out.println(ans);
	}

	private static void make(int num) {
		
		//인접한 학생 수 세기
		int cntMax = 0;
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				int cnt = 0;
				if(map[r][c] == -1) {
					for(int d = 0; d<4; d++) {
						int nr = dr[d]+r;
						int nc = dc[d]+c;
						
						if(nr >=0 && nr<N && nc>=0 && nc<N) {
							if(map[nr][nc] != -1) {
								for(int i = 0; i<4; i++) {
									if(map[nr][nc] == students[num][i]) {
										cnt++;
//										System.out.println(nr+" : "+nc);
									}
								}
								if(cntMax < cnt) {
									cntMax = cnt;
								}
							}
						}
					}
				}
			}
		}
//		System.out.println("cntMax : "+cntMax + " num : "+num);
		//인접 한 학생이 없음!
		if(cntMax == 0) {
			int maxEmp = 0;
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					int empCnt = 0;
					if(map[r][c] == -1) {
						for(int d = 0; d<4; d++) {
							int nr = dr[d] + r;
							int nc = dc[d] + c;
							
							if(nr >= 0 && nr<N && nc >= 0 && nc<N) {
								if(map[nr][nc] == -1) {
									empCnt++;
								}
							}
						}
					}
					if(maxEmp < empCnt) {
						maxEmp = empCnt;
					}
				}
			}
//			System.out.println("maxEmp : "+maxEmp+" num : "+num);
			loop:for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					int empCnt = 0;
					if(map[r][c] == -1) {
						for(int d = 0; d<4; d++) {
							int nr = dr[d] + r;
							int nc = dc[d] + c;
							
							if(nr >= 0 && nr<N && nc >= 0 && nc<N) {
								if(map[nr][nc] == -1) {
									empCnt++;
								}
							}
						}
						if(maxEmp == empCnt) {
							map[r][c] = num;
							break loop;
						}
					}

				}
			}
		}else {
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					int cnt = 0;
					if(map[r][c] == -1) {
						for(int d = 0; d<4; d++) {
							int nr = dr[d] + r;
							int nc = dc[d] + c;
							if(nr >=0 && nr<N && nc>=0 && nc<N) {
								if(map[nr][nc] != -1) {
									for(int i = 0; i<4; i++) {
										if(map[nr][nc] == students[num][i]) {
											cnt++;
//											System.out.println(nr+" : "+nc);
										}
									}
									if(cntMax == cnt) {
										Point p = new Point(r,c);
										list.add(p);
									}
								}
							}
						}
					}

				}
			}
			//인접하는 학생수 최대인 빈 자리 중, 그 자리 근처에 빈 자리가 가장 많은 자리 선택
//			System.out.println("num : " + num);
			int maxEmp = 0;
			for(Point p : list) {
				int cnt = 0;
				for(int d = 0; d<4; d++) {
					int nr = dr[d] + p.r;
					int nc = dc[d] + p.c;
					if(nr>=0 && nr<N && nc>=0 && nc<N) {
						if(map[nr][nc] == -1) {
							cnt++;
						}
					}
				}
				if(maxEmp < cnt) {
					maxEmp = cnt;
				}
			}
			for(Point p : list) {
				int cnt = 0;
				for(int d = 0; d<4; d++) {
					int nr = dr[d] + p.r;
					int nc = dc[d] + p.c;
					if(nr>=0 && nr<N && nc>=0 && nc<N) {
						if(map[nr][nc] == -1) {
							cnt++;
						}
					}
				}
				if(maxEmp == cnt) {
					map[p.r][p.c] = num;
					break;
				}
			}
			
		}
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		
		
	}

}