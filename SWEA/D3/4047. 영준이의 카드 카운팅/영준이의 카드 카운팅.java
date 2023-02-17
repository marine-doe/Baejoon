import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		outer: for (int tc = 1; tc <= t; tc++) {
			char[] cards = br.readLine().toCharArray();
			String[] card = new String[cards.length / 3];
			int s = 13;
			int d = 13;
			int h = 13;
			int c = 13;

			// 모자란 카드 세기
			for (int i = 0; i < cards.length; i += 3) {
				if (cards[i] == 'S')
					s--;
				else if (cards[i] == 'D')
					d--;
				else if (cards[i] == 'H')
					h--;
				else
					c--;
			}
			
			// 음수면 0 맞춰주고
			if (s < 0) {
				s = 0;
			} else if (d < 0) {
				d = 0;
			} else if (h < 0) {
				h = 0;
			} else if (c < 0) {
				c = 0;
			}

			// 카드 저장
			int idx = 0;
			for (int i = 0; i < cards.length; i += 3) {
				for (int j = 0; j < 3; j++) {
					card[idx] += cards[i + j];
				}
				idx++;
			}

			// 카드의 중복 검사
			for (int i = 0; i < cards.length / 3 - 1; i++) {
				for (int j = i + 1; j < cards.length / 3; j++) {
					if (card[i].equals(card[j])) {
						bw.write("#" + tc + " ERROR\n");
						continue outer;
					}
				}
			}

			bw.write("#" + tc + " " + s + " " + d + " " + h + " " + c + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
