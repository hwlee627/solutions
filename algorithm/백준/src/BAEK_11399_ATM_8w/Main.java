package BAEK_11399_ATM_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		List<Integer> list = new ArrayList<>();
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		
		int sum = 0;
		int ans = 0;
		for(int num : list) {
			sum += num;
			ans += sum;
		}
		System.out.println(ans);
	}

}
