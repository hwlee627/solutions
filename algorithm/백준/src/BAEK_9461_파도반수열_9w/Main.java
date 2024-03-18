package BAEK_9461_파도반수열_9w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		long[] length = new long[102];
		length[0] = 0;
		length[1] = 1;
		length[2] = 1;
		length[3] = 1;
		length[4] = 2;
		length[5] = 2;
		for(int i = 6; i<=101; i++) {
			length[i] = length[i-5]+length[i-1];
		}
//		System.out.println(Arrays.toString(length));
		for(int i = 1; i<=T; i++) {
			
			int num = Integer.parseInt(br.readLine());
			if(i == T) {
				sb.append(length[num]);
			}else {
				sb.append(length[num]+"\n");
			}
			
		}
		System.out.println(sb);
	}

}
