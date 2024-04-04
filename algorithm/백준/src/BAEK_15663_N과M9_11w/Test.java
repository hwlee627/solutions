package BAEK_15663_N과M9_11w;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("4 5");
		set.add("5 4");
		set.add("4 5");
		List<String> list = new ArrayList<String>(set);
		
		for(String str : list) {
			System.out.println(str);
		}
	}

}
