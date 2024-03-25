import java.util.Arrays;

public class Test {
	private static int n, m;
	private static int[] nums, arr;
	private static boolean[] visited;
	public static void main(String[] args) {
		
		n = 5;
		
		nums = new int[n];
		visited = new boolean[n+1];
		for(int i = 0; i<n; i++) {
			nums[i] = i+1;
		}
		
		for(int i = 1; i<=n; i++) {
			m = i;
			arr = new int[m];
			Combination(0, 0);
			Permutation(0);
		}
	}
	private static void Permutation(int idx) {
		
		if(idx == m) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		
		for(int i = 1; i<=n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[idx] = nums[i-1];
				Permutation(idx+1);
				visited[i] = false;
			}
		}
		
	}
	private static void Combination(int idx, int sidx) {
		
		if(idx == m) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i = sidx; i<n; i++) {
			
			arr[idx] = nums[i];
			Combination(idx+1, i);
		}
		
	}

}
