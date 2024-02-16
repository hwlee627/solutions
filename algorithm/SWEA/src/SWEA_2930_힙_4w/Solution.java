package SWEA_2930_힙_4w;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] heap;
	static int heapSize;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			heap = new int[100001];
			heapSize = 0;
			int times = sc.nextInt();
			int[] popNum = new int[100001];
			int popIdx = 0;
			for (int i = 1; i <= times; i++) {
				int menu = sc.nextInt();
				
				if(menu == 1) {
					int data = sc.nextInt();
					heapPush(data);
					
				}else {
					popNum[popIdx] = heapPop();
					
					popIdx++;
				}
			}
			System.out.print("#"+test_case);
			for(int p = 0; p<popIdx; p++) {
				System.out.print(" "+popNum[p]);
			}
		}
	}

	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}

	static void heapPush(int data) {
		// 마지막 위치에 노드 추가
		// heapSize의 기본은 0 이므로 ++ 후 추가
		heap[++heapSize] = data;

		// 부모 노드와 비교하면서 swap
		// 처음 넣었을 때는 부모가 없음

		int ch = heapSize;
		int p = heapSize / 2; // 노드 2번 기준 자식 노드는 4번과 5번 둘 다 2로 나누면 2가 된다

		while (p > 0 && heap[p] < heap[ch]) {
			if (heap[p] < heap[ch]) {
				// swap하기
				swap(p, ch);

				ch = p;
				p = ch / 2; // 스왑 후 노드 번호 바꾸어줘야함
			}
		}
	}

	// 삭제
	static int heapPop() {
		if(heapSize == 0) {
			return -1;
		}else {
			// 루트에 있는 원소 제거하고
			int popItem = heap[1]; // 루트의 인덱스번호는 1번이니까
			// 마지막 노드에 있는 원소를 루트로 옮겨주기
			heap[1] = heap[heapSize--];

			int p = 1;
			int ch = p * 2;
			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
				ch++;
			}
			// 리프로 가면 자식이 없을 수 있음
			// ch가 heapSize 이하인지 확인
			while (ch <= heapSize && heap[p] < heap[ch]) {
				// 자식이 더 크면 swap
				swap(p, ch);

				p = ch;
				ch = p * 2;
				
				if(ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
					ch++;
				}
			}
			return popItem;
		}
	}

}
