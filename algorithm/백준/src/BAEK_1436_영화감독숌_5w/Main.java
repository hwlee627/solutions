package BAEK_1436_영화감독숌_5w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i = 666; i <= 2666799; i++) {
			String num = Integer.toString(i);
			if(num.contains("666")) {
				cnt++;
				if(cnt == N) {
					System.out.println(num);
				}
			}
		}
		
		
	}

}
