package SWEA_2382_점심식사시간_11w;

import java.util.ArrayList;
import java.util.List;

public class Test {
	static class Perple{
		int r, c;

		public Perple(int r, int c) {

			this.r = r;
			this.c = c;
		}
		
		
	}
	public static void main(String[] args) {
		List<Perple> list = new ArrayList<Perple>();
		
		Perple p = new Perple(1, 2);
		
		System.out.println(list.toString());
		Perple w;
		System.out.println(list.indexOf(w.r == 1));
	}

}
