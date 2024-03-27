package BAEK_18870_좌표압축_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		
		int[] arr = new int[N];
		int idx = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			arr[idx++] = num;
			list.add(num);
			
		}
		Set<Integer> set = new HashSet<Integer>(list);
		list = new ArrayList<Integer>(set);
		Collections.sort(list);
		int length = set.size();
		
//		System.out.println(Arrays.toString(arr));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int cnt = 0;
		for(int a : list) {
			map.put(a,cnt++);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			sb.append(map.get(arr[i])+" ");
		}
		System.out.println(sb);
	}

}
