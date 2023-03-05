import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int min = Integer.MAX_VALUE;
		for (int a = 0; a < n - 7; a++) {
			for (int b = 0; b < m - 7; b++) {
				char[][] chessBoard = new char[8][8];
				for (int i = 0; i < 8; i++) { // 88 똑 떼기
					int r = a + i;
					for (int j = 0; j < 8; j++) {
						int c = b + j;
						chessBoard[i][j] = map[r][c];
					}
				}
				int count = 0;
				for (int i = 0; i < 8; i++) { // 정방향
					for (int j = 0; j < 8; j++) {
						if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
							if(chessBoard[i][j] == 'B') {
								chessBoard[i][j] = 'W';
								count++;
							}
						} else {
							if(chessBoard[i][j] == 'W') {
								chessBoard[i][j] = 'B';
								count++;
							}
						}
					}
				}
				min = Math.min(min, count);

				chessBoard = new char[8][8];
				for (int i = 0; i < 8; i++) { // 88 똑 떼기
					int r = a + i;
					for (int j = 0; j < 8; j++) {
						int c = b + j;
						chessBoard[i][j] = map[r][c];
					}
				}
				count = 0;
				for (int i = 0; i < 8; i++) { // 역방향
					for (int j = 0; j < 8; j++) {
						if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
							if(chessBoard[i][j] == 'W') {
								chessBoard[i][j] = 'B';
								count++;
							}
						} else {
							if(chessBoard[i][j] == 'B') {
								chessBoard[i][j] = 'W';
								count++;
							}
						}
					}
				}
				min = Math.min(min, count);
			}
		}
		bw.write(min + "\n");
		bw.flush();
	}
}