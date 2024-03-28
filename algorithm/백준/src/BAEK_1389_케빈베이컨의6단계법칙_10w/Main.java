package BAEK_1389_케빈베이컨의6단계법칙_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] cnt;
	static int N, M;
	static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		
		//인접 행렬
			arr = new int[N+1][N+1];
		
		for(int i = 0; i<M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
//				System.out.println("A : "+A+" B : "+B);
				
				
				arr[A][B] = arr[B][A] = 1;
			}
		}
		cnt = new int[N+1];
		for(int i = 0; i<=N; i++) {
			cnt[i] = 101;
			
		}
		int[] sums = new int[N+1];
		int min = 100000;
		for(int i = 1; i<=N; i++) {
			int sum = 0;
			for(int j = 0; j<=N; j++) {
				cnt[j] = 101;
				
			}
			meet(i);
//			System.out.println(Arrays.toString(cnt));
			for(int j = 1; j<=N; j++) {
				sum += cnt[j];
			}
			if(min > sum) {
				min = sum;
			}
			sums[i] = sum;
		}
//		System.out.println(Arrays.toString(sums));
		for(int i = 1; i<=N; i++) {
			if(sums[i] == min) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void meet(int start) {
		boolean[] visited = new boolean[N+1];
		cnt[start] = 0;
		
		
		//인접찾기
		
		//모든 사람을 만날 때 까지 돌리기
		for(int i = 0; i<=N; i++) {
			int min = 101;
			int idx = -1;
			
			for(int j = 0; j<=N; j++) {
				if(!visited[j] && min>cnt[j]) {
					min = cnt[j];
					idx = j;
				}
			}
			
			if(idx == -1) {
				break;
			}
			
			visited[idx] = true;
			for(int j = 1; j<=N; j++) {
				if(arr[idx][j] == 1) {
					int m = j;
					if(!visited[m] && cnt[m] > cnt[idx] + 1) {
						cnt[m] = cnt[idx] + 1;
					}
				}
			}
			
		}
	}

}
