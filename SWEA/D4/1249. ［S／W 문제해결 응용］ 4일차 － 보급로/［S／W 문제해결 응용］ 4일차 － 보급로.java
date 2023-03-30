import java.util.*;

public class Solution {
	static int[][] map;
	static int[] row = { 0, 1, 0, -1 }, col = { 1, 0, -1, 0 };
	static int n;

	static class Node implements Comparable<Node> {
		int x, y, w;

		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc < t + 1; tc++) {
			n = sc.nextInt();

			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				char[] line = sc.next().toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = Character.getNumericValue(line[j]);
				}
			}

			System.out.printf("#%d %d\n", tc, dijkstra());
		}
	}

	private static int dijkstra() {
		boolean[][] visited = new boolean[n][n];
		int[][] dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			int x = cur.x;
			int y = cur.y;

			if (visited[x][y])
				continue;

			visited[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int dx = x + row[i];
				int dy = y + col[i];

				if (dx < 0 || dy < 0 || dx >= n || dy >= n)
					continue;

				if (!visited[dx][dy]) {
					int d = cur.w + map[dx][dy];
					if (d < dist[dx][dy]) {
						dist[dx][dy] = d;
						pq.offer(new Node(dx, dy, d));
					}
				}
			}
		}

		return dist[n - 1][n - 1];
	}
}