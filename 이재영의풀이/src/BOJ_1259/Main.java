package BOJ_1259;

// 팰린드롬수
// 스택을 이용하여 비교
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();

		while (true) {
			String str = sc.next();
			if (str.equals("0")) {
				break;
			}
			for (int i = 0; i < str.length(); i++) {
				stack.push(str.charAt(i));
			}
			boolean isPalindrome = true;
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i)!=stack.pop()) {
					isPalindrome = false;
				}
			}
			if(isPalindrome) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
}
