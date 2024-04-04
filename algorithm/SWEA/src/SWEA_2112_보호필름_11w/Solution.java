package SWEA_2112_보호필름_11w;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K;
	static int[][] map;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			min = Integer.MAX_VALUE;
			
			//0 :: A 
			//1 :: B
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			DFS(0, 0);
			int a = 0;
			if(min == Integer.MAX_VALUE) {
				a = 0;
			}else {
				a = min;
			}
			sb.append("#"+tc+" ").append(a+"\n");
			
		}

		System.out.print(sb);
	}

	private static void DFS(int k, int cnt) {
		if (cnt >= min) // 현재 지정된 최소값을 넘어가면 의미 없음
			return;
		
		if (k == D) {
			check: for (int i = 0; i < W; i++) {
				int att = 1;
				for (int j = 0; j < D - 1; j++) {
					if (map[j][i] == map[j + 1][i]) {
						att++;
					} else {
						att = 1;
					}

					if (att >= K) {
						continue check;// att와 K가 같아지면 다음 열 검사
					}
				}
				return;// 같아진 적이 없으면 조건을 충족하지 못하므로 종료
			}
			min = Math.min(min, cnt); 
			return;
		}

		int[] tmp = map[k].clone(); //복사 따놓기

		//약물 안 쓸때
		DFS(k + 1, cnt);

		// A로 바꾸는 약물
		Arrays.fill(map[k], 0);
		DFS(k + 1, cnt + 1);

		// B로 바꾸는 약물
		Arrays.fill(map[k], 1);
		DFS(k + 1, cnt + 1);

		map[k] = tmp; //주입 검사 후 원복 
	}
}
