import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		int[][] white = new int[101][101];
		int n = Integer.parseInt(br.readLine());
		int[] x = new int[n];
		int[] y = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= 10; j++) {
				for(int k = 1; k <= 10; k++) {
					white[x[i]+j][y[i]+k] = 1;
				}
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				sum+=white[i][j];
			}
		}
		System.out.println(sum);
	}
}