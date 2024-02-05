package 제로_sw_8931_3w;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{	static int top = -1;
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

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int length = sc.nextInt();
			int[] stack = new int[length];
			
			for(int i = 0; i<length; i++) {
				int data = sc.nextInt();
				if(data != 0) {
					push(data, stack);
				}else {
					if(isEmpty()) {
						continue;
					}else {
						pop(stack);
					}
					
				}
				
			}
			if(!isEmpty()) {
				int sum = sum(stack);
				System.out.println("#"+test_case+" "+sum);
			}else {
				System.out.println("#"+test_case+" "+0);
			}
			
			
			
		}
	}
	
	public static int[] makeStack(int length) {
		int[] intStack = new int[length];
		
		return intStack;
	}
	
	public static boolean isEmpty() {
		
		return top == -1;
	}
	
	public static boolean isFull(int[] stack) {
		
		return top == stack.length -1;
	}
	
	public static void push(int data, int[] stack) {
		
		if(isFull(stack)) {
			return;
		}
		
		stack[++top] = data;
	}
	
	public static int pop(int[] stack) {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		return stack[top--];
	}
	public static int sum(int[] stack) {
		int sum =0;
		for(int i = 0; i<=top; i++) {
			sum += stack[i];
		}
		return sum;
	}
	
}
