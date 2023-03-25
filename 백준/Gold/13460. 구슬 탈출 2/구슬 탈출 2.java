import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int n, m, result = Integer.MAX_VALUE, x = 0, y = 0, r = 0, c = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'R') {
					x = i;
					y = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					r = i;
					c = j;
					map[i][j] = '.';
				}
			}
		}

		dfs(0);

		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static void dfs(int cnt) {
//		System.out.printf("%d %d %d %d\n", x, y, r, c);
		if (cnt == 11) {
			return;
		}
		if (r == -1) { // 파란 공이 구멍으로 빠져나가면
			return;
		}
		if (x == -1) { // 빨간 공만 구멍으로 빠져나가면
			result = Math.min(result, cnt);
			return;
		}
		int tx = x, ty = y, tr = r, tc = c;
		up();
		dfs(cnt + 1);
		x = tx;
		y = ty;
		r = tr;
		c = tc;
		down();
		dfs(cnt + 1);
		x = tx;
		y = ty;
		r = tr;
		c = tc;
		right();
		dfs(cnt + 1);
		x = tx;
		y = ty;
		r = tr;
		c = tc;
		left();
		dfs(cnt + 1);
		x = tx;
		y = ty;
		r = tr;
		c = tc;
	}

	private static void left() {
		if (c < y) { // 파공이 빨공보다 왼쪽에 있을 때
			for (int i = 1; i < m; i++) { // 파공부터 옮기기
				if (map[r][c - i] == '#') {
					c = c - i + 1;
					break;
				} else if (map[r][c - i] == 'O') {
					r = -1;
					break;
				}
			}
			for (int i = 1; i < m; i++) { // 빨공 옮기기
				if (map[x][y - i] == '#' || (x == r && y - i == c)) {
					y = y - i + 1;
					break;
				} else if (map[x][y - i] == 'O') {
					x = -1;
					break;
				}
			}
		} else {
			for (int i = 1; i < m; i++) { // 빨공부터 옮기기
				if (map[x][y - i] == '#') {
					y = y - i + 1;
					break;
				} else if (map[x][y - i] == 'O') {
					x = -1;
					break;
				}
			}
			for (int i = 1; i < m; i++) { // 파공 옮기기
				if (map[r][c - i] == '#' || (x == r && c - i == y)) {
					c = c - i + 1;
					break;
				} else if (map[r][c - i] == 'O') {
					r = -1;
					break;
				}
			}
		}
	}

	private static void right() {
		if (c > y) { // 파공이 빨공보다 오른쪽에 있을 때
			for (int i = 1; i < m; i++) { // 파공부터 옮기기
				if (map[r][c + i] == '#') {
					c = c + i - 1;
					break;
				} else if (map[r][c + i] == 'O') {
					r = -1;
					break;
				}
			}
			for (int i = 1; i < m; i++) { // 빨공 옮기기
				if (map[x][y + i] == '#' || (x == r && y + i == c)) {
					y = y + i - 1;
					break;
				} else if (map[x][y + i] == 'O') {
					x = -1;
					break;
				}
			}
		} else {
			for (int i = 1; i < m; i++) { // 빨공부터 옮기기
				if (map[x][y + i] == '#') {
					y = y + i - 1;
					break;
				} else if (map[x][y + i] == 'O') {
					x = -1;
					break;
				}
			}
			for (int i = 1; i < m; i++) { // 파공 옮기기
				if (map[r][c + i] == '#' || (x == r && c + i == y)) {
					c = c + i - 1;
					break;
				} else if (map[r][c + i] == 'O') {
					r = -1;
					break;
				}
			}
		}
	}

	private static void down() {
		if (r > x) { // 파공이 빨공보다 아래에 있을 때
			for (int i = 1; i < n; i++) {
				if (map[r + i][c] == '#') {
					r = r + i - 1;
					break;
				} else if (map[r + i][c] == 'O') {
					r = -1;
					break;
				}
			}
			for (int i = 1; i < n; i++) {
				if (map[x + i][y] == '#' || (y == c && x + i == r)) {
					x = x + i - 1;
					break;
				} else if (map[x + i][y] == 'O') {
					x = -1;
					break;
				}
			}
		} else { // 파공이 위에 있을 때
			for (int i = 1; i < n; i++) {
				if (map[x + i][y] == '#') {
					x = x + i - 1;
					break;
				} else if (map[x + i][y] == 'O') {
					x = -1;
					break;
				}
			}
			for (int i = 1; i < n; i++) {
				if (map[r + i][c] == '#' || (y == c && r + i == x)) {
					r = r + i - 1;
					break;
				} else if (map[r + i][c] == 'O') {
					r = -1;
					break;
				}
			}
		}
	}

	private static void up() {
		if (r < x) { // 파공이 빨공보다 위에 있을 때
			for (int i = 1; i < n; i++) {
				if (map[r - i][c] == '#') {
					r = r - i + 1;
					break;
				} else if (map[r - i][c] == 'O') {
					r = -1;
					break;
				}
			}
			for (int i = 1; i < n; i++) {
				if (map[x - i][y] == '#' || (y == c && x - i == r)) {
					x = x - i + 1;
					break;
				} else if (map[x - i][y] == 'O') {
					x = -1;
					break;
				}
			}
		} else { // 빨공이 위에 있을 때
			for (int i = 1; i < n; i++) {
				if (map[x - i][y] == '#') {
					x = x - i + 1;
					break;
				} else if (map[x - i][y] == 'O') {
					x = -1;
					break;
				}
			}
			for (int i = 1; i < n; i++) {
				if (map[r - i][c] == '#' || (y == c && r - i == x)) {
					r = r - i + 1;
					break;
				} else if (map[r - i][c] == 'O') {
					r = -1;
					break;
				}
			}
		}
	}
}