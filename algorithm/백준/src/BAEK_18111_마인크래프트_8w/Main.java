package BAEK_18111_마인크래프트_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int[] arr = new int[3];
		int idx = 0;
		while (st.hasMoreTokens()) {
			arr[idx] = Integer.parseInt(st.nextToken());
			idx++;
		}

		int N = arr[0];
		int M = arr[1];
		int B = arr[2];

		int[] ground = new int[N * M];

		int minTime = Integer.MAX_VALUE;
		int maxHeight = 0;
		int sum = 0;
		idx = 0;

		for (int r = 0; r < N; r++) {
			String str2 = br.readLine();
			st = new StringTokenizer(str2);
			while (st.hasMoreTokens()) {
				ground[idx] = Integer.parseInt(st.nextToken());
				sum += ground[idx];
				idx++;
			}
		}
//		System.out.println(sum);
//		System.out.println(N * M);
		int average = (int) Math.round(sum / (double) (N * M));
		boolean run = true;
		boolean up = false;
		boolean down = false;
		while (run) {
			boolean isOK = true;
//			System.out.println(average);
			int time = 0;
			int cnt = 0;
			for (int i = 0; i < N * M; i++) {
				if (ground[i] != average) {
					if (ground[i] > average) {
						int gap = ground[i] - average;

						cnt += gap;
						time += gap * 2;

					} else {
						int gap = average - ground[i];
						if (B < gap) {
							average--;
							isOK = false;
							down = true;
							break;
						} else {
							
							cnt -= gap;
							time += gap;
						}
					}
				}
			}
			if(down) {
				if(minTime > time) {
					minTime = time;
					
				}else {
					isOK = true;
				}
				if(maxHeight = )
			}
			if(up) {
				
			}
			if(isOK) {
				System.out.println("minTime : " + time + " height : " + average);
				run = false;
			}

		}

	}

}
