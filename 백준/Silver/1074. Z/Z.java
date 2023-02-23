import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, r, c, N, start, end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		N = (int) Math.pow(2, n); // 8
		start = 0;
		end = N * N; // 64

		int result = findNum();

		System.out.println(result);
	}

	private static int findNum() {
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
					return findNum();
				} else { // 3구역
					r -= N;
					end = (int) (end - Math.pow(4, n - 1));
					start = (int) (end - Math.pow(4, n - 1));
					n--;
					return findNum();
				}
			} else {
				if (colcheck) { // 2구역
					c -= N;
					end = (int) (end - 2 * Math.pow(4, n - 1));
					start = (int) (end - Math.pow(4, n - 1));
					n--;
					return findNum();
				} else { // 1구역
					end = (int) (end - 3 * Math.pow(4, n - 1));
					n--;
					return findNum();
				}
			}
		}
	}
}