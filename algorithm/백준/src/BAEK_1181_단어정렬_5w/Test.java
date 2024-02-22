package BAEK_1181_단어정렬_5w;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] words = new String[N];
		for(int i = 0; i<N; i++) {
			words[i] = sc.next();
		}
		int length=0;
		Arrays.sort(words, Comparator.comparing(String::length));
		boolean check = true;
		for(int i = 0; i<words.length; i++) {
			if(i+1<words.length) {
				if(words[i].equals(words[i+1])) {
					words[i] = " ";
				}
				if(words[i].length() == words[i+1].length()) {
					if(words[i].charAt(0) == words[i+1].charAt(0)) {
						for(int j = 1; j<words[i].length(); j++) {
							if(words[i].charAt(j)>words[i+1].charAt(j)) {
								String tmp = words[i];
								words [i] = words[i+1];
								words [i+1] = tmp;
							}
						}
					}
				}
			}
			if(i == words.length-1) {
				if(length == 0) {
					i = 0;
				}else {
					for(int j = 0; j<words.length; j++) {
						if(words[j].equals(" ")) {
							length++;
						}
					}
				}
			}
			
			
		}
		System.out.println(Arrays.toString(words));
	}

}
