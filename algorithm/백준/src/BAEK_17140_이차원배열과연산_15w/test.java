package BAEK_17140_이차원배열과연산_15w;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class test {
	
	public static void main(String[] args) {
		// value 값 기준 정렬

        HashMap<Integer, Integer> map2 = new HashMap<>();

        map2.put(1, 5);
        map2.put(2, 0);
        map2.put(7, 3);
        map2.put(3, 3);
        
        map2.put(4, 9);
        map2.put(5, 6);

        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map2.entrySet());

        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            	
                 return o1.getValue()-o2.getValue(); // 이 방법도 가능
                // return o2.getValue().compareTo(o1.getValue()); // 내림차순
            }
        });

        for(Map.Entry<Integer, Integer> entry : list){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

	}

}
