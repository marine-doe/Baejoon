import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n, m, h, result, limit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h + 2][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[x][y + 1] = 2;
		}
		// =================input===============

		result = Integer.MAX_VALUE;
		dfs(1, 1, 0);

		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static void dfs(int x, int y, int cnt) {
		if(cnt >= 4) {
			return;
		}

			if (y >= n) {
			dfs(x + 1, 1, cnt);
			return;
		}

		if (x >= h + 1) {
			if (isPossible()) {
				result = Math.min(result, cnt);
				return;
			}
			return;
		}

		if (map[x][y] == 0 && map[x][y + 1] == 0) {
			map[x][y] = 1;
			map[x][y + 1] = 2;
			dfs(x, y + 2, cnt + 1);
			map[x][y] = 0;
			map[x][y + 1] = 0;
		}

		dfs(x, y + 1, cnt);
	}

	private static boolean isPossible() {
		for (int i = 1; i < n + 1; i++) {
			if (!columnCheck(i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean columnCheck(int idx) {
		int r = 1;
		int c = idx;
		while (r < h + 1) {
			if (map[r][c] == 1) { // 오른 쪽
				c++;
			} else if (map[r][c] == 2) { // 왼쪽
				c--;
			}
			r++;
		}
		if (c == idx) {
			return true;
		} else {
			return false;
		}
	}
}