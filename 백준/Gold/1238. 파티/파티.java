import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static class Edge {
		int ed, w;

		public Edge(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}
	}

	static List<Edge>[] edges;
	static int n, m, x;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();

		edges = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int node = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();

			edges[node].add(new Edge(ed, w));
		}

		int result = 0;
		for (int i = 1; i < n + 1; i++) {
			int sum = 0;
			if (i != x) {
				sum = dijkstra(i, x);
				sum += dijkstra(x, i);
			}
			result = Math.max(result, sum);
		}

		System.out.println(result);
	}

	private static int dijkstra(int start, int end) {
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.v == end)
				break;
			else if (visited[cur.v])
				continue;

			for (int i = 0; i < edges[cur.v].size(); i++) {
				Edge e = edges[cur.v].get(i);
				if (dist[e.ed] > e.w + dist[cur.v]) {
					dist[e.ed] = e.w + dist[cur.v];
					pq.offer(new Node(e.ed, dist[e.ed]));
				}
			}

			visited[cur.v] = true;
		}

		return dist[end];
	}
}