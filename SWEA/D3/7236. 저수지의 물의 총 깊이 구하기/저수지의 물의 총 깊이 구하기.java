import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		
		int[] row = {1, 1, 1, 0, -1, -1, -1, 0};
		int[] col = {1, 0, -1, -1, -1, 0, 1, 1};
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[][] well = new String[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					well[i][j] = st.nextToken();
				}
			}

			int max = 0;
			int sum;
			for (int r = 0; r < n; r++) { // 매트릭스 탐색 시작
				for (int c = 0; c < n; c++) {
					if(well[r][c].equals("W")) { // W를 만나면
						sum = 0;
						for(int i = 0; i < 8; i++) { // 8방 검사
							int nr = r + row[i];
							int nc = c + col[i];
							if(nr >= 0 && nr < n && nc >= 0 && nc < n) { // nr, nc가 범위 내면
								if(well[nr][nc].equals("W")) {
									sum++;
								}
							}
						}
						if(sum == 0) sum = 1;
						if(sum > max) {
							max = sum;
						}
					}
				}
			}

			bw.write("#" + tc + " " + max + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
