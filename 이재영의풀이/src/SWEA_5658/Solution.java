package SWEA_5658;

// 보물상자비밀번호
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int num = N / 4;
			int K = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			String str = sc.next();
			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				if (c == 'A') {
					queue.add(10);
				} else if (c == 'B') {
					queue.add(11);
				} else if (c == 'C') {
					queue.add(12);
				} else if (c == 'D') {
					queue.add(13);
				} else if (c == 'E') {
					queue.add(14);
				} else if (c == 'F') {
					queue.add(15);
				} else {
					queue.add(c - 48);
				}
			}

			List<Integer> list = new ArrayList<>();

			
			for (int k = 0; k < num; k++) {
				for (int i = 0; i < 4; i++) {
					Stack<Integer> stack = new Stack<>();
					for (int j = 0; j < num; j++) {
						stack.push(queue.peek());
						queue.add(queue.poll());
					}
					int tmp = getPw(stack);
					if(list.contains(tmp)) {
						continue;
					}else {
						list.add(tmp);
					}
				}
				queue.add(queue.poll());
			}
			Collections.sort(list);
			Collections.reverse(list);
			System.out.printf("#%d %d\n", tc, list.get(K-1));
		}
	}

	static int getPw(Stack<Integer> stack) {

		int result = 0;
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			result += stack.pop() * Math.pow(16, i);
		}
		return result;
	}
}