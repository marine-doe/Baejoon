import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
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

	static int[] row = { -1, 1, 0, 0 }, col = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean[][] map = new boolean[m][n];
		int[][] djikstra = new int[m][n];

		for (int i = 0; i < m; i++) {
			String line = sc.next();
			for (int j = 0; j < n; j++) {
				if(line.charAt(j) == '1') {
					map[i][j] = true;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				djikstra[i][j] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[][] visited = new boolean[m][n];
		djikstra[0][0] = 0;
		q.offer(new Node(0, 0, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.x == m - 1 && cur.y == n - 1) {
				break;
			}else if(visited[cur.x][cur.y]) {
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int dx = cur.x + row[d];
				int dy = cur.y + col[d];
				if (dx >= 0 && dx < m && dy >= 0 && dy < n && !visited[dx][dy]) {
					if(map[dx][dy]) {
						djikstra[dx][dy] = Math.min(djikstra[cur.x][cur.y] + 1, djikstra[dx][dy]);
					}else {
						djikstra[dx][dy] = Math.min(djikstra[cur.x][cur.y], djikstra[dx][dy]);
					}
					q.offer(new Node(dx, dy, djikstra[dx][dy]));
				}
			}

			visited[cur.x][cur.y] = true;
		}
		
		System.out.println(djikstra[m - 1][n - 1]);
	}
}