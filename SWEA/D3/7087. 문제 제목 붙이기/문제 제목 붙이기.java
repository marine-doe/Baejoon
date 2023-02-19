import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			char[] alphabets = new char[26];
			int n = Integer.parseInt(br.readLine());
			String[] titles = new String[n];

			for (int i = 0; i < n; i++) {
				titles[i] = br.readLine();
				alphabets[titles[i].charAt(0) - 65]++;
			}
			
			int count = 0;
			for(int i = 0; i < 26; i++) {
				if(alphabets[i] != 0) {
					count++;
				}else {
					break;
				}
			}
			
			bw.write("#" + tc + " " + count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}