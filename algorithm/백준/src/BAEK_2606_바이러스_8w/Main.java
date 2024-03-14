package BAEK_2606_바이러스_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
static int N;
static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int T = Integer.parseInt(br.readLine());
		
		boolean[] infected = new boolean[N];
		boolean[][] con = new boolean[N][N];									
		
		visited = new boolean[N]; //첫째 배열은 각 노드가 감염이 되었는가 안되었는가
		visited[0] = true;									 //둘째 배열은 각 노드가 서로 연결이 되었는가 안되었는가
		infected[0] = true;
		for(int i = 0 ; i<T; i++) {
			String str = br.readLine();
			String[] str2 = str.split(" ");
			int[] nums = new int[2];
			for(int j = 0; j<2; j++) {
				nums[j] = Integer.parseInt(str2[j]) - 1;
			}
			con[nums[0]][nums[1]] = true;
			con[nums[1]][nums[0]] = true;
			
		}
			find(0, con);
			int cnt = 0;
		for(int i = 0; i<N; i++) {
			if(visited[i]) {
				cnt++;
			}
		}
		System.out.println(cnt-1);
	}

	private static void find(int i, boolean[][] con) {
		
		
		for(int j = 0; j<N; j++) {
			if(con[i][j] && !visited[j]) {
				visited[j] = true;
				find(j, con);
				
			}
		}
		return;
	}

}
