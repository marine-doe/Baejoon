import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[] row = { 1, -1, 0, 0, }, col = { 0, 0, 1, -1 };
	static int n, m, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		outerFill(0, 0);

		melt();

		System.out.println(result);
	}

	private static void melt() {
		while (true) {
			boolean[][] meltCheck = new boolean[n][m];
			boolean isExist = false;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						isExist = true;
						int count = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i + row[d];
							int nc = j + col[d];
							if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 2) {
								if (++count >= 2) {
									meltCheck[i][j] = true;
									break;
								}
							}
						}
					}
				}
			}

			if (!isExist) {
				return;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (meltCheck[i][j]) {
						outerFill(i, j);
					}
				}
			}

			result++;
		}
	}

	private static void outerFill(int r, int c) {
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		map[r][c] = 2;
		q.offer(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + row[d];
				int nc = cur[1] + col[d];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
					if (map[nr][nc] == 0) {
						map[nr][nc] = 2;
						visited[nr][nc] = true;
						q.offer(new int[] { nr, nc });
					}
				}
			}
		}
	}

}