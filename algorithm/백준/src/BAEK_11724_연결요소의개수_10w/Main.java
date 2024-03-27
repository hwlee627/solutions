package BAEK_11724_연결요소의개수_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		int N = 0;
		int M = 0;
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		p = new int[N+1];
		for(int i = 0; i<=N; i++) {
			p[i] = i;
		}
		int[][] edges = new int[M][2];
		for(int i = 0; i<M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				edges[i][0] = Integer.parseInt(st.nextToken());
				edges[i][1] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<M; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			
			if(findSet(x) != findSet(y)) {
				union(x,y);
			}
			
		}
		int cnt = 0;
		for(int i = 1; i<=N; i++) {
			if(p[i] == i) {
				cnt++;
			}
		}
		System.out.println(cnt);
//		System.out.println(Arrays.toString(p));
	}
	private static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
		
	}
	private static int findSet(int x) {
		
		if(x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

}
