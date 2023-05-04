import java.util.Scanner;

public class Main {
	static boolean[][] visited;
	static int[][] map, way;
	static int[] row = { 1, -1, 0, 0 }, col = { 0, 0, 1, -1 };
	static int n, m, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		way = new int[n][m];
		visited = new boolean[n][m];
		way[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		result = findWay(n - 1, m - 1);

		System.out.println(result);
	}

	private static int findWay(int r, int c) {
		if(visited[r][c]) {
			return way[r][c];
		}else {
			visited[r][c] = true;
			
			for (int d = 0; d < 4; d++) {
				int nr = r + row[d];
				int nc = c + col[d];
				if (nr >= 0 && nr < n && nc < m && nc >= 0) {
					if(map[nr][nc] > map[r][c]) {
						way[r][c] += findWay(nr, nc);
					}
				}
			}
			
			return way[r][c];
		}
	}

}