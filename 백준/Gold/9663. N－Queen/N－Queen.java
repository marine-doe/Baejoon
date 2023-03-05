import java.util.Scanner;

public class Main {
	static int n, result;
	static int[] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n];

		putQueen(0);
		System.out.println(result);
	}

	private static void putQueen(int cnt) {
		if (cnt == n) {
			result++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			map[cnt] = i;
			if(isPossible(cnt)) {
				putQueen(cnt + 1);
			}
		}
	}

	private static boolean isPossible(int col) {
		for (int i = 0; i < col; i++) {
			if(map[col] == map[i]) {
				return false;
			}else if(Math.abs(col - i) == Math.abs(map[col] - map[i])) {
				return false;
			}
		}
		return true;
	}
}