import java.util.Scanner;

public class Main {
	static int n, result = 0;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0, 1, 0);
		System.out.println(result);
	}

	private static void dfs(int x, int y, int stat) {
		if (x == n - 1 && y == n - 1) {
			result++;
			return;
		}
		switch (stat) {
		case 0:
			if (y + 1 < n && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
				if (x + 1 < n && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
					dfs(x + 1, y + 1, 1);
				}
			}
			break;
		case 1:
			if (y + 1 < n && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
			if (x + 1 < n && map[x + 1][y] == 0) {
				dfs(x + 1, y, 2);
				if (y + 1 < n && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
					dfs(x + 1, y + 1, 1);
				}
			}
			break;
		case 2:
			if (x + 1 < n && map[x + 1][y] == 0) {
				dfs(x + 1, y, 2);
				if (y + 1 < n && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
					dfs(x + 1, y + 1, 1);
				}
			}
			break;
		}
	}
}