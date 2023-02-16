import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int result;
		int sum = 1;
		for (int i = 1;; i++) {
			sum += (6 * i - 6);
			if (sum >= n) {
				result = i;
				System.out.println(result);
				break;
			}
		}
	}
}
