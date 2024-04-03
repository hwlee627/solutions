

import java.util.Arrays;

public class Permutation {
	private static int n, m;  // n = 돌릴 수열의 길이  m = 돌리면서 담아줄 수열의 길이
	private static char[] arr; // 돌리면서 담아줄 수열
	private static char[] nums; // 돌릴 수열
	private static boolean[] visited; 	// 중복 방지 boolean 배열
	public static void main(String[] args) {
		n = 4;
		nums = new char[]{'a', 'b', 'c', 'd'};
		System.out.println(Arrays.toString(nums));
		visited = new boolean[n+1]; // 0은 없으니까
		for(int i = 1; i<=6; i++) {
			m = i;
			arr = new char[m];
			permutation(0); // 순열 조지기, 매개변수는 담아줄 수열의 idx.
		}
		

	}
	private static void permutation(int cnt) {
		if(cnt == m) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i = 1; i<=n; i++) {
//			if(!visited[i]) {		//중복을 허용하는 순열이라면, visited 로직을 제거하면 된다 !
//				visited[i] = true;
				arr[cnt] = nums[i-1];
				permutation(cnt + 1);
//				visited[i] = false; // 다시 false를 해주어야 하는 이유: 순열이라서 ! 순서가 바뀌면 다른 집합이므로 다시 탐색해주어야 하기 때문
//			}
		}
		
	}

}
