package SWEA_1251_하나로_10w;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
	static class Island{
		long x, y;

		public Island(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static final long INF = Long.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//돌릴 리스트에는 연결정보, 그 때의 거리 담기
		//각 정점에는 좌표가 있기 때문에, List<Node>[] list
		//List의 인덱스는 시작점, 배열에는 인접 점들의 정점 이름들
		//dist[]에는 거리(최소 거리) 그리고 최종적으로 dist 합을 구해서 세율 곱해주기
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt(); //섬 개수
			
			long[] locX = new long[N];
			long[] locY = new long[N];
			Island[] island = new Island[N]; //섬 좌표를 담아줄 배열
			for(int i = 0 ; i<N; i++) {
				locX[i] = sc.nextLong();
			}
			for(int i = 0 ; i<N; i++) {
				locY[i] = sc.nextLong();
			}
			double E = sc.nextDouble();
			for(int i = 0; i<N; i++) {
				island[i] = new Island(locX[i], locY[i]);
			}
			//섬은 모두 다 인접 할 수 있고
			//그 안에서의 가중치는 각 점 사이의 거리 제곱
			
			//인접행렬 만들기, 가중치가 들어가야 하므로 long으로 선언하자 !
			long[][] arr = new long[N][N];
			//r과 c가 같을 때 :: 0
			//같지 않을 때 (인접할 때) 그 때의 가중치 = 좌표사이의 거리 제곱
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					if(r == c) {
						arr[r][c] = 0;
					}else {
						//r이 0, c가 1 이라면
						//0번 섬과 1번 섬이 인접하고, 가중치는 0번섬과 1번섬의 좌표 차이 제곱의 합
						long distanceX = island[r].x - island[c].x;
						long distanceY = island[r].y - island[c].y;
						arr[r][c] = distanceX*distanceX + distanceY * distanceY;
					}
				}
			}
//			for(int i = 0; i<N; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			
			//각 섬마다의 인접 및 가중치 적용 완료 !
			
			
			long[] dist = new long[N];
			

			
			//모든 점에서 돌려보기
			long minAns = INF;
			for(int i = 0; i<N; i++) {
				boolean[] visited = new boolean[N];
				//초기화
				for(int j = 0; j<N; j++) {
					dist[j] = INF-1;
				}
				//점 고르기
				dist[i] = 0;
				long ans = 0;
				for(int j = 0; j<N; j++) {
					long min = INF;
					int idx = -1;
					//아직 안뽑힌 정점들 중 가장 작은 것 추출
					
					
					for(int k = 0; k<N; k++) {
						if(!visited[k] && min>dist[k]) {
							min = dist[k];
							idx = k;
//							System.out.println("min : " + min + " idx : " + idx);
						}
					}
					
					//min, idx 도출 !
					visited[idx] = true; //뽑았다
//					System.out.println(Arrays.toString(visited));
//					System.out.println(Arrays.toString(dist)+"dist");
					//원래는 인접한 애들을 봐야 하지만 모두가 인접한다
					for(int k = 0; k<N; k++) {
						if(!visited[k] && arr[idx][k] != 0 && dist[k] > arr[idx][k]) {
							dist[k] = arr[idx][k];
						}
					}
				}
				for(int j = 0; j<N; j++) {
					ans += dist[j];
				}

//				System.out.println(Arrays.toString(dist));
//				for(int j = 0; j<N; j++) {
//					System.out.println(Arrays.toString(arr[j]) + " : arr");
//				}
				if(minAns > ans) {
					minAns = ans;
				}
			}
			long result = Math.round(minAns*E);
			System.out.println("#"+tc+" "+result);
		}
		
	}

}
