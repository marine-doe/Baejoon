import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n, m, stat, result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()); // 로봇청소기 좌표
		int y = Integer.parseInt(st.nextToken());
		stat = Integer.parseInt(st.nextToken()); // 0북 1동 2남 3서
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(x, y);

		System.out.println(result);
	}

	private static void dfs(int x, int y) {
		if (map[x][y] == 0) {
			map[x][y] = 2;
			result++;
		}
		if (map[x - 1][y] != 0 && map[x + 1][y] != 0 && map[x][y - 1] != 0 && map[x][y + 1] != 0) {
			switch (stat) { // 0북 1동 2남 3서
			case 0:
				if (map[x + 1][y] == 1) {
					return;
				}
				dfs(x + 1, y);
				break;
			case 1:
				if (map[x][y - 1] == 1) {
					return;
				}
				dfs(x, y - 1);
				break;
			case 2:
				if (map[x - 1][y] == 1) {
					return;
				}
				dfs(x - 1, y);
				break;
			case 3:
				if (map[x][y + 1] == 1) {
					return;
				}
				dfs(x, y + 1);
				break;
			}
		}
		outer: for(int i = 0; i < 4; i++) {
			switch (stat) { // 0북 1동 2남 3서
			case 0:
				stat = 3;
				if (map[x][y - 1] == 0) {
					dfs(x, y - 1);
					break outer;
				}
				break;
			case 1:
				stat = 0;
				if (map[x - 1][y] == 0) {
					dfs(x - 1, y);
					break outer;
				}
				break;
			case 2:
				stat = 1;
				if (map[x][y + 1] == 0) {
					dfs(x, y + 1);
					break outer;
				}
				break;
			case 3:
				stat = 2;
				if (map[x + 1][y] == 0) {
					dfs(x + 1, y);
					break outer;
				}
				break;
			}
		}
	}
}