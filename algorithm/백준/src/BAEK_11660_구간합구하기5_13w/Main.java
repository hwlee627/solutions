package BAEK_11660_구간합구하기5_13w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		int T = sc.nextInt();
		
		
		int[][] arr = new int[N][N];
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int[][] sumArr = new int[N][N];
		for(int r = 0; r<N; r++) {
			int sum = 0;
			for(int c = 0; c<N; c++) {
				if(r == 0) {
					sum += arr[r][c];
					sumArr[r][c] = sum;
				}else {
					sum += arr[r][c];
					sumArr[r][c] = sumArr[r-1][c]+sum;
				}
			}
		}
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(sumArr[i]));
//		}
		
		for(int i = 0; i<T; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int sum = 0;
			
			if(x1 == x2 && y1==y2) {
				sum = arr[x1-1][y1-1];
			}else if(x1 == 1 && y1 == 1){
				sum = sumArr[x2-1][y2-1];
			}else if(y1 == 1) {
				sum = sumArr[x2-1][y2-1] - sumArr[x1-2][y2-1];
			}else if(x1 == 1) {
				sum = sumArr[x2-1][y2-1] - sumArr[x2-1][y1-2];
			}else {
				sum = sumArr[x2-1][y2-1] +sumArr[x1-2][y1-2]-sumArr[x1-2][y2-1]-sumArr[x2-1][y1-2];
			}
			sb.append(sum+"\n");
			
		}
		System.out.println(sb);

	}

}
