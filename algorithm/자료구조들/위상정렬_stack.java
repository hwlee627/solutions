import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 위상정렬_stack {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	static int V, E;
	static int adj[][];
	static int[] degree;
	static boolean[] visited;
	static Stack<Integer> stack;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt(); //정점 수
		E = sc.nextInt(); //간선 수 (방향있음)
		
		
		adj = new int[V+1][V+1];
		degree = new int[V+1]; //진입차수 저장 할 배열
		visited = new boolean[V+1];
		stack = new Stack<Integer>();
		
		
		for(int i = 0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1; //유향이니까 반대로는 담아주지 않을거다 !
			degree[b]++;
		}
		for(int i = 1; i<=V; i++) {
			//진입차수가 0인 정점들을 모두 DFS
			if(degree[i] == 0) {
				DFS(i);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.println(cook[stack.pop()]);
		}
	}
	
	static void DFS(int v) {
		visited[v] = true;
		
		for(int i = 1; i<=V; i++) {
			//인접하고 방문 X면 방문
			if(adj[v][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}
		//더이상 방문할 곳이 없어 !
		stack.add(v);
		
		
	}
	
	
	static String input = "9 9\r\n"
			+ "1 4\r\n"
			+ "1 8\r\n"
			+ "2 3\r\n"
			+ "4 3\r\n"
			+ "8 5\r\n"
			+ "3 5\r\n"
			+ "5 6\r\n"
			+ "9 6\r\n"
			+ "6 7";
}
