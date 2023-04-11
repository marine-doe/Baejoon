import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int t = sc.nextInt();

		int[][] map = new int[r][c];
		int[] row = { 1, -1, 0, 0 }, col = { 0, 0, 1, -1 };
		int AC = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == -1) {
					AC = i - 1;
				}
			}
		}

		while (t > 0) {
			t--;
			int[][] clone = new int[r][c];
			
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] >= 5) {
						
						int temp = map[i][j];
						int cnt = 0;

						for (int d = 0; d < 4; d++) {
							int nr = i + row[d];
							int nc = j + col[d];
							if (nr >= 0 && nc >= 0 && nr < r && nc < c && map[nr][nc] != -1) {
								cnt++;
								clone[nr][nc] += temp / 5;
							}
						}

						map[i][j] -= temp / 5 * cnt;
					}
				}
			}
			
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					map[i][j] += clone[i][j];
				}
			}
			
			for (int i = AC - 1; i >= 1; i--) {
				map[i][0] = map[i - 1][0];
			}
			for (int i = 0; i < c - 1; i++) {
				map[0][i] = map[0][i + 1];
			}
			for (int i = 0; i < AC; i++) {
				map[i][c - 1] = map[i + 1][c - 1];
			}
			for (int i = c - 1; i > 0; i--) {
				map[AC][i] = map[AC][i - 1];
			}
			map[AC][1] = 0;
			
			for (int i = AC + 2; i < r - 1; i++) {
				map[i][0] = map[i + 1][0];
			}
			for (int i = 0; i < c - 1; i++) {
				map[r - 1][i] = map[r - 1][i + 1];
			}
			for (int i = r - 1; i > AC + 1; i--) {
				map[i][c - 1] = map[i - 1][c - 1];
			}
			for (int i = c - 1; i > 0; i--) {
				map[AC + 1][i] = map[AC + 1][i - 1];
			}
			map[AC + 1][1] = 0;
		}
		
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] > 0) {
					sum += map[i][j];
				}
			}
		}
		
		System.out.println(sum);
	}
}