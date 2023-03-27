import java.util.Scanner;

public class Solution {
	static int[][] route;
	static int[] arr;
	static boolean[] visited;
	static int n, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc < t + 1; tc++) {
			n = sc.nextInt();
			route = new int[n + 2][2];
			arr = new int[n + 2];
			visited = new boolean[n + 1];
			route[0][0] = sc.nextInt();
			route[0][1] = sc.nextInt();
			route[n + 1][0] = sc.nextInt();
			route[n + 1][1] = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				route[i][0] = sc.nextInt();
				route[i][1] = sc.nextInt();
			}

			result = Integer.MAX_VALUE;
			dfs(1);

			System.out.printf("#%d %d\n", tc, result);
		}
	}

	private static void dfs(int cnt) {
		if (cnt == n + 1) {
			arr[n + 1] = n + 1;
			result = Math.min(result, dist());
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[cnt] = i;
				dfs(cnt + 1);
				visited[i] = false;
				arr[cnt] = 0;
			}
		}
	}

	private static int dist() {
		int sum = 0;
		for (int i = 0; i < n + 1; i++) {
			sum += Math.abs(route[arr[i]][0] - route[arr[i + 1]][0])
					+ Math.abs(route[arr[i]][1] - route[arr[i + 1]][1]);
		}
		return sum;
	}
}