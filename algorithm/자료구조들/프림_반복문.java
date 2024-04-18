import java.util.Arrays;
import java.util.Scanner;

public class 프림_반복문 {
	
	static final int INF = Integer.MAX_VALUE; //아주 큰 값으로 초기화 !
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); //1부터 시작
		int E = sc.nextInt();
		
		//인접행렬
		int[][] arr = new int[V+1][V+1];
		
		for(int i = 0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();

			//무향그래프
//			
//			arr[A][B] = arr[B][A] = W;
//			
			//유향그래프
			arr[A][B] = W;
		}
		
		boolean[] visited = new boolean[V+1]; //고를 때 true !
		int[] p = new int[V+1];
		int[] dist = new int[V+1]; //가장 작은 비용을 저장하기 위한 배열
		
		//dist 초기화!
		for(int i = 0; i<V+1; i++) {
			dist[i] = INF;
			p[i] = -1;
		}
		
		//임의의 한 점을 선택하여 돌리기
		//1번 선택함 !
		dist[sc.nextInt()] = 0;
		int tar = sc.nextInt();
		int ans = 0;
		for(int i = 0; i<V+1; i++) {
			int min = INF;
			int idx = 0;
			//아직 안 뽑힌 정점들 중 가장 작은 값
			for(int j = 0; j<V+1; j++) {
				if(!visited[j] && min>dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			// min과 idx가 도출 (방문하지 않은 정점 중 가장 작은 비용을 가지고 있는 곳이 선택됨)
			visited[idx] = true; //뽑았다 !
			
			// 인접한 정점을 봐야함
			// 인접하면서, 방문하지 않았고, 비용이 현재 담긴 값보다 작은가
			
			for(int j = 0; j<V; j++) {
				if(!visited[j] && arr[idx][j] != 0 && dist[j] > arr[idx][j]) {
					dist[j] = arr[idx][j];
					p[j] = idx;
				}
			}

		}
		for(int i = 0; i<V+1; i++) {
			ans += dist[i];
		}
		for(int i = 0; i<V+1; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println(ans);
	}

}
