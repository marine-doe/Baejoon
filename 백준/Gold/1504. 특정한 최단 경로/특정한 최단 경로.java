import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
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
		int ed, dist;

		public Edge(int ed, int dist) {
			this.ed = ed;
			this.dist = dist;
		}
	}

	static List<Node>[] nodes;
	static List<Edge>[] edges;
	static int n, m, v1, v2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		nodes = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			nodes[i] = new ArrayList<>();
		}
		edges = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			edges[a].add(new Edge(b, c));
			edges[b].add(new Edge(a, c));
		}

		v1 = sc.nextInt();
		v2 = sc.nextInt();

		System.out.println(getBest());
	}

	private static int getBest() {
		int sum1 = 0, sum2 = 0;

		int[] seq1 = { 1, v1, v1, v2, v2, n };
		for (int i = 0; i < 3; i++) {
			int dist = dijkstra(seq1[i * 2], seq1[i * 2 + 1]);
			if (dist == Integer.MAX_VALUE) {
				sum1 = Integer.MAX_VALUE;
				break;
			} else {
				sum1 += dist;
			}
		}

		int[] seq2 = { 1, v2, v2, v1, v1, n };
		for (int i = 0; i < 3; i++) {
			int dist = dijkstra(seq2[i * 2], seq2[i * 2 + 1]);
			if (dist == Integer.MAX_VALUE) {
				sum2 = Integer.MAX_VALUE;
				break;
			} else {
				sum2 += dist;
			}
		}

		if (sum1 == sum2 && sum1 == Integer.MAX_VALUE) {
			return -1;
		} else {
			return Math.min(sum1, sum2);
		}
	}

	private static int dijkstra(int start, int end) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		boolean[] visited = new boolean[n + 1];

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.v])
				continue;
			if (cur.v == end)
				break;

			for (int i = 0; i < edges[cur.v].size(); i++) {
				int ed = edges[cur.v].get(i).ed;
				int d = edges[cur.v].get(i).dist;
				if (dist[ed] > dist[cur.v] + d) {
					dist[ed] = dist[cur.v] + d;
					pq.offer(new Node(ed, dist[ed]));
				}
			}

			visited[cur.v] = true;
		}

		return dist[end];
	}
}