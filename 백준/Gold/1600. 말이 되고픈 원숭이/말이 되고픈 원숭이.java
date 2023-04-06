import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[][][] visited;
	static int[][] map;
	static int[] row = { 1, -1, 0, 0 }, col = { 0, 0, 1, -1 };
	static int[] horsex = { -2, -1, 1, 2, 2, 1, -1, -2 }, horsey = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int k, h, w, result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		map = new int[h][w];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		visited = new boolean[k + 1][h][w];
		bfs();
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		// x, y, 점프 횟수, 동작 횟수
		q.offer(new int[] { 0, 0, 0, 0 });
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == h - 1 && cur[1] == w - 1) {
				result = Math.min(result, cur[3]);
			}

			for (int d = 0; d < 4; d++) { // 상하좌우
				int nr = cur[0] + row[d];
				int nc = cur[1] + col[d];
				if (nr < h && nc < w && nr >= 0 && nc >= 0 && !visited[cur[2]][nr][nc]) {
					if (map[nr][nc] == 0) {
						q.offer(new int[] { nr, nc, cur[2], cur[3] + 1 });
						visited[cur[2]][nr][nc] = true;
					}
				}
			}
			
			if(cur[2] < k) { // 점프 횟수가 k보다 작으면
				for (int d = 0; d < 8; d++) { // 점프도 뛰어보자
					int nr = cur[0] + horsex[d];
					int nc = cur[1] + horsey[d];
					if (nr < h && nc < w && nr >= 0 && nc >= 0 && !visited[cur[2] + 1][nr][nc]) {
						if (map[nr][nc] == 0) {
							q.offer(new int[] { nr, nc, cur[2] + 1, cur[3] + 1 });
							visited[cur[2] + 1][nr][nc] = true;
						}
					}
				}
			}
		}
	}
}