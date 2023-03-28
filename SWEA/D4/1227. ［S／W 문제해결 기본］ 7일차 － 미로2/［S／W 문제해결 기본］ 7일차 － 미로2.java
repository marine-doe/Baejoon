import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static char[][] map;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 10; tc++) {
			map = new char[100][100];
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				String line = br.readLine();
				map[i] = line.toCharArray();
			}
			flag = false;
			dfs(1, 1);
			if (flag) {
				System.out.printf("#%d 1\n", t);
			} else {
				System.out.printf("#%d 0\n", t);
			}
		}
	}

	private static void dfs(int i, int j) {
		if (map[i][j] == '3') {
			flag = true;
			return;
		}

		if (map[i][j] == '1') {
			return;
		}

		if (map[i][j] == '0' || map[i][j] == '2') {
			map[i][j] = '1';
			dfs(i + 1, j);
			dfs(i - 1, j);
			dfs(i, j + 1);
			dfs(i, j - 1);
		}
	}
}