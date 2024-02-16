package BAEK_2999_비밀이메일_3w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		//R<=C
		//R*C = N
		// [R][C]인 행렬 생성하여
		// 열 우선 순회 돌리면 행렬 완성
		// 그 행렬을 행 우선순위로 읽으면
		// 해독한 메세지
		
		String message = sc.next();
		String solve = "";
		int N = message.length();
		
		int R = 0;
		int C = 0;
		
		//제곱근보다 같거나 작은 약수를 구해서
		for(int i = 1; i<=Math.sqrt(N); i++) {
			if(N % i == 0) {
				//최대값이 남게 R이라는 변수에 넣어주기
				if(i > R) {
					R = i;
				}
			}
			//자연스럽게 C는 N에서 R을 나눈 값이 됨
			C = N/R;
		}
		
		//위에서 구한 R과 C로 비밀번호를 담을 배열을 만들어주고
		char[][] password = new char[R][C];
		//열 우선 순회로 배열에 담아준다음
		int index = 0;
		for(int c = 0; c<C; c++) {
			for(int r = 0; r<R; r++) {
				password[r][c] = message.charAt(index);
				index++;
			}
		}
		//행 우선순회로 읽어들여서
		//String 변수로 받아준 후 한번에 출력
		for(int r = 0; r<R; r++) {
			for(int c = 0; c<C; c++) {
				solve += password[r][c];
			}
		}
		System.out.println(solve);
	}

}
