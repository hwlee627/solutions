package BAEK_2606_바이러스_8w;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		
		Map<Integer, Boolean[]> map = new HashMap<>();
		Map<Integer, Boolean> map2 = new HashMap<>();
		
		Boolean[] con = {true, true, false, false, false, true, true};
		map.put(1, con );
		
		Boolean[] con2 = {false, true, false, false, false, true, true};
		map.put(2, con2 );
		
		System.out.println(Arrays.toString(map.get(2)));
}
}
