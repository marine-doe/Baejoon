import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge>{
		int ed;
		double w;

		public Edge(int ed, double w) {
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] node = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			node[i][0] = sc.nextInt();
			node[i][1] = sc.nextInt();
		}
		
		List<Edge>[] adj = new ArrayList[n];
		
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			int p = sc.nextInt() - 1;
			int q = sc.nextInt() - 1;
			adj[p].add(new Edge(q, 0));
			adj[q].add(new Edge(p, 0));
		}
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				double dist = Math.sqrt(Math.pow(node[i][0] - node[j][0], 2)
						+ Math.pow(node[i][1] - node[j][1], 2));
				adj[i].add(new Edge(j, dist));
				adj[j].add(new Edge(i, dist));
			}
		}
		
		boolean[] visited = new boolean[n];
		double result = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.addAll(adj[0]);
		visited[0] = true;
		int cnt = 1;
		
		while(cnt < n) {
			Edge cur = pq.poll();
			if(!visited[cur.ed]) {
				pq.addAll(adj[cur.ed]);
				visited[cur.ed] = true;
				result += cur.w;
				cnt++;
			}
		}
		
		System.out.printf("%.2f", result);
	}
}