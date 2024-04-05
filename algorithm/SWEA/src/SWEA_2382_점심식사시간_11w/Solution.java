package SWEA_2382_점심식사시간_11w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static class People{
		int r, c, time, stair;

		public People(int r, int c) {
			
			this.r = r;
			this.c = c;
		}
		
		
	}
	static class InStair{
		int inTime, outTime;

		public InStair(int inTime, int outTime) {
			super();
			this.inTime = inTime;
			this.outTime = outTime;
		}
		
		
	}
	static int[][] map;
	static int[] stairR, stairC, stairT;
	
	
	static Queue<People> wait = new LinkedList<People>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			map = new int[N][N];
			stairR = new int[2];
			stairC = new int[2];
			stairT = new int[2];
			List<People> list = new ArrayList<People>();
			List<Integer> stair0 = new ArrayList<Integer>();
			List<Integer> stair1 = new ArrayList<Integer>();
			//점심 먹으러 갈 사람 수
			int person = 0;
			int idx = 0;
			for(int r= 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					map[r][c] = sc.nextInt();
					if(map[r][c] != 1 && map[r][c] != 0) {
						stairR[idx] = r;
						stairC[idx] = c;
						stairT[idx] = map[r][c];
						idx++;
					}
					if(map[r][c] == 1) {
						People p = new People(r,c);
						person++;
						list.add(p);
					}
				}
			}
//			System.out.println(stairT[0] + " " + stairT[1]);
//			for(int i = 0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			//사람들이 어떤 계단으로 들어가는지 판단
			//계단까지의 거리 + 내려가는 소요시간이 작은 계단 선택
			
			for(People p : list) {
				//계단 1
				int s0 = Math.abs(p.r - stairR[0]) + Math.abs(p.c - stairC[0]) + stairT[0];
				int s1 = Math.abs(p.r - stairR[1]) + Math.abs(p.c - stairC[1]) + stairT[1];
				if(s1>=s0) {
					p.time = Math.abs(p.r - stairR[0]) + Math.abs(p.c - stairC[0]);
					p.stair = 0;
					
					//계단 2
				}else {
					p.time = Math.abs(p.r - stairR[1]) + Math.abs(p.c - stairC[1]);
					p.stair = 1;
				}
			}
//			for(People p : list) {
//				System.out.println("r : " + p.r+" c : "+p.c);
//				System.out.println(p.time + " : "+ p.stair);
//			}
			//점심 먹으러 간 사람 수
			int cnt = 0;
//			System.out.println("person : " + person);
			for(int time = 1; ; time++) {
//				System.out.println(cnt);
				if(stair1.size() != 0) {
					for(int i = stair1.size()-1; i>= 0; i--) {
						if(stair1.get(i) == time+1) {
							stair1.remove(i);
							cnt++;
						}
					}
				}
				if(stair0.size() != 0) {
					for(int i = stair0.size()-1; i>= 0; i--) {
						if(stair0.get(i) == time+1) {
							stair0.remove(i);
//							System.out.println("del : " +time);
							cnt++;
						}
					}
				}


				
				for(People p : list) {
					if(p.time == time) {
//						System.out.println("도착 : "+time);
						if(stair0.size() <3 && p.stair == 0) {
							
//							System.out.println("time : " + time);
							stair0.add(p.time+1+stairT[0]);
//							System.out.println("잘 들어가나 : "+p.time+1+stairT[0]);
						}else if(p.stair == 0 && stair0.size() == 3) {
							p.time++;

						}
						if(stair1.size() < 3 && p.stair == 1) {
//							System.out.println("time : " + time);
							stair1.add(p.time+1+stairT[1]);
//							System.out.println("잘 들어가나 2 : "+p.time+1+stairT[1]);
						}else if(p.stair == 1 && stair1.size() == 3) {
							p.time++;
						}
						if(stair0.size() == 3 && stair1.size() == 3) {
							int num1 = stair0.get(0);
							int num2 = stair1.get(0);
							int assess1 = Math.abs(p.r - stairR[0]) + Math.abs(p.c - stairC[0]);
							int assess2 = Math.abs(p.r - stairR[1]) + Math.abs(p.c - stairC[1]);
							
							if(num1 + assess1 > num2 + assess2) {
								p.stair = 1;
								
							}else if(num1 + assess1 < num2 + assess2) {
								p.stair = 0;
								
							}
						}else if(stair0.size() == 3 && stair1.size()<3) {
							if(p.stair == 0) {
								if(p.time+stairT[0] >=p.time+stairT[1]) {
									p.stair = 1;
								}
							}
						}else if(stair0.size() <3 && stair1.size() == 3) {
							if(p.stair == 1) {
								if(p.time+stairT[1] >=p.time+stairT[0]) {
									p.stair = 0;
								}
							}
						}
					}
				}
				
				if(cnt >= person) {
					time = time +1;
					System.out.println("#"+tc+" "+time);
					break;
				}
			}

			
		}

	}

}
