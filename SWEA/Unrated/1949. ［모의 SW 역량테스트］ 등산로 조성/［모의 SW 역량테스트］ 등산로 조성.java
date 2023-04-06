import java.util.Scanner;

public class Solution {
	static boolean[][] visited;
	static boolean flag;
	static int[][] map;
	static int[] row = { 1, -1, 0, 0 }, col = { 0, 0, 1, -1 };
	static int n, k, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc < t + 1; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();

			map = new int[n][n];

			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					max = Math.max(map[i][j], max);
				}
			}

			result = 0;
			for (int i = 0; i < n; i++) { // 등산로를 어디서 시작할까?
				for (int j = 0; j < n; j++) {
					if (map[i][j] == max) {
						visited = new boolean[n][n];
						flag = false;
						visited[i][j] = true;
						dfs(i, j, 1);
					}
				}
			}

			System.out.printf("#%d %d\n", tc, result);
		}
	}

	private static void dfs(int x, int y, int cnt) {
		result = Math.max(result, cnt); // 매번 최댓값 갱신

		for (int d = 0; d < 4; d++) {
			int nr = x + row[d];
			int nc = y + col[d];
			if (nr < n && nc < n && nr >= 0 && nc >= 0 && !visited[nr][nc]) {
				if (map[nr][nc] < map[x][y]) {
					visited[nr][nc] = true;
					dfs(nr, nc, cnt + 1);
					visited[nr][nc] = false;
				} else if (!flag) {
					for (int i = 1; i <= k; i++) {
						if (map[nr][nc] - i < map[x][y]) {
							flag = true;
							map[nr][nc] -= i;
							visited[nr][nc] = true;
							dfs(nr, nc, cnt + 1);
							visited[nr][nc] = false;
							flag = false;
							map[nr][nc] += i;
							break;
						}
					}
				}
			}
		}
	}
}