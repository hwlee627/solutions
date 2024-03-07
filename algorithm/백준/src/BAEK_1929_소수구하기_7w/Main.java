package BAEK_1929_소수구하기_7w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int idx = 0;
		int[] nums = new int[2];
		while(st.hasMoreTokens()) {
			
			nums[idx] = Integer.parseInt(st.nextToken());
			idx++;
		}
//		System.out.println(Arrays.toString(nums));
		int N = nums[0];
		int M = nums[1];
		
		boolean[] prime = new boolean[1000001];
		//소수 = false 소수 아니면 true
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i < Math.sqrt(1000000); i++) {
			if(!prime[i]) {
				for(int j = i*i; j<=1000000; j+=i) {
					prime[j] = true;
				}
			}
		}
		List<Integer> primeList = new ArrayList<Integer>();
		
		for(int i = 0; i < prime.length; i++) {
			if(!prime[i]) {
				primeList.add(i);
			}
		}
		
		for(int primeNum : primeList) {
			if(primeNum>=N && primeNum<=M) {
				sb.append(primeNum+"\n");
			}
			if(primeNum > M) {
				break;
			}
		}
		System.out.println(sb);
	}

}
