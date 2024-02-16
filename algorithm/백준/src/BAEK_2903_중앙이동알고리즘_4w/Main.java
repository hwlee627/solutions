package BAEK_2903_중앙이동알고리즘_4w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//초기상태 점 4개로 이루어진 정사각형 => 한 변의 길이가 점 2개인 정사각형
		//N = 1
		//2개 + (2-1) = 3 -> 한 변의 길이가 점 3개인 정사각형
		//N = 2
		//3개 + (3-1) = 5 -> 한 변의 길이가 점 5개인 정사각형
		
		//초기상태 설정
		int dot = 4;
		int length = 2;
		
		for(int i = 1; i<=N; i++) {
			length = length + (length-1);
			dot = length * length;
		}
		System.out.println(dot);
	}

}
