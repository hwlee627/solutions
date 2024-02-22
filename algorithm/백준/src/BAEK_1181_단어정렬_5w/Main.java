package BAEK_1181_단어정렬_5w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] words = new String[N];
		int length = 0;
		for (int i = 0; i < N; i++) {
			words[i] = sc.next();
		}
		// c a b ab a abc d a b
		int cnt = 0;
		for (int i = 0; i < words.length; i++) {
			if (i != words.length - 1) {
				if (words[i].length() == words[i + 1].length()) {
					if (words[i].charAt(0) == words[i + 1].charAt(0)) {
						for (int j = 1; j < words[i].length(); j++) {
							if (words[i].charAt(j) > words[i + 1].charAt(j)) {
								String tmp = words[i];
								words[i] = words[i + 1];
								words[i + 1] = tmp;
								break;
							}
						}
					} else {
						if(words[i].charAt(0) > words[i+1].charAt(0)) {
							String tmp = words[i];
							words[i] = words[i+1];
							words[i+1] = tmp;
							
						}
					}
					if (words[i].equals(words[i + 1])) {
						words[i] = " ";
					}
				} else if (words[i].length() > words[i + 1].length()) {
					String tmp = words[i];
					words[i] = words[i + 1];
					words[i + 1] = tmp;
				}
			}
			if (cnt == words.length) {
				if (!words[i].equals(" ")) {
					System.out.println(words[i]);
				}
			}
			if (i == words.length - 1) {
				if (cnt != words.length) {
					cnt++;
					i = -1;
				}
			}
		}
	}

}
