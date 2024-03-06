package BAEK_10828_스택_7w;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		sc.nextLine();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i<N; i++) {
			String str = sc.nextLine();
			String[] arr = str.split(" ");
			if(arr.length == 1) {
				if(str.equals("pop")) {
					if(stack.isEmpty()) {
						sb.append("-1\n");
					}else {
						int a = stack.pop();
						sb.append(a+"\n");
					}
				}else if(str.equals("size")) {
					int a = stack.size();
					sb.append(a+"\n");
				}else if(str.equals("empty")) {
					if(stack.isEmpty()) {
						sb.append("1\n");
					}else {
						sb.append("0\n");
					}
				}else if(str.equals("top")) {
					if(stack.isEmpty()) {
						sb.append("-1\n");
					}else {
						int a = stack.lastElement();
						sb.append(a+"\n");
					}
					
				}
			}else {
				stack.add(Integer.parseInt(arr[1]));
			}
		}
		System.out.println(sb);

	}

}
