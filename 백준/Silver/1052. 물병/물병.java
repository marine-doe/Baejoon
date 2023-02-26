import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int result = makeBottle();

		System.out.println(result);
	}

	private static int makeBottle() {
		if (n <= k)
			return 0;

		for (int i = 0; i < k - 1; i++) {
			int j = 0;
			while (Math.pow(2, j) < n) {
				j++;
			}
			n -= Math.pow(2, j - 1);

			if (n == 0)
				return 0;
		}

		int i = 0;
		while (Math.pow(2, i) < n) {
			i++;
		}

		return (int) (Math.pow(2, i) - n);
	}
}