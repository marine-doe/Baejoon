import java.util.Scanner;

public class Main {
	static int[][] map, dp;
	static int n, result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		map = new int[n][3];
		dp = new int[n][3];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		findBest();

		System.out.println(result);
	}

	private static void findBest() {
		for (int i = 0; i < 3; i++) {
			dp[0][i] = map[0][i];
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				int min = Integer.MAX_VALUE;
				
				for (int k = 0; k < 3; k++) {
					if(j != k && min > dp[i - 1][k]) {
						min = dp[i - 1][k];
					}
				}
				
				dp[i][j] = map[i][j] + min;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			result = Math.min(result, dp[n - 1][i]);
		}
	}
}