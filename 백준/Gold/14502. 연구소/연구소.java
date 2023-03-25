import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static int n, m, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int size = n * m;
		map = new int[n][m];
		Queue<Integer> xq = new LinkedList<>();
		Queue<Integer> yq = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					xq.offer(i);
					yq.offer(j);
				}
			}
		}

		for (int i = 0; i < size - 2; i++) {
			if (map[i / m][i % m] == 0) {
				map[i / m][i % m] = 1;
				for (int j = i + 1; j < size - 1; j++) {
					if (map[j / m][j % m] == 0) {
						map[j / m][j % m] = 1;
						for (int k = j + 1; k < size; k++) {
							if (map[k / m][k % m] == 0) {
								visited = new boolean[n][m];
								map[k / m][k % m] = 1;
								int[][] clone = new int[n][m];
								for (int a = 0; a < n; a++) {
									for (int b = 0; b < m; b++) {
										clone[a][b] = map[a][b];
									}
								}
								int c = xq.size();
								for (int d = 0; d < c; d++) {
									Virus(clone, xq.peek(), yq.peek());	
									xq.offer(xq.poll());
									yq.offer(yq.poll());
								}
								countSafeZone(clone);
								map[k / m][k % m] = 0;
							}
						}
						map[j / m][j % m] = 0;
					}
				}
				map[i / m][i % m] = 0;
			}
		}

		System.out.println(result);
	}

	static int hi = 1;

	private static void countSafeZone(int[][] map) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}
		}
		result = Math.max(count, result);
	}

	private static void Virus(int[][] map, int i, int j) {
		if(i >= n || i < 0 || j >= m || j < 0 || visited[i][j]) {
			return;
		}
		if(map[i][j] == 1) {
			visited[i][j] = true;
			return;
		}
		if(map[i][j] == 0) {
			map[i][j] = 2;
			visited[i][j] = true;
			Virus(map, i + 1, j);
			Virus(map, i - 1, j);
			Virus(map, i, j + 1);
			Virus(map, i, j - 1);
		}
		if(map[i][j] == 2) {
			visited[i][j] = true;
			Virus(map, i + 1, j);
			Virus(map, i - 1, j);
			Virus(map, i, j + 1);
			Virus(map, i, j - 1);
		}
	}
}