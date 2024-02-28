package BAEK_2751_수정렬하기2_6w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static StringBuffer sb = new StringBuffer();
	static int n, m;
	static List<Integer> list1 = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();
	static List<Integer> list3 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		given();// 테스트 실행을 준비하는 단계
		when(); // 테스트를 진행하는 단계
		then(); // 테스트 결과를 검증하는 단계		
		//병합정렬 시간초과
//		arr = new int[N];
//		tmpArr = new int[N];
//		for(int i = 0; i<N; i++) {
//			arr[i] = sc.nextInt();
//		}
//		
//		mergeSort(0, arr.length-1);
//		for(int i = 0; i<N; i++) {
//			System.out.println(arr[i]);
//		}
		
//		//counting정렬을 위해 최댓값 구하기
//		int max = Integer.MIN_VALUE;
//		for(int i = 0; i<N; i++) {
//			arr[i] = sc.nextInt();
//			if(max < arr[i]) {
//				max = arr[i];
//			}
//		}
//		arr = selectionSort(arr);
//		for(int i = 0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		int[] counting = countingSort(arr, max);
//		for(int i = 1; i<counting.length; i++) {
//			if(counting[i] == 1) {
//				System.out.println(i);
//			}
//		}
		
	}

	public static void given() throws IOException {					
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    // 스트링
		
		String s1 = br.readLine();
		n = Integer.parseInt(s1);
		for(int i=1; i<=n; i++) {
			String s2 = br.readLine();
			list1.add(Integer.parseInt(s2));
		}
	}
	public static void when() {
		Collections.sort(list1);
		for(Integer num : list1) {
			sb.append(num).append("\n");
		}
	}

	public static void then() {
		System.out.println(sb.toString());
	}

	//병합정렬 시간초과 아
//	public static void mergeSort(int st, int ed) {
//		if(st<ed) {
//			int mid = (st+ed)/2;
//			//왼쪽
//			mergeSort(st, mid);
//			//오른쪽
//			mergeSort(mid+1, ed);
//			//병합 후처리
//			merge(st, mid, ed);
//		}
//		
//	}

//	public static void merge(int st, int mid, int ed) {
//		int L = st;
//		int R = mid+1;
//		int idx = st;
//		
//		while(L <= mid && R<= ed) {
//			if(arr[L] <= arr[R]) {
//				tmpArr[idx++] = arr[L++];
//			}else {
//				tmpArr[idx++] = arr[R++];
//			}
//		}
//		//왼쪽 남은 경우
//		if(L <= mid) {
//			for(int i=L; i<=mid; i++) {
//				tmpArr[idx++] = arr[i];
//			}
//		}
//		//오른쪽 남은 경우
//		else {
//			for(int i = R; i<=R; i++) {
//				tmpArr[idx++] = arr[i];
//			}
//		}
//		//원본에 덮어씌우기
//		for(int i = st; i<=ed; i++) {
//			arr[i] = tmpArr[i];
//		}
//		
//	}
	//Input값이 음수도 있어서 적용 불가
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
