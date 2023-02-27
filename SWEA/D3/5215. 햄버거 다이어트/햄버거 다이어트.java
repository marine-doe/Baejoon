import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[] taste, calories;
	static int n, less, best;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			taste = new int[n];
			calories = new int[n];
			less = sc.nextInt();
			for (int i = 0; i < n; i++) {
				taste[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}

			///////////////////////////////// 입력
			best = 0;
			selectGre(0, 0, 0);

			System.out.printf("#%d %d\n", tc, best);
		}
	}
	
	private static void selectGre(int idx, int t, int c) {
		if(idx == n){
			if(c > less) {
				return;
			}
			best = Math.max(best, t);
			return;
		}
		selectGre(idx + 1, t + taste[idx], c + calories[idx]);
		selectGre(idx + 1, t, c);
	}
}