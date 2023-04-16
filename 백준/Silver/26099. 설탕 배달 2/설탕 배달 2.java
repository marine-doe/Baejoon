import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long n = Long.parseLong(br.readLine());

		long result = 0;

		while (true) {
			if (n < 3) {
				result = -1;
				break;
			} else if (n % 5 == 0) {
				result = n / 5;
				break;
			} else if (n % 3 == 0) {
				if (n > 15) {
					long a = n / 15;
					n %= 15;
					result += a * 3;
				}
				result += n / 3;
				break;
			} else {
				n -= 5;
				result++;
			}
		}

		bw.write(result + "");
		bw.flush();
	}
}