import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] adj;
	static boolean[] visited;
	static int n, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc < 11; tc++) {
			visited = new boolean[101];
			n = sc.nextInt();
			int v = sc.nextInt();
			adj = new int[101][101];
			for (int i = 0; i < n / 2; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				adj[start][end] = 1;
			}

			result = 0;
			call(v);

			System.out.printf("#%d %d\n", tc, result);
		}
	}

	private static void call(int v) {
		Queue<int[]> q = new LinkedList<>();
		int depth = 0;
		q.offer(new int[] { v, depth });
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (visited[cur[0]])
				continue;

			visited[cur[0]] = true;

			for (int i = 1; i <= 100; i++) {
				if (adj[cur[0]][i] == 1 && !visited[i]) {
					q.offer(new int[] { i, cur[1] + 1 });
					if (cur[1] > depth) {
						depth = cur[1];
						result = i;
					}else if(cur[1] == depth && i > result) {
						result = i;
					}
				}
			}
		}
	}
}