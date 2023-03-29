import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] p;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		int[][] planet = new int[n][4];
		PriorityQueue<int[]> cost = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2] < 0 ? -1 : 1;
			}
		});
		for (int i = 0; i < n; i++) {
			planet[i][0] = i;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 4; j++) {
				planet[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(planet, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1] < 0 ? -1 : 1;
			}
		});

		for (int i = 0; i < n - 1; i++) {
			cost.offer(new int[] { planet[i][0], planet[i + 1][0], Math.abs(planet[i][1] - planet[i + 1][1]) });
		}

		Arrays.sort(planet, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2] < 0 ? -1 : 1;
			}
		});

		for (int i = 0; i < n - 1; i++) {
			cost.offer(new int[] { planet[i][0], planet[i + 1][0], Math.abs(planet[i][2] - planet[i + 1][2]) });
		}

		Arrays.sort(planet, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[3] - o2[3] < 0 ? -1 : 1;
			}
		});

		for (int i = 0; i < n - 1; i++) {
			cost.offer(new int[] { planet[i][0], planet[i + 1][0], Math.abs(planet[i][3] - planet[i + 1][3]) });
		}

		int result = 0;
		int pick = 0;
		while (!cost.isEmpty()) {
			int[] curr = cost.poll();
			int px = findset(curr[0]);
			int py = findset(curr[1]);
			if (px != py) {
				union(px, py);
				result += curr[2];
				pick++;
			}

			if (pick == (n - 1)) {
				break;
			}
		}

		System.out.println(result);
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