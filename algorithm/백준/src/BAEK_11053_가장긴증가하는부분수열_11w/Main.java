package BAEK_11053_가장긴증가하는부분수열_11w;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1]; // 각각의 요소에서 가장 긴 수열의 길이를 저장.
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
        }
 
        dp[1] = 1;
        int ans = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
 
            for (int j = 1; j < i; j++) {
                // 따라서 초기화를 하면서 dp끼리 비교를하여 중복하여 증가하는 일을 막아야 한다.
            	//{10, 10, 30}
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
           
        }
        System.out.println(ans);
    }
 
}

