package BAEK_1654_랜선자르기_8w;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int K = Integer.parseInt(st.nextToken()); 
		int N = Integer.parseInt(st.nextToken()); 
 
		int[] arr = new int[K];
		
		long max = 0;
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
 
		// 1과 1을 받았을 때 0으로 나누어 질 수도 있으므로 일단 ++
		max++; 
 
		long min = 0; 
		long mid = 0; 
 
		while (min < max) { 
			
			mid = (max + min) / 2;
			long count = 0;
 
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}
			
			//이분 탐색 범위 설정
			System.out.println(max);
			System.out.println(min);
			//현재 값으로 구한 count보다 N이 크면 더 작은 범위에서 다시 탐색해야 한다
			if(count < N) {
				max = mid;
			}
			else {
				min = mid + 1;
			}

 
		}
		
		//최종적으로, N개 혹은 N개보다 많아지는 시점이 다수이면
		//같은 값을 도출하는 값들 중 가장 큰 값을 도출해야 하므로
		//min과 max가 뒤바뀐 시점 혹은 같아진 시점에서 가장 마지막의 값은 min의 바로 왼쪽에 있을 것
		System.out.println(min-1);
	}
}
