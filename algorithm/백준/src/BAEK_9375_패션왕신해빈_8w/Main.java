package BAEK_9375_패션왕신해빈_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
	static int K, R;
	static String[] tmp;
	static int cnt;
	static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0 ; tc<T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				sb.append(0+"\n");
			}else {
				Set<String> set = new HashSet<>();
				map = new HashMap<>();
				for(int i = 0; i<N; i++) {
					String str = br.readLine();
					String[] clothes = str.split(" ");
					if(map.size() == 0) {
						map.put(clothes[1], 1);
						set.add(clothes[1]);
					}else {
						if(map.get(clothes[1])!=null) {
							map.put(clothes[1], map.get(clothes[1])+1);
						}else {
							map.put(clothes[1], 1);
							set.add(clothes[1]);
						}
					}
				}

				//각 옷 종류별로 몇 개가 있는지 담아놨다 !
				//if, 2개라면 2개 + 안 입는 경우 하나를 더해서 3이라 생각하자.
				//하지만 모두 다 입지 않으면 알몸이 되므로
				//최종 결과에서 1 빼기 !
				
				Object[] kind = set.toArray();
				int sum = 1;
				for(int i = 0; i<kind.length; i++) {
					sum *= map.get(kind[i]) + 1;
				}
				sb.append((sum-1)+"\n");
			}
			

		}
		System.out.println(sb);

	}

}
