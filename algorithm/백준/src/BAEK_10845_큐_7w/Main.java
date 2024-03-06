package BAEK_10845_큐_7w;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		sc.nextLine();
		Queue<Integer> q = new LinkedList<Integer>();
		int back = 0;
		for(int i = 1; i<=N; i++) {
			String str = sc.nextLine();
			String[] arr = str.split(" ");
			
			
			if(arr.length == 2) {
				int num = Integer.parseInt(arr[1]);
				q.add(num);
				back = num;
			}else {
				if(str.equals("pop")) {
					if(q.isEmpty()) {
						sb.append("-1\n");
					}else {
						int a = q.poll();
						sb.append(a+"\n");
					}
				}else if(str.equals("size")) {
					int a = q.size();
					sb.append(a+"\n");
				}else if(str.equals("empty")) {
					if(q.isEmpty()) {
						sb.append("1\n");
					}else {
						sb.append("0\n");
					}
				}else if(str.equals("back")) {
					if(q.isEmpty()) {
						sb.append("-1\n");
					}else {
//						Object[] nums = q.toArray();
//						int a = (int) nums[nums.length-1];
//						sb.append(a+"\n");
						sb.append(back+"\n");
					}
				}else if(str.equals("front")) {
					if(q.isEmpty()) {
						sb.append("-1\n");
					}else {
						int a = q.peek();
						sb.append(a+"\n");
					}
				}
			}
		}
		System.out.println(sb);

	}

}
