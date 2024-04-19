package BAEK_1652_누울자리를찾아라;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		char[][] room = new char[N][N];
		
		for(int r = 0; r<N; r++) {
			room[r] = sc.nextLine().toCharArray();
		}
//		for(int r = 0; r<N; r++) {
//			System.out.println(Arrays.toString(room[r]));
//		}
		
		boolean[][] visited = new boolean[N][N];
		
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				if(room[r][c] == '.') {
					visited[r][c] = true;
				}
			}
		}
		
		int isPossible = 0;
		//가로 탐색
		for(int r = 0; r<N; r++) {
			int cnt = 0;
			for(int c = 0; c<N; c++) {
				if(room[r][c] == '.') {
					cnt++;
				}

				if(room[r][c] == 'X') {
					if(cnt >= 2) {
						isPossible++;
					}
					cnt = 0;
				}
				if(c == N-1) {
					if(cnt >= 2) {
						isPossible++;
					}
				}
			}
		}
		System.out.print(isPossible);
		isPossible = 0;
		for(int c = 0; c<N; c++) {
			int cnt = 0;
			for(int r = 0; r<N; r++) {
				if(room[r][c] == '.') {
					cnt++;
				}
				if(room[r][c] == 'X') {
					if(cnt >= 2) {
						isPossible++;
					}
					cnt = 0;
				}
				if(r == N-1) {
					if(cnt >= 2) {
						isPossible++;
					}
				}
			}
		}
		System.out.println(" "+isPossible);
	}

}
