import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[] know;
	static int[] p;
	static int n, m, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		know = new boolean[n + 1];

		p = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			p[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int howMany = Integer.parseInt(st.nextToken());
		for (int i = 0; i < howMany; i++) {
			int x = Integer.parseInt(st.nextToken());
			know[x] = true;
		}

		List<Integer>[] party = new ArrayList[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			party[i] = new ArrayList<>();

			howMany = Integer.parseInt(st.nextToken());

			for (int j = 0; j < howMany; j++) {
				int e = Integer.parseInt(st.nextToken());
				party[i].add(e);
			}

			for (int j = 0; j < howMany - 1; j++) {
				int x = party[i].get(j);
				int y = party[i].get(j + 1);
				Union(x, y);
			}
		}

		for (int i = 1; i < n + 1; i++) {
			if (know[i]) {
				know[findSet(i)] = true;
			}
		}

		for (int i = 0; i < m; i++) {
			int parent = findSet(party[i].get(0));
			if (!know[parent]) {
				result++;
			}
		}

		System.out.println(result);
	}

	private static void Union(int x, int y) {
		int a = findSet(x);
		int b = findSet(y);

		if (a != b) {
			if (a > b) {
				p[a] = b;
			} else {
				p[b] = a;
			}
		}
	}

	private static int findSet(int x) {
		if (x == p[x]) {
			return x;
		}
		return findSet(p[x]);
	}
}