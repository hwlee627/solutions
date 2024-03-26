

import java.util.Arrays;

public class 퀵정렬 {

	static int[] arr;
	public static void main(String[] args) {
		arr = new int[] {5, 22, 32, 26, 57, 19, 32, 55, 84};
		
		quickSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static void quickSort(int left, int right) {
		if(left<right) {
			int pivot = partition(left, right);
			quickSort(left,pivot-1);
			quickSort(pivot+1,right);
		}
		
	}
	private static int partition(int left, int right) {
		int pivot = arr[right];
		int i = left -1;
		
		for(int j = left; j<right; j++) {
			if(arr[j] <= pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		//pivot을 자기 위치로 보내야 함
		int tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = tmp;
		
		return i+1;
	}

}
