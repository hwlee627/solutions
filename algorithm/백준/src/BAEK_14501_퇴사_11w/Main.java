package BAEK_14501_퇴사_11w;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Schedule{
		int day, period, cost;

		public Schedule(int day, int period, int cost) {
			this.day = day;
			this.period = period;
			this.cost = cost;
		}
		
		
	}
	static int day, sum;
	static boolean[] days, tmp;
	static Schedule[] sch;
	static Queue<Schedule> q = new LinkedList<Schedule>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		day = sc.nextInt();
		
		
		
		sch = new Schedule[day];
		
		for(int i = 0; i<day; i++) {
			Schedule d = new Schedule(i, sc.nextInt(), sc.nextInt());
			sch[i] = d;
		}
		
			int[] dp = new int[day+1];
			
			for(int i = 0; i<day; i++) {
				if(i+sch[i].period<=day) {
					dp[i+sch[i].period] = Math.max(dp[i+sch[i].period], dp[i]+sch[i].cost);
					
				}
				dp[i+1] = Math.max(dp[i+1], dp[i]);
			}
			
			System.out.println(dp[day]);
		
		
	}

}
