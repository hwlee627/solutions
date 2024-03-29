package BAEK_1931_회의실배정_10w;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Discuss implements Comparable<Discuss>{
		int s, e;

		public Discuss(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Discuss o) {
			return Integer.compare(this.e, o.e);
		}
		
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
	
		List<Discuss> disList = new ArrayList<Discuss>();
		for(int i = 0 ; i<N; i++) {
			Discuss dis = new Discuss(sc.nextInt(), sc.nextInt());
			disList.add(dis);
		}
		Collections.sort(disList, new Comparator<Discuss>() {

			@Override
			public int compare(Discuss o1, Discuss o2) {
				if(o1.e == o2.e) {
					return o1.s - o2.s;
				}
				
				return o1.e-o2.e;
			}
		});
		
		int cnt = 0;
		int tmp = 0;
		for(Discuss di : disList) {
			if(tmp<=di.s) {
				tmp = di.e;
				cnt++;
			}
//			System.out.println(di.s);
		}

		System.out.println(cnt);
		
	}
}
