import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //지형 면적
			int X = sc.nextInt(); //활주로 길이
			
			int[][] ground = new int[N][N];
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					ground[r][c] = sc.nextInt();
				}
			}
			List<int[]> list = new ArrayList<int[]>();
			for(int c= 0; c<N; c++) {
				int[] arr = new int [N];
				for(int r= 0; r<N; r++) {
					arr[r] = ground[r][c];
				}
				list.add(arr);
			}
			for(int r= 0; r<N; r++) {
				int[] arr = new int [N];
				for(int c= 0; c<N; c++) {
					arr[c] = ground[r][c];
				}
				list.add(arr);
			}
			int roadCnt = 0;
			for(int[] intArr : list) {
				int cnt = 1;
				//내리막용 cnt
				
				boolean isOk = true;
//				boolean isOk1 = true;
//				boolean isOk2 = true;
				for(int i = 0; i<N; i++) {
					if(i+1<N) {
						//같을 때 얼마나 연속으로 같았었는지 확인
						if(intArr[i] == intArr[i+1]) {
							cnt++;
						}//오르막이면서 높이 차가 1인 경우
						else if(intArr[i] - intArr[i+1] == -1) {
							if(cnt >= X) {
								cnt = 1;
								continue;
							}else {
								isOk = false;
								cnt = 1;
								break;
							}
						}//내리막이면서 높이 차가 1인 경우
						else if(intArr[i]-intArr[i+1] == 1) {
							int tmpCnt = 1;
							for(int j = i+1; j<N; j++) {
								if(j+1<N) {
									if(intArr[j] == intArr[j+1]) {
										tmpCnt++;
									}else {
										if(tmpCnt>=X) {
											tmpCnt = 1;
											cnt = 0;
											int tmp = j;
											i = i+X-1; // 활주로는 겹치면 안되므로 활주로 길이만큼 index 추가
											if(i == N-1) {
												if(i != j) {
													isOk = false;
													break;
												}
											}
											break;
										}else {
											tmpCnt = 1;
											cnt = 1;
											isOk = false;
											break;
										}
									}
								}else {
									if(tmpCnt < X) {
										isOk = false;
										break;
									}
								}
								
							}
						}else if(Math.abs(intArr[i]-intArr[i+1]) > 1) {
							//높이가 차이나면서 1보다 차이가 큰 경우
							isOk = false;
							cnt = 1;
							break;
						}
					}
				}
				if(isOk) {
//					System.out.println(Arrays.toString(intArr));
					roadCnt++;
				}
			}
			System.out.println("#"+tc+" "+roadCnt);
		}

	}

}
