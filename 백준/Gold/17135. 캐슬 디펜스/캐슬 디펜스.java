import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, d, result = 0, idx, sum;
	static int[][] map;
	static boolean[][] enemy;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 턴
		m = Integer.parseInt(st.nextToken()); // 배치 놓을 수 있는 숫자 0 ~ m-1까지
		visited = new boolean[m];
		map = new int[n][m];
		d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(result);
	}

	private static void dfs(int depth, int cnt) {
		if (depth == 3) {
			sum = 0;
			hunt();
			result = Math.max(result, sum);
			return;
		}
		if (cnt == m) {
			return;
		}
		visited[cnt] = true;
		dfs(depth + 1, cnt + 1);
		visited[cnt] = false;
		dfs(depth, cnt + 1);
	}

	private static void hunt() {
		int[][] clone = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				clone[i][j] = map[i][j];
			}
		}
		enemy = new boolean[n][m];
		for (int i = n - 1; i >= 0; i--) {
			idx = 0;
			for (int j = 0; j < m; j++) {
				if (visited[j]) {
					findEnemy(i, j, 0, clone);
					idx++;
				}
			}
			// 한 턴 끝났으면
			for (int r = 0; r < i; r++) {
				for (int c = 0; c < m; c++) {
					if (enemy[r][c]) { // 공격 받았으면 적 없애주기
						clone[r][c] = 0;
					}
				}
			}
		}
	}

	private static void findEnemy(int r, int c, int dist, int[][] map) {
		Queue<Integer> rq = new LinkedList<>();
		Queue<Integer> cq = new LinkedList<>();
		boolean[][] find = new boolean[n][m];
		rq.offer(r);
		cq.offer(c);
		while (!rq.isEmpty()) {
			if (map[rq.peek()][cq.peek()] == 1) { // 1이다!
				if (!enemy[rq.peek()][cq.peek()]) { // 심지어 처음 ㅠㅠ
					sum++; // sum++ 해주고
				}
				enemy[rq.poll()][cq.poll()] = true; // 그 자리 방문했으요~
				break;
			} else { // 0이면
				find[rq.peek()][cq.peek()] = true; // 방문함
				if (Math.abs(cq.peek() - c) + Math.abs(rq.peek() - r) + 1 >= d) {
					rq.poll();
					cq.poll();
					continue;
				}
				if (cq.peek() - 1 >= 0 && !find[rq.peek()][cq.peek() - 1]) {
					rq.offer(rq.peek());
					cq.offer(cq.peek() - 1);
				}
				if (rq.peek() - 1 >= 0 && !find[rq.peek() - 1][cq.peek()]) {
					rq.offer(rq.peek() - 1);
					cq.offer(cq.peek());
				}
				if (cq.peek() + 1 < m && !find[rq.peek()][cq.peek() + 1]) {
					rq.offer(rq.peek());
					cq.offer(cq.peek() + 1);
				}
				rq.poll();
				cq.poll();
			}
		}
	}
}