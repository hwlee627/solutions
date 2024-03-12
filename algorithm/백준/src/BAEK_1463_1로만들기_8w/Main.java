package BAEK_1463_1로만들기_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//1. 3의 배수 :: 3으로 나누기
		//2. 나머지 1 :: -1 후 3으로 나누기
		//3. 나머지 2 :: 짝수 / 나누기 2    홀수 / -1 후 나누기 2
		//4. 16일때. 뭔데 너
		//Dp...
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		int cnt = 0;
		if(num == 1) {
			cnt = 0;
		}
		
		while(num>1) {
			if(num == 16) {
				cnt = cnt + 4;
				num = 1;
			}else {
				if(num % 6 == 0) {
					
				}
				if(num % 3 == 0) {
					num = num/3;
					cnt++;
				}else if(num % 3 == 1) {
					num = num - 1;
					cnt++;
					num = num /3;
					cnt++;
				}else {
					if(num % 2 == 0) {
						num = num/2;
						cnt++;
					}else {
						num = num - 1;
						cnt++;
						num = num/2;
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}

}
