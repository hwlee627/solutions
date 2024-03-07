package BAEK_1966_프린터큐_7w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 1; i<=T; i++) {
			
			int N = sc.nextInt();
//			System.out.println("N : "+N);
			int order = sc.nextInt();
			Deque<Nums> numQueue = new LinkedList<>();
			
			for(int j = 0 ; j<N; j++) {
				int value = sc.nextInt();
				if(j == order) {
					Nums num = new Nums(value, true);
					numQueue.add(num);
				}else {
					Nums num = new Nums(value, false);
					numQueue.add(num);
				}
			}
			

//			for(Nums n : numQueue) {
//				System.out.print(n.value);
//			}
//			System.out.println();
			boolean run = true;
			int popCnt = 0;
			while(run) {
				int max = 0;
				for(Nums n : numQueue) {
					if(max<n.value) {
						max = n.value;
					}
				}
				if(numQueue.peekFirst().value != max) {
					Nums tmp = numQueue.pollFirst();
					numQueue.addLast(tmp);
				}else {
					if(numQueue.peekFirst().target) {
						popCnt++;
						System.out.println(popCnt);
						run = false;
					}else {
						numQueue.pollFirst();
						popCnt++;
					}
					
				}
				
			}
		}


	}

}
class Nums {
	int value;
	boolean target;
	
	
	public Nums(int value, boolean target) {
		this.value = value;
		this.target = target;
	}
}