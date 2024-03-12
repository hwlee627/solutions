package BAEK_11047_동전0_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int idx = 0;
		int coinCnt = 0;
		int targetValue = 0;
		while(st.hasMoreTokens()) {
			if(idx == 0) {
				coinCnt = Integer.parseInt(st.nextToken());
				idx++;
			}else {
				targetValue = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println(coinCnt);
		int[] coin = new int[coinCnt];
		for(int i = 0; i<coinCnt; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for(int i = coinCnt-1; i>=0; i--) {
			
			if(targetValue>=coin[i]) {
				cnt += targetValue/coin[i];
				targetValue = targetValue - (targetValue/coin[i])*coin[i];
			}
			if(targetValue == 0) {
				break;
			}
		}
		System.out.println(cnt);

	}

}
