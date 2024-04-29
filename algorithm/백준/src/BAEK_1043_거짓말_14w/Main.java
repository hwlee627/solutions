package BAEK_1043_거짓말_14w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer>[] list;
	static List<Integer> knowList;
	static int N, M;
	static boolean[] know;
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int knewNum = sc.nextInt();
		know = new boolean[N+1];
		
		//아는 사람 리스트
		knowList = new ArrayList<>();
		for(int i = 0; i<knewNum; i++) {
			int knowNum = sc.nextInt();
			
			know[knowNum] = true;
			knowList.add(knowNum);
		}
		
		//인접 행렬
		arr = new int[N+1][N+1];
		//파티 리스트
		List<Integer>[] list = new ArrayList[M];
		for(int i = 0; i<M; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; i++) {
			int num = sc.nextInt();
			if(num != 1) {
				for(int j = 0; j<num; j++) {
					list[i].add(sc.nextInt());
				}
				for(int j = 0; j<num; j++) {
					for(int k = 0; k<num; k++) {
						arr[list[i].get(j)][list[i].get(k)] = 1;
					}
				}
			}else {
				list[i].add(sc.nextInt());
			}
		}
		for(int n : knowList) {
			find(n);
		}
		int ispossible = 0;
		for(int i = 0; i<M; i++) {
			boolean check = true;
			for(int j = 0; j<list[i].size(); j++) {
				if(know[list[i].get(j)]) {
					check = false;
					break;
				}
			}
			if(check) {
				ispossible++;
			}
		}
		System.out.println(Arrays.toString(know));
		System.out.println(ispossible);
	}
	private static void find(int sidx) {
		for(int i = 1; i<N+1; i++) {
			if(arr[sidx][i] == 1 && !know[i]) {
				know[i] = true;
				find(i);
			}
		}
	}

}
