package 나머지_bj_3052_3w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int [10];
		
		for(int i = 0; i<10; i++) {
			nums[i] = sc.nextInt();
		}
		
		//42로 나눈 나머지들을 담아 놓을 카운트 배열 생성
		//나머지는 0 ~ 41 이므로 길이는 42.
		int[] count = new int [42];
		
		//나머지 값을 인덱스로하여 값 더해줌
		for(int i = 0; i<10; i++) {
			count[nums[i]%42]++;
		}
		
		//카운트 배열을 순회하여 0이 아닌 값의 개수를 구하면
		//서로 다른 숫자의 개수를 알 수 있음
		int cnt = 0;
		for(int i = 0; i<42; i++) {
			if(count[i] !=0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
