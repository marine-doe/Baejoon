import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge>{
		int ed, w;

		public Edge(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		List<Edge>[] adj = new ArrayList[v + 1];
		for (int i = 0; i < v + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			adj[a].add(new Edge(b, w));
			adj[b].add(new Edge(a, w));
		}
		
		boolean[] visited = new boolean[v + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.addAll(adj[1]);
		visited[1] = true;
		int count = 1;
		long result = 0;
		
		while(count < v) {
			Edge cur = pq.poll();
			if(!visited[cur.ed]) {
				count++;
				visited[cur.ed] = true;
				pq.addAll(adj[cur.ed]);
				result += cur.w;
			}
		}
		
		System.out.println(result);
	}
}