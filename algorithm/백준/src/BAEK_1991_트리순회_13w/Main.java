package BAEK_1991_트리순회_13w;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static class Node{
		String value;
		
		Node left;
		Node right;
		public Node(String value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		public Node(String value) {
			this.value = value;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		sc.nextLine();
		List<Node> list = new ArrayList<>();
		list.add(new Node("A"));
		for(int i = 0 ; i<N; i++) {
			String value = sc.next();
			String left = sc.next();
			String right = sc.next();
			for(Node n : list) {
				if(n.value.equals(value)) {
					if(!left.equals(".")) {
						Node node = new Node(left);
						list.add(node);
						n.left = node;
					}
					if(!right.equals(".")) {
						Node node = new Node(right);
						list.add(node);
						n.right = node;
					}
					break;
				}
			}
			

		}
		
		
		for(Node n : list) {
			if(n.value.equals("A")) {
				sb = new StringBuilder();
				preorder(n);
				System.out.println(sb);
				sb = new StringBuilder();
				inorder(n);
				System.out.println(sb);
				sb = new StringBuilder();
				postorder(n);
				System.out.println(sb);
			}
		}
	}
	private static void postorder(Node node) {
		//후위순회 LRV
		if(node.left != null) {
			postorder(node.left);
		}
		if(node.right != null) {
			postorder(node.right);
		}
		sb.append(node.value);

	}
	private static void inorder(Node node) {
		
		//중위순회 LVR
		if(node.left != null) {
			inorder(node.left);
		}
		sb.append(node.value);

		if(node.right != null) {
			inorder(node.right);
		}

	}
	private static void preorder(Node node) {
		//전위순회 VLR
		sb.append(node.value);
		
		if(node.left != null) {
			preorder(node.left);
		}
		if(node.right != null) {
			preorder(node.right);
		}

		
	}

}
