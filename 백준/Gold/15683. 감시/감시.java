import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class cctv {
	int x;
	int y;
	int ctg;
}

public class Main {
	static List<cctv> cctvs = new ArrayList<>();
	static int[][] map;
	static int n, m, result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv item = new cctv();
					item.x = i;
					item.y = j;
					item.ctg = map[i][j];
					cctvs.add(item);
				}
			}
		}
		dfs(0, map);

		System.out.println(result);
	}

	private static void dfs(int idx, int[][] map) {
		if (idx == cctvs.size()) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j] == 0) {
						sum++;
					}
				}
			}
			result = Math.min(result, sum);
			return;
		}

		for (int k = 0; k < 4; k++) {
			int[][] clone = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					clone[i][j] = map[i][j];
				}
			}
			watch(cctvs.get(idx).ctg, k, idx, clone);
			dfs(idx + 1, clone);
		}
	}

	private static void watch(int ctg, int head, int idx, int[][] map) {
		switch (ctg) {
		case 1:
			switch (head) {
			case 0:
				down(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			case 1:
				up(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			case 2:
				right(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			case 3:
				left(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			}
			break;
		case 2:
			switch (head) {
			case 0:
			case 1:
				right(cctvs.get(idx).x, cctvs.get(idx).y, map);
				left(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			case 2:
			case 3:
				down(cctvs.get(idx).x, cctvs.get(idx).y, map);
				up(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			}
			break;
		case 3:
			switch (head) {
			case 0:
				up(cctvs.get(idx).x, cctvs.get(idx).y, map);
				right(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			case 1:
				up(cctvs.get(idx).x, cctvs.get(idx).y, map);
				left(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			case 2:
				down(cctvs.get(idx).x, cctvs.get(idx).y, map);
				left(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			case 3:
				down(cctvs.get(idx).x, cctvs.get(idx).y, map);
				right(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			}
			break;
		case 4:
			switch (head) {
			case 0:
				up(cctvs.get(idx).x, cctvs.get(idx).y, map);
				right(cctvs.get(idx).x, cctvs.get(idx).y, map);
				left(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			case 1:
				down(cctvs.get(idx).x, cctvs.get(idx).y, map);
				right(cctvs.get(idx).x, cctvs.get(idx).y, map);
				left(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			case 2:
				down(cctvs.get(idx).x, cctvs.get(idx).y, map);
				up(cctvs.get(idx).x, cctvs.get(idx).y, map);
				left(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			case 3:
				down(cctvs.get(idx).x, cctvs.get(idx).y, map);
				up(cctvs.get(idx).x, cctvs.get(idx).y, map);
				right(cctvs.get(idx).x, cctvs.get(idx).y, map);
				break;
			}
			break;
		case 5:
			down(cctvs.get(idx).x, cctvs.get(idx).y, map);
			up(cctvs.get(idx).x, cctvs.get(idx).y, map);
			right(cctvs.get(idx).x, cctvs.get(idx).y, map);
			left(cctvs.get(idx).x, cctvs.get(idx).y, map);
			break;
		}
	}

	private static void left(int x, int y, int[][] map) {
		for (int i = 1; i < m; i++) {
			if (y - i >= 0) {
				if (map[x][y - i] == 0) {
					map[x][y - i] = 7;
				} else if (map[x][y - i] == 6) {
					break;
				}
			}
		}
	}

	private static void right(int x, int y, int[][] map) {
		for (int i = 1; i < m; i++) {
			if (y + i < m) {
				if (map[x][y + i] == 0) {
					map[x][y + i] = 7;
				} else if (map[x][y + i] == 6) {
					break;
				}
			}
		}
	}

	private static void up(int x, int y, int[][] map) {
		for (int i = 1; i < n; i++) {
			if (x - i >= 0) {
				if (map[x - i][y] == 0) {
					map[x - i][y] = 7;
				} else if (map[x - i][y] == 6) {
					break;
				}
			}
		}
	}

	private static void down(int x, int y, int[][] map) {
		for (int i = 1; i < n; i++) {
			if (x + i < n) {
				if (map[x + i][y] == 0) {
					map[x + i][y] = 7;
				} else if (map[x + i][y] == 6) {
					break;
				}
			}
		}
	}
}