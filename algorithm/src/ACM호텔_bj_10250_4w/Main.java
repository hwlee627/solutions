package ACM호텔_bj_10250_4w;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 1; i<=T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			int floor = 0;
			int roomNum = 0;
			
			roomNum = (int)Math.ceil((double)N/H);
			if(N % H == 0) {
				
				floor = H;
			}else {
				floor= N%H;
			}
			
			if(roomNum < 10) {
				System.out.println(floor+"0"+roomNum);
			}else {
				System.out.println(floor+""+roomNum);
			}
	
		}
	}
}
