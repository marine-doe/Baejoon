import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] mapClone;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		mapClone = new int[n][n];
		int maxHeight = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > maxHeight) {
					maxHeight = map[i][j];
				}
			}
		}

		int max = 0;
		for (int r = 0; r < maxHeight; r++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mapClone[i][j] = map[i][j];
				}
			}
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(dfs(r, i, j)) {
						result++;
					}
					if (result > max) {
						max = result;
					}
				}
			}
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static int count = 0;
	private static boolean dfs(int r, int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n) {
			return false;
		}
		if (mapClone[i][j] > r) {
			mapClone[i][j] = 0;
			dfs(r, i + 1, j);
			dfs(r, i - 1, j);
			dfs(r, i, j + 1);
			dfs(r, i, j - 1);
			return true;
		}
		return false;
	}
}