import java.util.Scanner;

public class Solution {
	static int[][] arr;
	static String[] result;
	static boolean[] isDemo;
	static int n, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc < t + 1; tc++) {
			n = sc.nextInt();
			arr = new int[n + 1][3];
			result = new String[n + 1];
			isDemo = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i][0] = sc.nextInt(); // 좌표 x
				arr[i][1] = sc.nextInt(); // 좌표 y
				arr[i][2] = sc.nextInt(); // 군사력
			}

			for (int i = 1; i <= n; i++) {
				int count = 0;
				int idx = 0;
				double max = 0;
				for (int j = 1; j <= n; j++) {
					if (i != j) {
						double jForce = force(arr[j][0], arr[j][1], arr[i][0], arr[i][1], arr[j][2]);
						if (arr[i][2] < jForce) { // 위협 받으면
							count++;
							if (jForce > max) {
								max = jForce;
								idx = j;
								isDemo[i] = false;
							} else if (max == jForce) {
								isDemo[i] = true;
							}
						}
					}
				}
				if (count > 0) {
					if (isDemo[i]) {
						result[i] = "D";
					} else {
						result[i] = String.valueOf(idx);
					}
				} else {
					result[i] = "K";
				}
			}
			for (int i = 1; i < n + 1; i++) {
				cnt = 0;
				result[i] = findIndex(i);
			}

			System.out.printf("#%d ", tc);
			for (int i = 1; i < n + 1; i++) {
				System.out.printf("%s ", result[i]);
			}
			System.out.println();
		}
	}

	private static String findIndex(int i) {
		if (result[i].equals("D") || result[i].equals("K")) {
			if (cnt > 0) {
				return String.valueOf(i);
			} else {
				return result[i];
			}
		} else {
			cnt++;
			return findIndex(Integer.parseInt(result[i]));
		}
	}

	private static double force(int x1, int y1, int x2, int y2, int s) {
		return s / (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}