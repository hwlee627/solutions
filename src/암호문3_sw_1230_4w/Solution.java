package 암호문3_sw_1230_4w;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Node {
	int data;
	Node link;

	Node() {
	}

	Node(int data) {
		this.data = data;
	}
}

class LinkedList {
	Node head;
	int size;

	LinkedList(int size) {
		head = new Node();
		this.size = size;
	}
	// 삽입

//	void addFirst(int data) {
//		Node newNode = new Node(data);
//		
//		Node curr = head;
//		while(curr.link != null) {
//			curr = curr.link;
//		}
//		//curr = 마지막 노드
//		curr.link = newNode;
//		size++;
//	}
	void addByIdx(int data, int idx) {
		if (idx < 0 || size < idx) {
			return;
		}
		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		// curr은 삽입하고자 하는 노드 앞을 가르킴
		Node newNode = new Node(data);
		
		newNode.link = curr.link;
		curr.link = newNode;
		size++;
	}

	void removeByIdx(int idx) {
		if (idx < 0 || size <= idx) {
			return;
		}
		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		curr.link = curr.link.link;
		size--;
	}

	void addLast(int data) {
		Node newNode = new Node(data);
		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}
		curr.link = newNode;
		size++;
	}

	void printList() {
		Node curr = head;
		curr = curr.link;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.link;
		}
		System.out.println();
	}
}

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int size = sc.nextInt();
			LinkedList list = new LinkedList(size);
			for (int i = 0; i < size; i++) {
				int data = sc.nextInt();
				list.addLast(data);
			}
//			System.out.println(size);
//			list.printList();

			int length = sc.nextInt();

			String[] command = new String[length];
			for (int i = 0; i < length; i++) {
				command[i] = sc.next();
			}
//			System.out.println(length);
//			System.out.println(Arrays.toString(command));

			for (int i = 0; i < length; i++) {
				if (command[i].equals("I")) {
					for (int j = 1; j <= Integer.parseInt(command[i + 2]); j++) {
						list.addByIdx(Integer.parseInt(command[i + 2]+j), Integer.parseInt(command[i + 1])+j);
					}
				} else if (command[i].equals("A")) {
					for(int j = 1; j <= Integer.parseInt(command[i+1]); j++) {
						list.addLast(Integer.parseInt(command[i+1+j]));
					}
				} else if (command[i].equals("D")) {
					for (int j = 1; j <= Integer.parseInt(command[i + 2]); j++) {
						list.removeByIdx(Integer.parseInt(command[i + 1])+j);
					}
				}
			}
			list.printList();
		}
	}
}
