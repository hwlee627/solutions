package SWEA_4013;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			LinkedList<Integer> mg1 = new LinkedList<>();
			LinkedList<Integer> mg2 = new LinkedList<>();
			LinkedList<Integer> mg3 = new LinkedList<>();
			LinkedList<Integer> mg4 = new LinkedList<>();

			LinkedList[] mg = { mg1, mg2, mg3, mg4 };

			int K = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				mg1.add(sc.nextInt());
			}
			for (int i = 0; i < 8; i++) {
				mg2.add(sc.nextInt());
			}
			for (int i = 0; i < 8; i++) {
				mg3.add(sc.nextInt());
			}
			for (int i = 0; i < 8; i++) {
				mg4.add(sc.nextInt());
			}

			for (int i = 0; i < K; i++) {

				int mgNum = sc.nextInt() - 1;
				int direction = sc.nextInt();
				boolean[] turn = turnable(mg1, mg2, mg3, mg4);
				if (direction == 1) {
					clockwise(mg[mgNum]);
				} else {
					counter(mg[mgNum]);
				}
				int left = mgNum - 1;
				int right = mgNum;
				int left_dir = direction;
				int right_dir = direction;

				while (left >= 0 && turn[left] == true) {
					if (left_dir == 1) {
						counter(mg[left--]);
						left_dir = 0;
					} else {
						clockwise(mg[left--]);
						left_dir = 1;
					}
				}
				while (right + 1 <= 3 && turn[right] == true) {
					if (right_dir == 1) {
						counter(mg[++right]);
						right_dir = 0;
					} else {
						clockwise(mg[++right]);
						right_dir = 1;
					}
				}

			}
			int score = 0;
			if (mg1.get(0) == 1) {
				score += 1;
			}
			if (mg2.get(0) == 1) {
				score += 2;
			}
			if (mg3.get(0) == 1) {
				score += 4;
			}
			if (mg4.get(0) == 1) {
				score += 8;
			}
			System.out.printf("#%d %d\n", test_case, score);
		}
	}

	static boolean[] turnable(LinkedList<Integer> mg1, LinkedList<Integer> mg2, LinkedList<Integer> mg3,
			LinkedList<Integer> mg4) {

		boolean[] result = new boolean[3];

		if (mg1.get(2) == mg2.get(6)) {
			result[0] = false;
		} else {
			result[0] = true;
		}
		if (mg2.get(2) == mg3.get(6)) {
			result[1] = false;
		} else {
			result[1] = true;
		}
		if (mg3.get(2) == mg4.get(6)) {
			result[2] = false;
		} else {
			result[2] = true;
		}
		return result;
	}

	static void clockwise(LinkedList<Integer> ll) {
		ll.addFirst(ll.pollLast());
	}

	static void counter(LinkedList<Integer> ll) {
		ll.addLast(ll.pollFirst());
	}
}