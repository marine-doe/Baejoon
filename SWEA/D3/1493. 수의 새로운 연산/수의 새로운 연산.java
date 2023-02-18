import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int n = 267;
		int[][] newCal = new int[n + 1][n + 1];
		int counti = 1;
		int countj = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				newCal[i][j] = counti + countj - 1;
				countj += j + i;
			}
			countj = 1;
			counti += i;
		}

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < n; j++) {
					if (newCal[i][j] == p) {
						x1 = i;
						y1 = j;
					}
					if (newCal[i][j] == q) {
						x2 = i;
						y2 = j;
					}
				}
			}

			int result = newCal[x1 + x2][y1 + y2];

			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}