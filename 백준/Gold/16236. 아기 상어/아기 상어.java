import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Shark {
		int x, y, level, exp;

		public Shark(int x, int y, int level, int exp) {
			this.x = x;
			this.y = y;
			this.level = level;
			this.exp = exp;
		}
	}

	static Shark shark;
	static boolean[][] visited;
	static int[][] map;
	static int[] row = { 1, -1, 0, 0 }, col = { 0, 0, -1, 1 };
	static int n, travel, dist, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}

		while (isExist()) {
			result += travel;
			moveAndEat();
		}

		System.out.println(result);
	}

	private static void moveAndEat() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] && dist == Math.abs(i - shark.x) + Math.abs(j - shark.y)) {
					if (map[i][j] > 0 && map[i][j] < shark.level) {
						shark.x = i;
						shark.y = j;
						shark.exp++;
						map[i][j] = 0;
						if (shark.exp == shark.level) {
							shark.exp = 0;
							shark.level++;
						}
						return;
					}
				}
			}
		}
	}

	private static boolean isExist() {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[n][n];

		q.offer(new int[] { shark.x, shark.y, 0 });
		visited[shark.x][shark.y] = true;
		travel = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[2] > travel) {
				continue;
			}

			if (map[cur[0]][cur[1]] > 0 && shark.level > map[cur[0]][cur[1]] && cur[2] <= travel) {
				dist = Math.abs(shark.x - cur[0]) + Math.abs(shark.y - cur[1]);
				travel = cur[2];
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + row[d];
				int nc = cur[1] + col[d];
				if (nr < n && nc < n && nr >= 0 && nc >= 0 && !visited[nr][nc] && cur[2] <= travel) {
					if (map[nr][nc] <= shark.level) {
						q.offer(new int[] { nr, nc, cur[2] + 1 });
						visited[nr][nc] = true;
					}
				}
			}
		}

		if (travel == Integer.MAX_VALUE) {
			return false;
		} else {
			return true;
		}
	}
}