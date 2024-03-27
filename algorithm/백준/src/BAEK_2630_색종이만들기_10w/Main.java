package BAEK_2630_색종이만들기_10w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();// 한 변의 길이
		int[] ables = {2, 4, 8, 16, 32, 64, 128};
		int able = 1;
		int max = 0;
		for(int i = 0; i<ables.length; i++) {
			if(ables[i] == N) {
				max = i+2;
			}
		}
		
		int[][] paper = new int[N][N];
		
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				paper[r][c] = sc.nextInt();
			}
		}
		
		//출력
//		for(int r = 0; r<N; r++) {
//			for(int c = 0; c<N; c++) {
//				System.out.printf("%3d", paper[r][c]);
//			}
//			System.out.println();
//		}
		int blueSum = 0; // 1
		int whiteSum = 0; // 0
		int mod = N;
		while(able<=max) {
			
			if(mod == 1) {
				for(int r = 0; r<N; r++) {
					for(int c = 0; c<N; c++) {
						if(paper[r][c] == 1) {
							blueSum++;
						}else if(paper[r][c] == 0) {
							whiteSum++;
						}
					}
				}
			}else {
//				System.out.println(able + " " + mod);
				for(int r = 0; r<N; r++) {
					for(int c = 0; c<N; c++) {
						if(r % mod == 0 && c % mod == 0) {
							int value = paper[r][c];
//							System.out.println("r : "+r+" c : "+c+" value : "+ value);
							boolean check = true;
							if(value == 3) {
								
							}else {
								for(int a = r; a<r+mod; a++) {
									for(int b = c; b<c+mod; b++) {
//										System.out.println("a : " + a +" b : "+b + "paper[a][b] : ");
										if(!check) {
											break;
										}
										if(value == paper[a][b]) {
											
										}else {
											check = false;
											break;
										}
										
									}
									if(!check) {
										break;
									}
								}
								if(check) {
									if(value == 1) {
										blueSum++;
									}else if(value == 0) {
										whiteSum++;
									}
									for(int a = r; a<r+mod; a++) {
										for(int b = c; b<c+mod; b++) {
//											System.out.println("a2 : " + a +" b2 : "+b);
											paper[a][b] = 3;
										}
									}
//									System.out.println("whiteSum" + whiteSum);
//									System.out.println("blueSum" + blueSum);
//									for(int a = 0; a<N; a++) {
//										System.out.println(Arrays.toString(paper[a]));
//									
//								}
								}
							}

						}
					}
				}
			}
			mod = mod/2;
			able++;
		}
		System.out.println(whiteSum);
		System.out.println(blueSum);
	}

}
