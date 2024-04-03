package BAEK_7662_이중우선순위큐_11w;

import java.util.List;
import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.add(-5000);
		pq.add(45);
		pq.add(0);
		pq.add(6790);
		
		System.out.println(pq.toString());
		pq.poll();
		System.out.println(pq.toString());
		Object[] arr = pq.toArray();
		pq.remove(arr[arr.length-1]);
		System.out.println(pq.toString());
		String num = "-5678";
		int change = Integer.parseInt(num);
		System.out.println(change+5678);
	}

}
