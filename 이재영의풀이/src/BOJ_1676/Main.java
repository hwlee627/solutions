package BOJ_1676;

// 팩토리얼0의개수
// 2의 배수는 충분하므로 5의 배수가 몇 개인지 센다. 제곱인 경우도 있으므로 5로 나누어질 때까지 계속 나눠준다.
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		
		if(N==0) {
			System.out.println(0);
		}else {
			for(int i=1;i<=N;i++) {
				int ni = i;
				while(true) {
					if(ni%5==0) {
						cnt++;
						ni/=5;
					}else {
						break;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}