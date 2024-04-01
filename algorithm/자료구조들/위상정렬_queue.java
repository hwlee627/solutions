import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬_queue {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); //정점 수
		int E = sc.nextInt(); //간선 수 (방향있음)
		
		
		int[][] adj = new int[V+1][V+1];
		int[] degree = new int[V+1]; //진입차수 저장 할 배열
		
		for(int i = 0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1; //유향이니까 반대로는 담아주지 않을거다 !
			degree[b]++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 0; i<=V; i++) {
			if(degree[i] == 0) {
				q.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(cook[curr] + "\n");
			
			
			for(int i = 0; i<=V; i++) {
				if(adj[curr][i] == 1) {
					degree[i]--;
					//adj[curr][i] = 0 ; 이건 간선을 실제로 삭제
				if(degree[i] == 0) {
					q.add(i);
				}
				
				}
				
				
			}
		}
		System.out.println(sb);
		
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
