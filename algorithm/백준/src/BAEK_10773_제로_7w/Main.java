package BAEK_10773_제로_7w;

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
		
		for(int i = 1; i<=N; i++) {
			int M = Integer.parseInt(br.readLine());
			if(M != 0) {
				stack.add(M);
			}else {
				stack.pop();
			}
			
		}
		if(stack.isEmpty()) {
			sb.append(0);
		}else {
			int sum = 0;
			boolean run = true;
			while(run) {
				sum+=stack.pop();
				if(stack.isEmpty()) {
					run = false;
					sb.append(sum);
				}
			}
		}
		System.out.println(sb);
	}

}
