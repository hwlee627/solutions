package BAEK_2164_카드2_7w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i<=N; i++) {
			q.add(i);
		}
		//
		while(q.size()>1) {
			q.poll();
			int tmp = q.poll();
			q.offer(tmp);
		}
		System.out.println(q.poll());
	}

}
