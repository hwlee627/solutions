package 직사각형_bj_2527_3w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 4;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int[] X = new int[4];
			int[] Y = new int[4];
			int indexX = 0;
			int indexY = 0;
			for(int i = 0; i<8; i++) {
				if(i % 2 == 0) {
					X[indexX] = sc.nextInt();
					indexX++;
				}else {
					Y[indexY] = sc.nextInt();
					indexY++;
				}
			}
			int maxX = 0;
			int maxY = 0;
			for(int i = 0; i<4; i++) {
				if(maxX < X[i]) {
					maxX = X[i];
				}
				if(maxY < Y[i]) {
					maxY = Y[i];
				}
			}
			//첫번째 직사각형의 좌표 범위를 2라고 두고
			//두번째 직사각형의 좌표 범위를 3이라고 두자
			//두 직사각형의 좌표 범위가 겹친다면 1을 표시하게 한다.
			//1, 2, 3이 모두 나온다면 겹친 상태
			
			int[] rangeX = new int [maxX+1];
			int[] rangeY = new int [maxY+1];
			
			for(int i = X[0]; i<=X[1]; i++) {
				rangeX[i] = 2;
			}
			for(int i = X[2]; i<=X[3]; i++) {
				if(rangeX[i] != 0) {
					rangeX[i] = 1;
				}
				
			}
			for(int i = Y[0]; i<=Y[1]; i++) {
				rangeY[i] = 2;
			}
			for(int i = Y[2]; i<=Y[3]; i++) {
				if(rangeY[i] != 0) {
					rangeY[i] = 1;
				}
				
			}
			//1. 1이 없으면 겹치지 않은 상태 - d 출력
			//2. 1이 있으나 1개씩이면 점으로 겹친 상태 - c 출력
			//3. 1이 있으나 X좌표 혹은 Y좌표에서 1개와 다수 상태인 경우 선분으로 겹친 상태 - b 출력
			//4. X좌표와 Y좌표 모두에서 1이 다수인 경우 직사각형으로 겹친 상태 - a 출력
			int cntX = 0;
			int cntY = 0;
			for(int i = 0; i<rangeX.length; i++) {
				if(rangeX[i] == 1) {
					cntX++;
				}
			}
			for(int i = 0; i<rangeY.length; i++) {
				if(rangeY[i] == 1) {
					cntY++;
				}
			}
			
			//점으로 겹친 상태
			if(cntX == 1 && cntY == 1) {
				System.out.println("c");
//				System.out.println("cntX : "+ cntX + " cntY : "+cntY);
			//겹치지 않은 상태
			}else if(cntX == 0 || cntY == 0) {
				System.out.println("d");
//				System.out.println("cntX : "+ cntX + " cntY : "+cntY);
			//선분으로 겹친 상태
			}else if((cntX == 1 && cntY > 1) || (cntX > 1 && cntY == 1) ) {
				System.out.println("b");
//				System.out.println("cntX : "+ cntX + " cntY : "+cntY);
			//직사각형으로 겹친 상태
			}else if(cntX > 1 && cntY > 1){
				System.out.println("a");
//				System.out.println("cntX : "+ cntX + " cntY : "+cntY);
			}
		}

	}

}
