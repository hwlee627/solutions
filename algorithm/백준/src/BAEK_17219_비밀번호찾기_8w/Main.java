package BAEK_17219_비밀번호찾기_8w;

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
		int add = 0;
		int problem = 0;
		while(st.hasMoreTokens()) {
			if(idx % 2 == 0) {
				add = Integer.parseInt(st.nextToken());
				idx++;
			}else {
				problem = Integer.parseInt(st.nextToken());
				idx++;
			}
		}
		Map<String, String> map = new HashMap<>();
		for(int i = 0 ; i<add; i++) {
			String str2 = br.readLine();
			st = new StringTokenizer(str2);
			String site = null;
			String password = null;
			while(st.hasMoreTokens()) {
				
				if(idx % 2 == 0) {
					site = st.nextToken();
					idx++;
				}else {
					password = st.nextToken();
					idx++;
				}
				
				map.put(site, password);
			}

		}
		for(int i = 0; i<problem; i++) {
			String key = br.readLine();
//			System.out.println("key: "+key);
			sb.append(map.get(key)+"\n");
		}
		System.out.println(sb);
	}

}
