import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		p = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			p[i] = i;
		}
		String[] univ = new String[n + 1];
		int m = sc.nextInt();
		for (int i = 1; i < n + 1; i++) {
			univ[i] = sc.next();
		}
		int[][] edge = new int[m][3];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 3; j++) {
				edge[i][j] = sc.nextInt();
			}
		}

		Arrays.sort(edge, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2] < 0 ? -1 : 1;
			}
		});
		
		int pick = 0, result = 0;
		for (int i = 0; i < m; i++) {
			int px = find(edge[i][0]);
			int py = find(edge[i][1]);
			if (px != py && !univ[edge[i][0]].equals(univ[edge[i][1]])) {
				union(px, py);
				result += edge[i][2];
				pick++;
			}
			if (pick == n - 1) {
				break;
			}
		}
		
		if(pick == n - 1) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
	}

	private static void union(int x, int y) {
		p[y] = x;
	}

	private static int find(int x) {
		if (p[x] != x) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
}