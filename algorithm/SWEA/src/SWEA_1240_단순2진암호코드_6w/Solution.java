package SWEA_1240_단순2진암호코드_6w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		Scanner sc= new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int test = 1; test<=T; test++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			int[][] password = new int[H][W];
			
				;
				for(int r = 0; r<H; r++) {
					String nums = sc.next();
					for(int c = 0; c<W; c++) {
						password[r][c] = nums.charAt(c)-48;
					}
				}
			
			int indexR = 0;
			for(int r = 0; r<H; r++) {
				for(int c = 0; c<W; c++ ) {
					if(password[r][c] != 0) {
						indexR = r;
						break;
					}
				}
			}
			int indexC = 0;
			for(int c = 0; c<W; c++) {
				if(password[indexR][c] != 0) {
					if(indexC<c) {
						indexC = c;
					}
				}
			}
			int[] passArr = new int[56];
			for(int i = 0; i<56; i++) {
				passArr[i] = password[indexR][indexC-55];
				indexC++;
			}
			System.out.println(Arrays.toString(passArr));
		}
		
		
	}

}
