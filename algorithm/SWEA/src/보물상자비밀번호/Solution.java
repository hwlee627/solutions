package 보물상자비밀번호;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			
			//16진수
			//N = 8 / 12 / 16 / 20 / 24 / 28
			//회전 = 2/ 3 / 4 / 5 /6 / 7
			String numStr = sc.nextLine();
			System.out.println(numStr);
			char[] nums = numStr.toCharArray();
			System.out.print(Arrays.toString(nums));
			
			Set<String> set = new HashSet<String>();
			
			for(int i = 0; i<N/4; i++) {
				for(int j = 0; j<N; j+=N/4) {
					String str = "";
					for(int k = j; k<j+N/4; k++) {
						str += nums[k];
						
						
					}
					System.out.println(str);
					set.add(str);
					
				}
				char tmp = nums[N-1];
				for(int j = N-1; j>=0; j--) {
					
					if(j-1 >= 0) {
						nums[j] = nums[j-1];
					}
					if(j == 0) {
						nums[j] = tmp; 
					}
					
				}
			}
			
			//16진수를 10진수로 바꾸기
			//A = 65 B = 66 C 67 D 68 E 69 F 70
			// -54
			
			List<Integer> list = new ArrayList<Integer>();
			
			for(String num : set) {
				int listNum = 1;
				
			}
		}

	}

}
