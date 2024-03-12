package BAEK_1764_듣보잡_8w;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Map<String, Integer> map = new HashMap<>(); //듣도보도못한사람 //자연스럽게 중복 제거하고 남으니까.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int idx = 0;
		int neverListened = 0;
		int neverSeen = 0;
		while(st.hasMoreTokens()) {
			if(idx == 0) {
				neverListened = Integer.parseInt(st.nextToken());
				idx++;
			}else {
				neverSeen = Integer.parseInt(st.nextToken());
			}
		}
		
		List<String> list = new ArrayList<>(); //중복된 사람들 담을 리스트
		for(int i = 1; i<=neverListened; i++) {
			String str2 = br.readLine();
			map.put(str2, 1);
			
		}
		for(int i = 1; i<=neverSeen; i++) {
			String str2 = br.readLine();
			if(map.get(str2) != null) {
				list.add(str2);
			}else {
				map.put(str2, 1);
			}
		}
		
		int length = (neverListened+neverSeen) - map.size();
		sb.append(length+"\n");
		
		list.sort(Comparator.naturalOrder());
		for(String person : list) {
			sb.append(person+"\n");
		}
		
		System.out.println(sb);
	}

}
class listenSeen{
	String name;
	int count;
	
	listenSeen(String name, int count){
		this.name = name;
		this.count = count;
	}
}