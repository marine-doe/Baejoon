import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double n = Integer.parseInt(st.nextToken());
			double m = Integer.parseInt(st.nextToken());

			double result = 1;
			for (int i = 0; i < n; i++) {
				result *= m - i;
				result /= 1 + i;
			}

			bw.write((int) result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}