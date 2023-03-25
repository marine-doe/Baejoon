import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n, m, result = 0;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(i, j, 0);
				crossCheck(i, j);
			}
		}
		System.out.println(result);
	}

	private static void crossCheck(int x, int y) {
		int sum = 0;
		if (x > 0 && y > 0 && y < m - 1) {
			sum = map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x][y + 1];
			result = Math.max(result, sum);
		}
		if (x < n - 1 && y > 0 && y < m - 1) {
			sum = map[x][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1];
			result = Math.max(result, sum);
		}
		if (y > 0 && x > 0 && x < n - 1) {
			sum = map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y - 1];
			result = Math.max(result, sum);
		}
		if (y < m - 1 && x > 0 && x < n - 1) {
			sum = map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y + 1];
			result = Math.max(result, sum);
		}
	}

	private static void dfs(int x, int y, int cnt) {
		if (cnt == 4) {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				sum += list.get(i);
			}
			result = Math.max(result, sum);
			return;
		}
		if (x < 0 || y < 0 || x >= n || y >= m) {
			return;
		}
		if(visited[x][y]) {
			return;
		}
		list.add(map[x][y]);
		visited[x][y] = true;
		dfs(x + 1, y, cnt + 1);
		dfs(x, y + 1, cnt + 1);
		dfs(x, y - 1, cnt + 1);
		list.remove(list.size() - 1);
		visited[x][y] = false;
	}
}