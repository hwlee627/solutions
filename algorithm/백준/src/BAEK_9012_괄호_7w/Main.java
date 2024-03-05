package BAEK_9012_괄호_7w;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		for(int i = 1; i<=N; i++) {
			String str = sc.nextLine();
			char[] vps = new char[str.length()];
			System.out.println(str);
			for(int j = 0; j<vps.length; j++) {
				vps[j] = str.charAt(j);
			}
			int[] arr = new int[str.length()];
			for(int j = 0; j<arr.length; j++) {
				if(vps[j] == '(') {
					arr[j] = 0;
				}else {
					arr[j] = 1;
				}
			}
			Stack<Integer> stack = new Stack<>();
			boolean isOk = true;
			for(int j = 0; j<arr.length; j++) {
				if(!stack.isEmpty()) {
					if(arr[j] == 0) {
						stack.add(arr[j]);
					}else {
						stack.pop();
					}
				}else {
					if(arr[j] == 1) {
						isOk = false;
					}else {
						stack.add(arr[j]);
					}
				}
			}
			if(!stack.isEmpty()) {
				isOk = false;
			}
			if(isOk) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
//			System.out.println(Arrays.toString(arr));
//			if(stack.isEmpty()) {
//				System.out.println("YES");
//			}else {
//				System.out.println("NO");
//			}
//			System.out.println(Arrays.toString(vps));

		}
		

	}

}
