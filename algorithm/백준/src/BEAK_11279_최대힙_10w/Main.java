package BEAK_11279_최대힙_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int val = Integer.parseInt(br.readLine());
			
			if(val == 0) {
				if(queue.isEmpty())
					sb.append("0\n");
				else
					sb.append(queue.poll()+"\n");
			}
			else
				queue.add(val);
		}
		System.out.println(sb);
	}
}
