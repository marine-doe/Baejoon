import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, max = 0;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		BF(map, 0);
		System.out.println(max);
//		right(map);
//		down(map);
//		down(map);
//		right(map);
//		right(map);
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
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
			BF(up(board), idx + 1);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = map[i][j];
				}
			}
			BF(left(board), idx + 1);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = map[i][j];
				}
			}
			BF(right(board), idx + 1);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = map[i][j];
				}
			}
			BF(down(board), idx + 1);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = map[i][j];
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