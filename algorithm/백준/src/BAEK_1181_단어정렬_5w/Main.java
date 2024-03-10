package BAEK_1181_단어정렬_5w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<String> strArr = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			strArr.add(br.readLine());
		}
		//중복 없애기 List -> Set -> newList
		Set<String> set = new HashSet<String>(strArr);
		List<String> newList = new ArrayList<String>(set);
		
		//Natural order 쓰면 가나다순으로 바뀌는데 그 상태가 유지가 됨
		//뭔 메커니즘인지는 모르겠음
//		newList.sort(Comparator.naturalOrder());
//		newList.sort(new LengthCompare());
		
		
		
		
		newList.sort(new LengthCompare().thenComparing(Comparator.naturalOrder()));
		
		for(String words : newList) {
			sb.append(words).append('\n');
		}
		System.out.println(sb);
	}
	

}
class LengthCompare implements Comparator<String>{
	@Override
	public int compare(String str1, String str2) {
		if(str1.length() > str2.length()) {
			return 1;
		}else if(str1.length() == str2.length()) {
			return 0;
		}else {
			return -1;
		}
	}
}

