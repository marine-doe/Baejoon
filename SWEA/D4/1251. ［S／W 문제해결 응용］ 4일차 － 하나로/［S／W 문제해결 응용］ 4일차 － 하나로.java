import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class Edge implements Comparable<Edge> {
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
		int t = sc.nextInt();
		for (int tc = 1; tc < t + 1; tc++) {
			int n = sc.nextInt(); // 정점의 수
			
			int[][] island = new int[2][n];
			
			for (int i = 0; i < 2; i++) { // 0은 x좌표, 1은 y좌표
				for (int j = 0; j < n; j++) {
					island[i][j] = sc.nextInt();
				}
			}
			
			double e = sc.nextDouble();

			List<Edge>[] adj = new ArrayList[n];

			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					double cost = e * (Math.pow(island[0][i] - island[0][j], 2)
							+ Math.pow(island[1][i] - island[1][j], 2));
					adj[i].add(new Edge(j, cost));
					adj[j].add(new Edge(i, cost));
				}
			}

			boolean[] visited = new boolean[n];

			PriorityQueue<Edge> pq = new PriorityQueue<>();

			pq.addAll(adj[0]);
			
			visited[0] = true;

			int pick = 1;
			double ans = 0;

			while (pick < n) {
				Edge E = pq.poll();
				if (visited[E.ed]) {
					continue;
				}
				
				ans += E.w;
				pq.addAll(adj[E.ed]);
				visited[E.ed] = true;
				pick++;
			}

			long result = Math.round(ans);
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}