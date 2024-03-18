package BAEK_11659_구간합구하기4_9w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int idx = 0;
		
		int N = 0;
		int M = 0;
		int i = 0;
		int j = 0;
//		System.out.println(str);
		while(st.hasMoreTokens()) {
			if(idx == 0) {
				N = Integer.parseInt(st.nextToken());
				idx++;
			}else {
				M = Integer.parseInt(st.nextToken());
			}
		}
		
		str = br.readLine();
//		System.out.println(str);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		st = new StringTokenizer(str);
		idx=1;
//		System.out.println("들어오나1");
		int sum = 0;
		while(st.hasMoreTokens()) {
//			System.out.println("들어오나 3");
			sum += Integer.parseInt(st.nextToken());
			map.put(idx, sum);
			idx++;
		}
//		System.out.println(idx);
//		System.out.println(M);
		for(int k = 0; k<M; k++) {
			sum = 0;
//			System.out.println("들어오나2");
			idx=0;
			str = br.readLine();
			st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				if(idx == 0) {
					i = Integer.parseInt(st.nextToken());
					idx++;
				}else {
					j = Integer.parseInt(st.nextToken());
				}
			}
			if(i == 1) {
				sum = map.get(j);
			}else {
				sum = map.get(j)-map.get(i-1);
			}

			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}

}
