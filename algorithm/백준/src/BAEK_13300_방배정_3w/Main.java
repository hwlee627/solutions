package BAEK_13300_방배정_3w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//cnt배열을 만드는데
		//남자, 여자 배열로 나누고
		//길이를 7로 놔서 학년 당 학생 수를 구한다.
		
		int studentNum = sc.nextInt();
		int maxCount = sc.nextInt();
		
		int[] studentArr = new int[studentNum*2];
		
		int[] girlsCount = new int[7];
		int[] boysCount = new int[7];
		int cnt = 0;
		int roomCount = 0;
		
		for(int i = 0; i<studentArr.length; i++) {
			studentArr[i] = sc.nextInt();
		}
		for(int i = 0; i<studentArr.length-1; i++) {
			if(i % 2 == 0) {
				if(studentArr[i] == 0) {
					girlsCount[studentArr[i+1]]++;
				}else {
					boysCount[studentArr[i+1]]++;
				}
			}
		}

		for(int i = 0; i < 7; i++) {
			cnt = 0;
			int gradeCount = girlsCount[i];
			while(gradeCount>0) {
				cnt++;
				gradeCount -= maxCount;
				
			}
			gradeCount = boysCount[i];
			while(gradeCount>0) {
				cnt++;
				gradeCount -= maxCount;
			}
			roomCount += cnt;
		}
		
		System.out.println(roomCount);
	}

}
