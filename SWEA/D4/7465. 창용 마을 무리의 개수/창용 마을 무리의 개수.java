import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static Set<Integer> set;
	static int[] p;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc < t + 1; tc++) {
			n = sc.nextInt();
			int m = sc.nextInt();
			p = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				p[i] = i;
			}
			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int px = findset(x);
				int py = findset(y);
				if (px < py) {
					p[py] = p[px];
				} else {
					p[px] = p[py];
				}
			}

			set = new HashSet<>();
			for (int i = 1; i < n + 1; i++) {
				p[i] = findset(i);
				set.add(p[i]);
			}

			System.out.printf("#%d %d\n", tc, set.size());
		}
	}

	private static int findset(int x) {
		if (x == p[x]) {
			return p[x];
		}
		return findset(p[x]);
	}
}