package 자료구조;

import java.util.Arrays;

public class 병합정렬 {
	static int[] arr;
	static int[] tmpArr;

	public static void main(String[] args) {
		arr = new int[] {5, 22, 32, 26, 57, 19, 32, 55, 84};
		tmpArr = new int[arr.length];
		
		System.out.println("정렬 전: "+Arrays.toString(arr));
		mergeSort(0, arr.length-1);
		System.out.println("정렬 후: "+Arrays.toString(arr));
		
		
}

	public static void mergeSort(int st, int ed) {
		if(st<ed) {
			int mid = (st+ed)/2;
			mergeSort(st,mid);
			mergeSort(mid+1,ed);
			merge(st, mid, ed);
		}else {
			
		}
		
	}

	public static void merge(int st, int mid, int ed) {
		int S = st; //왼쪽 구간의 시작점
		int E = mid+1; //오른쪽 구간의 시작점
		int idx = st; //정렬된 값을 넣어줄 임시 배열에 어디에 넣어줘야 할 지 결정하는 index
		
		//서로 아직 비교할 수 있는 값들이 남아있을 때
		while(S <= mid && E <= ed) {
			if(arr[S] <= arr[E]) {
				tmpArr[idx++] = arr[S++];
			}else {
				tmpArr[idx++] = arr[E++];
			}
		}
		//왼쪽이 남았을 때
		if(S <= mid) {
			for(int i = S; S<=mid; S++) {
				tmpArr[idx++] = arr[i];
			}
		}
		//오른쪽이 남았을 때
		else {
			for(int i = E; i<=E; i++) {
				tmpArr[idx++] = arr[i];
			}
		}
		
		//원본 반영하기
		for(int i = st; i<=ed; i++) {
			arr[i] = tmpArr[i];
		}
	}	

}