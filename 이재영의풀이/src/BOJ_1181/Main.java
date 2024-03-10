package BOJ_1181;

// 단어정렬
// set로 중복 제거, comparator로 비교 기준 구현
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Set<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			set.add(sc.next());
		}

		String[] arr = set.toArray(new String[0]); // new String[0]을 매개변수로 넣어주면 배열의 크기가 알아서 조정됨

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}