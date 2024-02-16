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
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		//에라토스테네스의 체 사용
		//범위는 1000000까지임
		boolean[] prime = new boolean[1000001];
		//소수 = false 소수 아니면 true
		prime[0] = true;
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
