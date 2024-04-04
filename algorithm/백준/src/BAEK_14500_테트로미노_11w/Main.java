package BAEK_14500_테트로미노_11w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int r, c, level, value;

		public Node(int r, int c, int level, int value) {
			this.r = r;
			this.c = c;
			this.level = level;
			this.value = value;
		}
		
	}
	static int maxSum, N, M, maxNum;
	static int arr[][];
	static boolean[][] visited, dfsvisited;
	static int[] dr, dc;
	static Node[] tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i<N; i++) {
			String nums = br.readLine();
			st = new StringTokenizer(nums);
			while(st.hasMoreTokens()) {
				for(int j = 0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		int result = 0;
		maxNum = 0;
		dr = new int[] {-1,1,0,0};
		dc = new int[] {0,0,-1,1};
		
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<M; c++) {
				visited[r][c] = true;
				Node start = new Node(r,c,0, arr[r][c]);
				tmp = new Node[4];
				tmp[0] = start;
				dfs(start);
				visited[r][c] = false;
				//dfs는 빠큐 모양을 탐색을 안함ㅜ
				middle(r,c);
			}
		}

		
		System.out.println(maxNum);
		
	}
	private static void middle(int r, int c) {
		int max = 0;
		//하..
		//위 튀어나온 것
		int[] dr1 = new int[] {0,1,1,1};
		int[] dc1 = new int[] {0,-1,0,1};
		boolean d1 = true;
		int sum1 = 0;
		//오른쪽 튀어나온 것
		int[] dr2 = new int[] {0,1,2,1};
		int[] dc2 = new int[] {0,0,0,1};
		boolean d2 = true;
		int sum2 = 0;
		//아래로 튀어나온 것
		int[] dr3 = new int[] {0,0,0,1};
		int[] dc3 = new int[] {0,1,2,1};
		boolean d3 = true;
		int sum3 = 0;
		//왼쪽으로 튀어나온 것
		int[] dr4 = new int[] {0,-1,0,1};
		int[] dc4 = new int[] {0,1,1,1};
		boolean d4 = true;
		int sum4 = 0;
		
		for(int d = 0; d<4; d++) {
			int nr1 = dr1[d] + r;
			int nc1 = dc1[d] + c;
			int nr2 = dr2[d] + r;
			int nc2 = dc2[d] + c;
			int nr3 = dr3[d] + r;
			int nc3 = dc3[d] + c;
			int nr4 = dr4[d] + r;
			int nc4 = dc4[d] + c;
			
			if(nr1>=0 && nr1<N && nc1>=0 && nc1<M) {
				sum1 += arr[nr1][nc1];
			}else {
				d1 = false;
				sum1 -= 1000000;
			}
			if(nr2>=0 && nr2<N && nc2>=0 && nc2<M) {
				sum2 += arr[nr2][nc2];
			}else {
				d2 = false;
				sum2 -= 1000000;
			}
			if(nr3>=0 && nr3<N && nc3>=0 && nc3<M) {
				sum3 += arr[nr3][nc3];
			}else {
				d3 = false;
				sum3 -= 1000000;
			}
			if(nr4>=0 && nr4<N && nc4>=0 && nc4<M) {
				sum4 += arr[nr4][nc4];
			}else {
				d4 = false;
				sum4 -= 1000000;
			}
			
			
		}
		if(max < sum1) {
			max = sum1;
		}
		if(max < sum2) {
			max = sum2;
		}
		if(max < sum3) {
			max = sum3;
		}
		if(max < sum4) {
			max = sum4;
		}
		if(maxNum < max) {
			maxNum = max;
		}
		
	}
	private static void dfs(Node node) {
		if(node.level == 3) {
			int sum = 0;
			
			for(Node n : tmp) {
//				System.out.print(n.value);
				sum += n.value;
				
			}
//			System.out.println();
//			System.out.println(sum);
			if(maxNum<sum) {
				maxNum = sum;
			}
			return;
		}
		for(int d = 0; d<4; d++) {
				int nr = dr[d] + node.r;
				int nc = dc[d] + node.c;
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
					
					visited[nr][nc] = true;
					Node tar = new Node(nr, nc, node.level+1, arr[nr][nc]);
					tmp[tar.level] = tar;
					dfs(tar);
					visited[nr][nc] = false;
				}
			}
		
	}
	
	
	
	
	
	//이건 아니야
	
//	private static int sum(int r, int c) {
//		List<Integer> list = new ArrayList<Integer>();
//		
//		int bar = bar(r,c);
//		list.add(bar);
//		int window = window(r,c);
//		list.add(window);
//		int middleFinger = middleFinger(r,c);
//		list.add(middleFinger);
//		int seven = seven(r,c);
//		list.add(seven);
//		
//		Collections.sort(list);
//		maxSum = list.get(list.size()-1);
//		
//		return maxSum;
//	}
//	private static int seven(int r, int c) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	private static int middleFinger(int r, int c) {

//	}
//	private static int window(int r, int c) {
//		//창문 모양
//		int[] dr1 = new int[] {0,0,1,1};
//		int[] dc1 = new int[] {0,1,0,1};
//		
//		boolean d1 = true;
//		int sum1 = 0;
//		for(int d = 0; d<4; d++) {
//			int nr1 = dr1[d] + r;
//			int nc1 = dc1[d] + c;
//			if(nr1>=0 && nr1<N && nc1>=0 && nc1<M) {
//				sum1 += arr[nr1][nc1];
//			}else {
//				d1 = false;
//			}
//		}
//		if(d1) {
//			return sum1;
//		}else {
//			return -1;
//		}
//		
//	}
//	private static int bar(int r, int c) {
//		//누운 바
//		int[] dr1 = new int[] {0,0,0,0};
//		int[] dc1 = new int[] {0,1,2,3};
//		
//		//서있는 바
//		int[] dr2 = new int[] {0,1,2,3};
//		int[] dc2 = new int[] {0,0,0,0};
//		
//		int sum1 = 0;
//		int sum2 = 0;
//		boolean d1 = true;
//		boolean d2 = true;
//		for(int d = 0; d<4; d++) {
//			int nr1 = dr1[d] + r;
//			int nc1 = dc1[d] + c;
//			int nr2 = dr2[d] + r;
//			int nc2 = dc2[d] + c;
//			
//			if(nr1>=0 && nr1<N && nc1>=0 && nc1<M) {
//				sum1 += arr[nr1][nc1];
//			}else {
//				d1 = false;
//			}
//			if(nr2>=0 && nr2<N && nc2>=0 && nc2<M) {
//				sum2 += arr[nr2][nc2];
//			}else {
//				d2 = false;
//			}
//			
//
//		}
//		if(d1 && d2) {
//			if(sum1 >= sum2) {
//				return sum1;
//			}else {
//				return sum2;
//			}
//		}else if(!d1 && d2) {
//			return sum2;
//		}else if(d1 && !d2) {
//			return sum1;
//		}else {
//			return -1;
//		}
//	}

}
