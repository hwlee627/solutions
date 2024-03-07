package BAEK_18110_solved.ac_7w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 0) {
			System.out.println(0);
		}else {
			int[] scores = new int[N];
			int roundNum = (int)Math.round(N*0.15);
//			System.out.println(roundNum);
			for(int i = 0; i<N; i++) {
				int num = Integer.parseInt(br.readLine());
				scores[i] = num;
			}
			
			Arrays.sort(scores);
//			System.out.println(Arrays.toString(scores));
			int sum = 0;
			for(int i = roundNum; i<scores.length-roundNum; i++) {
				sum += scores[i];
			}
//			System.out.println(sum);
			int average = (int)(Math.round((double)sum/(N-(2*roundNum))));
			
			System.out.println(average);
		}
		
	}
// 0 1 2 3 4 5
}
