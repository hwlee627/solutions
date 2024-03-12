package BAEK_1620_나는야포켓몬마스터이다솜_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int idx = 0;
		int pokeNum = 0;
		int problem = 0;
		while(st.hasMoreTokens()) {
			if(idx == 0) {
				pokeNum = Integer.parseInt(st.nextToken());
				idx++;
			}else {
				problem = Integer.parseInt(st.nextToken());
			}
		}
		Map<String, Integer> map1 = new HashMap<>();
		Map<Integer, String> map2 = new HashMap<>();
		
		for(int i = 0; i<pokeNum; i ++) {
			String name = br.readLine();
			map1.put(name, i+1);
			map2.put(i+1, name);
		}
		for(int i = 0; i<problem; i++) {
			String pro = br.readLine();
			int a;
			try {
				Integer.parseInt(pro);
			}catch(Exception e){
				if(e instanceof NumberFormatException) {
//					System.out.println("예외 처리!");
					//포켓몬 이름이라는 뜻
					sb.append(map1.get(pro)+"\n");
					continue;
				}
			}
					//숫자라는 뜻
				
				sb.append(map2.get(Integer.parseInt(pro))+"\n");
			
		}
		System.out.println(sb);
	}
	
}


