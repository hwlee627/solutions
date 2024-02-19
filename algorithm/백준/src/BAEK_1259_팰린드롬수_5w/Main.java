package BAEK_1259_팰린드롬수_5w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String str = sc.next();
			boolean check = true;
			if (str.equals("0")) {
				break;
			} else {
				int length = str.length();
				int[] arr = new int[length];
				for (int i = 0; i < length; i++) {
					arr[i] = str.charAt(i) - 96;
				}
				
				if(length % 2 == 0) {
					for(int i = 0; i<=(length/2)-1; i++) {
						if(arr[i] == arr[length-i-1]) {
							
						}else {
							System.out.println("no");
							check = false;
							break;					//"no"를 출력할 때 break를 넣어주지 않으면 "1212"같은 경우에는 no가 두번 출력됨
							
						}
					}
				}else {
					for(int i = 0; i<=(length/2)-1; i++) {
						if(arr[i] == arr[length-i-1]) {
							
						}else {
							System.out.println("no");
							check = false;
							break;
							
						}
					}
				}
			}
			if(check) {
				System.out.println("yes");
				
			}

		}

	}

}
