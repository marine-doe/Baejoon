import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		BF(map, 0);
		System.out.println(max);
	}

	private static void BF(int[][] map, int idx) {
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = map[i][j];
			}
		}
		if (idx == 5) {
			checkMax(board);
		} else {
			for (int k = 0; k < 4; k++) {
				BF(order(board, k), idx + 1);
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						board[i][j] = map[i][j];
					}
				}
			}
		}
	}

	private static void checkMax(int[][] map) { // 보드의 최댓값
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, map[i][j]);
			}
		}
	}

	private static int[][] order(int[][] map, int idx) {
		if (idx == 0) {
			return up(map);
		}
		if (idx == 1) {
			return left(map);
		}
		if (idx == 2) {
			return right(map);
		} else {
			return down(map);
		}
	}

	private static int[][] up(int[][] map) {
		// 흡수
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n - 1; i++) {
				for (int k = i + 1; k < n; k++) {
					if (map[k][j] == 0) {
						continue;
					}
					if (map[i][j] == map[k][j]) {
						map[i][j] += map[k][j];
						map[k][j] = 0;
						break;
					}
					if (map[i][j] != map[k][j]) {
						break;
					}
				}
			}
		}
		// 이동
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n - 1; i++) {
				if (map[i][j] == 0) {
					for (int k = i + 1; k < n; k++) {
						if (map[k][j] != 0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
					}
				}
			}
		}
		return map;
	}

	private static int[][] left(int[][] map) {
		// 흡수
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (map[i][k] == 0) {
						continue;
					}
					if (map[i][j] == map[i][k]) {
						map[i][j] += map[i][k];
						map[i][k] = 0;
						break;
					}
					if (map[i][j] != map[i][k]) {
						break;
					}
				}
			}
		}
		// 이동
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (map[i][j] == 0) {
					for (int k = j + 1; k < n; k++) {
						if (map[i][k] != 0) {
							map[i][j] = map[i][k];
							map[i][k] = 0;
							break;
						}
					}
				}
			}
		}
		return map;
	}

	private static int[][] right(int[][] map) {
		// 흡수
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > 0; j--) {
				for (int k = j - 1; k >= 0; k--) {
					if (map[i][k] == 0) {
						continue;
					}
					if (map[i][j] == map[i][k]) {
						map[i][j] += map[i][k];
						map[i][k] = 0;
						break;
					}
					if (map[i][j] != map[i][k]) {
						break;
					}
				}
			}
		}
		// 이동
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > 0; j--) {
				if (map[i][j] == 0) {
					for (int k = j - 1; k >= 0; k--) {
						if (map[i][k] != 0) {
							map[i][j] = map[i][k];
							map[i][k] = 0;
							break;
						}
					}
				}
			}
		}
		return map;
	}

	private static int[][] down(int[][] map) {
		// 흡수
		for (int j = 0; j < n; j++) {
			for (int i = n - 1; i > 0; i--) {
				for (int k = i - 1; k >= 0; k--) {
					if (map[k][j] == 0) {
						continue;
					}
					if (map[i][j] == map[k][j]) {
						map[i][j] += map[k][j];
						map[k][j] = 0;
						break;
					}
					if (map[i][j] != map[k][j]) {
						break;
					}
				}
			}
		}
		// 이동
		for (int j = 0; j < n; j++) {
			for (int i = n - 1; i > 0; i--) {
				if (map[i][j] == 0) {
					for (int k = i - 1; k >= 0; k--) {
						if (map[k][j] != 0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
					}
				}
			}
		}
		return map;
	}
}