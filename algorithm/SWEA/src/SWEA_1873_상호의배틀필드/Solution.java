package SWEA_1873_상호의배틀필드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test = 1; test<=T; test++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			//. 평지
			//* 벽돌벽
			//# 강철벽
			//- 물
			// ^>v<
			//벽돌벽과 강철벽을 만날 때 까지 포탄이 날아가고
			//벽돌벽은 파괴, 강철벽은 아무일도 일어나지 않음
			
			char[][] map = new char[H][W];
			int ur = 0;
			int uc = 0;
			for(int i = 0; i<H; i++) {
				String str = sc.next();
				for(int j = 0; j<W; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '<' ||map[i][j] == '>' ||map[i][j] == '^' || map[i][j] == 'v') {
						ur = i;
						uc = j;
						
					}
				}
			}
			
			int input = sc.nextInt();
			
			String inputStr = br.readLine();
			char[] inputArr = new char[input];
			for(int i = 0; i<input; i++) {
				inputArr[i] = inputStr.charAt(i);
			}
			for(int i = 0; i<input; i++) {
				if(inputArr[i] == 'U') {
					if(ur-1 >= 0) {
						if(map[ur-1][uc] == '.') {
							map[ur-1][uc] = '^';
							map[ur][uc] = '.';
							ur = ur-1;
						}else {
							map[ur][uc] = '^';
						}
					}
				}else if(inputArr[i] == 'D') {
					if(ur+1 <= H-1) {
						if(map[ur+1][uc] == '.') {

							map[ur+1][uc] = 'v';
							map[ur][uc] = '.';
							ur = ur+1;
						}else {
							map[ur][uc] = 'v';
						}
					}
				}else if(inputArr[i] == 'L') {
					if(uc-1 >= 0) {
						if(map[ur][uc-1] == '.') {

							map[ur][uc-1] = '<';
							map[ur][uc] = '.';
							uc = uc-1;
						}else {
							map[ur][uc] = '<';
						}
					}
				}else if(inputArr[i] == 'R') {
					if(uc+1 <= W-1) {
						if(map[ur][uc+1] == '.') {
							map[ur][uc] = '>';
							map[ur][uc+1] = '>';
							map[ur][uc] = '.';
							uc = uc+1;
						}
						else {
							map[ur][uc] = '>';
						}
					}
				}else if(inputArr[i] == 'S') {
					if(map[ur][uc] == 'v') {
						for(int s = 1; s<H; s++) {
							if(ur+s <= H) {
								if(map[ur+s][uc] == '*') {
									map[ur+s][uc] = '.';
									break;
								}else if(map[ur+s][uc] == '#') {
									break;
								}
							}
						}
					}else if(map[ur][uc] == '^') {
						for(int s = 1; s<H; s++) {
							if(ur-s >= 0) {
								if(map[ur-s][uc] == '*') {
									map[ur-s][uc] = '.';
									break;
								}else if(map[ur-s][uc] == '#') {
									break;
								}
							}
						}
					}else if(map[ur][uc] == '<') {
						for(int s= 1; s<W; s++) {
							if(uc-s >= 0) {
								if(map[ur][uc-s] == '*') {
									map[ur][uc-s] = '.';
									break;
								}else if(map[ur][uc-s] == '#') {
									break;
								}
							}
						}
					}else if(map[ur][uc] == '>') {
						for(int s= 1; s<W; s++) {
							if(uc+s <= W) {
								if(map[ur][uc+s] == '*') {
									map[ur][uc+s] = '.';
									break;
								}else if(map[ur][uc+s] == '#') {
									break;
								}
							}
						}
					}
				}
			}
			System.out.print("#"+test+" ");
			for(int r = 0; r<H; r++) {
				for(int c = 0; c<W; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
		}

	}

}
