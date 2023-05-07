import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[15][15];
		
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			for (int i = 1; i < 15; i++) {
				map[0][i] = i;
			}
			
			for (int i = 1; i < 15; i++) {
				for (int j = 1; j < 15; j++) {
					int sum = 0;
					
					for (int k = 1; k <= j; k++) {
						sum += map[i - 1][k];
					}
					
					map[i][j] = sum;
				}
			}
			
			System.out.println(map[n][m]);
		}
	}
}