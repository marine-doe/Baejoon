import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			int[][] table = new int[t][t];

			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < t; j++) {
					// 1은 아래로, 2는 위로 움직이자
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int sum = 0;
			for (int i = 0; i < t; i++) { 
				for (int j = 0; j < t; j++) {
					if (table[i][j] == 1) { // 1일 때
						for (int d = i + 1; d < t; d++) {
							if(table[d][j] == 2) { // 2를 만나면
								sum++;
								table[i][j] = 0;
								table[d][j] = 0;
								break;
							}else if(table[d][j] == 1) { // 1을 만나면
								table[d][j] = 0;
							}
						}
					}else if (table[i][j] == 2) { // 2일 때
						for (int d = i - 1; d >= 0; d--) {
							if(table[d][j] == 1) { // 1을 만나면
								sum++;
								table[i][j] = 0;
								table[d][j] = 0;
								break;
							}else if(table[d][j] == 2) { // 2을 만나면
								table[d][j] = 0;
							}
						}
					}
				}
			}

			bw.write("#" + tc + " " + sum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
