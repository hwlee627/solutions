package 단어뒤집기2_bj_17413_3w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		String tmp = "";

//		System.out.println(str);
		int length = str.length();

		char[] words = new char[length];

		for (int i = 0; i < length; i++) {
			words[i] = str.charAt(i);
		}
//		System.out.printf(Arrays.toString(words));

		int cnt = 0;
		int tmpIndex = 0;
		while (true) {
			// 1. 꺾쇠 처리
			if (words[tmpIndex] == '<') {
				for (int i = tmpIndex; i < words.length; i++) {
					if(words[i] == '>') {
						tmp += words[i];
						tmpIndex = i+1;
						break;
					}else {
						tmp += words[i];
					}
				}
				//<ab cd>ef gh<ij kl>
			}else {
				//2. 꺾쇠가 아닌 단어들 처리
				for(int i = tmpIndex; i<words.length; i++) {
					boolean find = false;
					//꺽쇠 만나면 처리
					if(words[i] == '<') {
						tmpIndex = i;
						for(int j = i-1; j>=i-cnt; j--) {
							tmp += words[j];
						}
						cnt = 0;
						break;
					//빈칸 만날 때 처리
					}else if(words[i] == ' ') {
						for(int j = i-1; j>=i-cnt; j--) {
							tmp += words[j];
						}
						tmp += ' ';
						cnt = 0;
						tmpIndex = i+1;
					//알파벳 만날 때 처리
					}else {
						cnt++;
					}
					//배열의 끝이 꺽쇠가 아닌 경우 판별
					if(i == words.length-1) {
						if(words[i] != '>') {
							for(int j = words.length-1; j>=tmpIndex; j--) {
								tmp+=words[j];
							}
							tmpIndex = words.length;
						}
					}
				}
			}
			//while문에서 탈출하는 조건
			if(tmpIndex >= words.length) {
				break;
			}
			
		}
		System.out.println(tmp);
		
	}

}
