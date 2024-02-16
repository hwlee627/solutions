package BAEK_10163_색종이_3w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int maxX= 0;
		int maxY= 0;
		//정보 저장해놓기
		int[] infoX = new int[N*2];
		int[] infoY = new int[N*2];
		int index = 0;
		for(int paper = 0; paper < N; paper++) {
			
			
			int startRow = sc.nextInt();
			int startCol = sc.nextInt();
			int rowLength = sc.nextInt();
			int colLength = sc.nextInt();
//			System.out.println(startRow+" "+startCol+" "+rowLength+" "+colLength);
			//색종이 시작지점
			int X = startRow;
			int Y = startCol;
			infoX[index] = X;
			infoY[index] = Y;
			index++;
			//색종이 끝 지점
			int endX = startRow + rowLength-1;
			int endY = startCol + colLength-1;
			infoX[index] = endX;
			infoY[index] = endY;
			index++;
			
			if(maxX < endX) {
				maxX = endX;
			}
			if(maxY < endY) {
				maxY = endY;
			}
		}
		int[][] dimension = new int [maxX+1][maxY+1];
		
		for(int i = 0; i<infoX.length; i++) {
			if(i % 2 == 0) {
				for(int r = infoX[i]; r<=infoX[i+1]; r++) {
					for(int c = infoY[i]; c<=infoY[i+1]; c++) {
						dimension[r][c] = (i/2 + 1);
					}
				}
			}
		}
		//출력
//		for(int r = 0; r<maxX+1; r++) {
//			for(int c = 0; c<maxY+1; c++) {
//				System.out.printf("%3d", dimension[r][c]);
//			}
//			System.out.println();
//		}
		for(int i = 1; i<=N; i++) {
			int count = 0;
		for(int r = 0; r<maxX+1; r++) {
			for(int c = 0; c<maxY+1; c++) {
				
					if(i == dimension[r][c]) {
						++count;
						
					}
				
			}
		}
		System.out.println(count);
		}
		

	}

}
