package BAEK_10867_중복빼고정렬하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i<T; i++) {
			set.add(sc.nextInt());
		}
		
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int n : list) {
			sb.append(n+" ");
		}
		System.out.println(sb);
		
	}

}
