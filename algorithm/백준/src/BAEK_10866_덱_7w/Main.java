package BAEK_10866_덱_7w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Deque<Integer> d = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			String[] arr = str.split(" ");

			if (arr.length == 2) {
				int num = Integer.parseInt(arr[1]);
				String[] arr2 = arr[0].split("_");
//				System.out.println(Arrays.toString(arr2));
				if (arr2[0].equals("push")) {
					if (arr2[1].equals("front")) {
						d.addFirst(num);
					} else if (arr2[1].equals("back")) {
						d.addLast(num);
					}
				}
			} else {
				String[] arr2 = str.split("_");
//				System.out.println(Arrays.toString(arr2));
				if (arr2.length == 2) {
					if (arr2[1].equals("front")) {
						if (d.isEmpty()) {
							sb.append("-1\n");
						} else {
							int a = d.pollFirst();
							sb.append(a + "\n");
						}
					} else if (arr2[1].equals("back")) {
						if (d.isEmpty()) {
							sb.append("-1\n");
						} else {
							int a = d.pollLast();
							sb.append(a + "\n");
						}
					}
				} else {
					if (str.equals("size")) {
						int a = d.size();
						sb.append(a + "\n");
					} else if (str.equals("empty")) {
						if (d.isEmpty()) {
							sb.append("1\n");
						} else {
							sb.append("0\n");
						}
					} else if (str.equals("front")) {
						if (d.isEmpty()) {
							sb.append("-1\n");
						} else {
							int a = d.peekFirst();
							sb.append(a + "\n");
						}
					} else if (str.equals("back")) {
						if (d.isEmpty()) {
							sb.append("-1\n");
						} else {
							int a = d.peekLast();
							sb.append(a + "\n");
						}
					}
				}
			}
		}
		System.out.println(sb);

	}

}
