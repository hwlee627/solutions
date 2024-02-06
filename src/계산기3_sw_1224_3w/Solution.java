package 계산기3_sw_1224_3w;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int topChar = -1;
	static int topInt = -1;
	static int a = 0;
	static int b = 0;
	public static void main(String args[]) throws Exception
	{
		Map<Character, Integer> priority = new HashMap<Character, Integer>();
		
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('/', 2);
		priority.put('*', 2);
		priority.put('(', 0);
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int length = sc.nextInt();
			char[] stack = makeStack(length);
			
			String cal = sc.next();
			String postfix = "";
			for(int i = 0; i<cal.length(); i++) {
				char c = cal.charAt(i);
				
				if(c == '(') {
					push(c, stack);
				}else if(c == ')') {
					while(peek(stack) != '(') {
						postfix += pop(stack);
					}
					pop(stack);
				}else if('0' <= c && c <= '9') {
					postfix += c;
				}else {
					//사칙연산
					if(isEmpty()) {
						push(c, stack);
					}else {
						while(!isEmpty() && priority.get(c) <= priority.get(peek(stack))) {
							postfix += pop(stack);
						}
						push(c, stack);
					}
				}
			}
			int[] calStack = makeIntStack(postfix.length());
			int sum = 0;
			for(int i = 0; i<postfix.length(); i++) {
				char d = postfix.charAt(i);
				
				if('0' <= d && d <= '9') {
					int num = Character.getNumericValue(d);
					push(num,calStack);
					int a = peek(calStack);
					sum += a;
	
					
				}else if(d == '*') {
					multiple(calStack);
	
				}else if(d == '/') {
					divide(calStack);
	
				}else if(d == '+') {
					plus(calStack);

				}else if(d == '-') {
					minus(calStack);

				}


			}
			System.out.println("#"+test_case+" "+peek(calStack));
			
			
			
			
		}
	}
	public static char[] makeStack(int length) {
		char[] stack = new char[length];
		
		return stack;
	}
	public static boolean isEmpty() {
		return topChar == -1;
	}
	public static boolean isFull(char[] stack) {
		
		return topChar == stack.length -1 ;
	}
	
	public static void push(char data, char[] stack) {
		
		if(isFull(stack)) {
			return;
		}
		
		stack[++topChar] = data;
	}
	
	public static char pop(char[] stack) {
		
		if(isEmpty()) {
			return ' ';
		}
		
		return stack[topChar--];
	}
	
	public static char peek(char[] stack) {
		return stack[topChar];
	}
	public static int[] makeIntStack(int length) {
		int[] stack = new int[length];
		
		return stack;
	}
	public static boolean isIntEmpty() {
		return topInt == -1;
	}
	public static boolean isIntFull(int[] stack) {
		
		return topInt == stack.length -1 ;
	}
	
	public static void push(int data, int[] stack) {
		
		if(isIntFull(stack)) {
			return;
		}
		
		stack[++topInt] = data;
	}
	
	public static int pop(int[] stack) {
		
		if(isIntEmpty()) {
			return ' ';
		}
		
		return stack[topInt--];
	}
	
	public static int peek(int[] stack) {
		return stack[topInt];
	}
	public static void multiple(int[] stack) {
		
		if(isIntEmpty()) {
			return;
		}
		push((pop(stack) * pop(stack)), stack);
		
	}
	public static void divide(int[] stack) {
		
		if(isIntEmpty()) {
			return;
		}
		int a = pop(stack);
		int b = pop(stack);
		
		
		push((a/b), stack);
		
	}
	public static void plus(int[] stack) {
		
		if(isIntEmpty()) {
			return;
		}
		int a = pop(stack);
		int b = pop(stack);
		push((a+b), stack);
	}
	public static void minus(int[] stack) {
		
		if(isIntEmpty()) {
			return;
		}
		int a = pop(stack);
		int b = pop(stack);
		
		push((a-b), stack);
	}
}


