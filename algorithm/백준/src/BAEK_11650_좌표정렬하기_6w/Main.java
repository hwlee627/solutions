package BAEK_11650_좌표정렬하기_6w;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		List<Dot> list = new ArrayList<Dot>();
		for(int i = 0; i<N; i++) {
			Dot dot = new Dot(sc.nextInt(), sc.nextInt());
			list.add(dot);
		}
		
		list.sort(new CompareX().thenComparing(new CompareY()));
		
		for(Dot dot : list) {
			System.out.println(dot.x+" "+dot.y);
		}
	}
	
}
class Dot{
	int x;
	int y;
	
	Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
}
class CompareX implements Comparator<Dot>{
	
	@Override
	public int compare(Dot o1, Dot o2) {
		if(o1.x> o2.x) {
			return 1;
		}else if(o1.x == o2.x) {
			return 0;
		}else {
			return -1;
		}
	}
}

class CompareY implements Comparator<Dot>{
	
	@Override
	public int compare(Dot o1, Dot o2) {
		if(o1.y> o2.y) {
			return 1;
		}else if(o1.y == o2.y) {
			return 0;
		}else {
			return -1;
		}
	}
}
