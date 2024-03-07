package SWEA_4698_테네스씨의특별한소수_2w;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		//에라토스테네스의 체 사용
		//범위는 1000000까지임
		boolean[] prime = new boolean[1000001];
		//소수 = false 소수 아니면 true
		prime[0] = false;
		prime[1] = false;
		
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
//		for(int primes : primeList) {
//			System.out.println(primes);
//		}
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String D = sc.next();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int specialCnt = 0;
			
			for(int special : primeList) {
				if(A<=special && special<=B) {
					boolean find = false;
					String str = ""+special+"";
					if(str.contains(D)) {
						find = true;
					}
					if(find) {
						specialCnt++;
					}
				}else {
					continue;
				}
			}
			
			System.out.println("#"+test_case+" "+specialCnt);
		}
	}
}
