package BAEK_2751_수정렬하기2_6w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		//counting정렬을 위해 최댓값 구하기
		int max = 0;
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
			if(max < arr[i]) {
				max = arr[i];
			}
		}
//		arr = selectionSort(arr);
//		for(int i = 0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		int[] counting = countingSort(arr, max);
		for(int i = 1; i<counting.length; i++) {
			if(counting[i] == 1) {
				System.out.println(i);
			}
		}
		
	}
	
	public static int[] countingSort(int[] arr, int max) {
		int[] counting = new int[max+1];
		
		for(int i = 0; i<arr.length; i++) {
			counting[arr[i]] = 1;
		}
		return counting;
	}

	//선택 정렬 시간초과
	public static int[] selectionSort(int[] arr) {
		
		for(int i = 0; i<arr.length; i++) {
			
			int midIdx = i;
			
			//한 사이클 당 최소 숫자를 찾아서 swap!
			//최소값 찾고, 그 녀석이랑 바꿔야하거덩
			
			for(int j = i+1; j<arr.length; j++) {
				if(arr[midIdx] > arr[j]) {
					midIdx = j;
				}
			}
			
			int tmp = arr[i];
			arr[i] = arr[midIdx];
			arr[midIdx] = tmp;
		}
		
		return arr;
	}
	
	

}
