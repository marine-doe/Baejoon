import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			map = new int[16][16];
			int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = Character.getNumericValue(line.charAt(j));
					if (map[i][j] == 2) {
						x1 = i;
						y1 = j;
						map[i][j] = 0;
					}
					if (map[i][j] == 3) {
						x2 = i;
						y2 = j;
					}
				}
			}

			dfs(x1, y1);

			if (map[x2][y2] == 1) {
				bw.write("#" + t + " " + "1\n");
			} else {
				bw.write("#" + t + " " + "0\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int i, int j) {
		if (i < 0 || j < 0 || i >= 16 || j >= 16) {
			return;
		}

		if (map[i][j] != 1) {
			map[i][j] = 1;
			dfs(i + 1, j);
			dfs(i - 1, j);
			dfs(i, j + 1);
			dfs(i, j - 1);
		}
	}
}