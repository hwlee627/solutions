package BAEK_11723_집합_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		boolean[] S = new boolean[20];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);

			String[] arr = new String[2];
			int idx = 0;
			while (st.hasMoreTokens()) {
				arr[idx] = st.nextToken();
				idx++;
			}
//			System.out.println(Arrays.toString(arr));
			// 1. add : S에 x 추가 , 이미 있으면 연산 무시
			// 2. remove : S에서 x 제거, 없으면 연산 무시
			// 3. check : S에 x가 있으면 1, 없으면 0 출력
			// 4. toggle : S에 x가 있으면 x 제거, 없으면 x 추가
			// 5. all : S를 1, 2, 3... 20 으로 바꾸기
			// 6. empty : S를 공집합으로 만든다

			
			
			if (arr[0].equals("add")) {
				int x = Integer.parseInt(arr[1]);
				if(!S[x-1]) {
					S[x-1] = true;
				}
			} else if (arr[0].equals("remove")) {
				int x = Integer.parseInt(arr[1]);
				if(S[x-1]) {
					S[x-1] = false;
				}
			} else if (arr[0].equals("check")) {
				int x = Integer.parseInt(arr[1]); 
				if(S[x-1]) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			} else if (arr[0].equals("toggle")) {
				int x = Integer.parseInt(arr[1]);
				if(S[x-1]) {
					S[x-1] = false;
				}else {
					S[x-1] = true;
				}
			} else if (arr[0].equals("all")) {
				for(int j = 0; j<20; j++) {
					S[j] = true;
				}
			}else {
				S = new boolean[20];
			}
			
		}
		System.out.println(sb);

	}

}
