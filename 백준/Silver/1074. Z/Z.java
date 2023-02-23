import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 3
		int r = sc.nextInt(); // 7
		int c = sc.nextInt(); // 7

		int N = (int) Math.pow(2, n); // 8
		int start = 0; 
		int end = N * N; // 64

		int result = findNum(n, r, c, N, start, end);
		
		System.out.println(result);
	}

	private static int findNum(int n, int r, int c, int N, int start, int end) {
		N /= 2;
		boolean rowcheck;
		boolean colcheck;
		if (r >= N) {
			rowcheck = true;
		} else {
			rowcheck = false;
		}
		if (c >= N) {
			colcheck = true;
		} else {
			colcheck = false;
		}
		if (n == 1) {
			if (r == 0 && c == 0) {
				return start;
			} else if (r == 0 && c == 1) {
				return start + 1;
			} else if (r == 1 && c == 0) {
				return start + 2;
			} else {
				return start + 3;
			}
		} else {
			if (rowcheck) {
				if (colcheck) { // 4구역
					r -= N;
					c -= N;
					start = (int) (end - Math.pow(4, n - 1));
					n--;
					return findNum(n, r, c, N, start, end);
				} else { // 3구역
					r -= N;
					end = (int) (end - Math.pow(4, n - 1));
					start = (int) (end - Math.pow(4, n - 1));
					n--;
					return findNum(n, r, c, N, start, end);
				}
			} else {
				if (colcheck) { // 2구역
					c -= N;
					end = (int) (end - 2 * Math.pow(4, n - 1));
					start = (int) (end - Math.pow(4, n - 1));
					n--;
					return findNum(n, r, c, N, start, end);
				} else { // 1구역
					end = (int) (end - 3 * Math.pow(4, n - 1));
					n--;
					return findNum(n, r, c, N, start, end);
				}
			}
		}
	}
}