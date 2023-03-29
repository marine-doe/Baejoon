import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] p;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < t + 1; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] island = new int[2][n];
			double[][] cost = new double[n * (n - 1) / 2][3];
			for (int i = 0; i < 2; i++) { // 0은 x좌표, 1은 y좌표
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					island[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			double e = Double.parseDouble(br.readLine());

			int idx = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					double dist = Math.pow(island[0][i] - island[0][j], 2) + Math.pow(island[1][i] - island[1][j], 2);
					cost[idx][0] = i;
					cost[idx][1] = j;
					cost[idx++][2] = e * dist;
				}
			}
			Arrays.sort(cost, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return o1[2] - o2[2] < 0 ? -1 : 1;
				}
			});

			p = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = i;
			}
			int pick = 0;
			double result = 0L;

			for (int i = 0; i < n * (n - 1) / 2; i++) {
				int px = findset((int) cost[i][0]);
				int py = findset((int) cost[i][1]);

				if (px != py) {
					union(px, py);
					result += cost[i][2];
					pick++;
				}

				if (pick == (n - 1))
					break;
			}

			long answer = Math.round(result);
			bw.write("#" + tc + " " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void union(int x, int y) {
		p[y] = x;
	}

	private static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
}