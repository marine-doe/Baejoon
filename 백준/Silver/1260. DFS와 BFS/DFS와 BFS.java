import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static List<ArrayList<Integer>> graph; // 2차원 리스트
	static boolean[] visited; // 방문했는지 확인하긔

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) { // n + 1 만큼 2차원 리스트 맹글어 주기
			graph.add(new ArrayList<>());
		}
		int m = sc.nextInt(); // 간선의 수
		int v = sc.nextInt(); // 최초 방문할 인덱스?
		for (int i = 0; i < m; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			graph.get(node1).add(node2); // 양방향이라 두 번 적긔
			graph.get(node2).add(node1);
		}

		for (int i = 0; i < n + 1; i++) { // 정렬해주긔
			Collections.sort(graph.get(i));
		}

		visited = new boolean[n + 1]; // 크기는 n+1
		sb = new StringBuilder();
		dfs(v);
		System.out.println(sb);

		visited = new boolean[n + 1];
		sb = new StringBuilder();
		bfs(v);
		System.out.println(sb);
		sc.close();
	}

	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");

		for (int i = 0; i < graph.get(v).size(); i++) {
			if (!visited[graph.get(v).get(i)]) { // 방문안했으면
				dfs(graph.get(v).get(i)); // 방문
			}
		}
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.offer(v);
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			sb.append(v + " ");
			
			for (int i = 0; i < graph.get(v).size(); i++) {
				if (!visited[graph.get(v).get(i)]) { // 방문 안했으면 
					visited[graph.get(v).get(i)] = true;
					queue.offer(graph.get(v).get(i));
				}
			}
		}
	}
}