import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			String line = br.readLine();
			int n = line.length();
			char[] audience = new char[n];
			audience = line.toCharArray();

			int sum = 0; // 박수치는 사람덜
			int need = 0; // 고용할 사람덜
			for (int i = 0; i < n; i++) {
				if(audience[i] != '0') {
					if(sum < i) {
						need += i - sum;
						sum = i + (audience[i] - '0');
					}else {
						sum += audience[i] - '0';
					}
				}
			}
			
			bw.write("#" + tc + " " + need + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
