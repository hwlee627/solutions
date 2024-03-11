package BAEK_1874_스택수열_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		boolean isOK = true;
		int num = 1;
		for (int i = 0; i < N; i++) {
			int addNum = Integer.parseInt(br.readLine());
			
			for(; num<=addNum ; num++) {
				stack.add(num);
				sb.append("+\n");
			}
			if(stack.peek() == addNum) {
				stack.pop();
				sb.append("-\n");
			}else {
				isOK = false;
			}
		}
		
		if(isOK) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}

}
