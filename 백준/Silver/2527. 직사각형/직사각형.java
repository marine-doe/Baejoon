import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		for (int tc = 0; tc < 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
					x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken()),
					p1 = Integer.parseInt(st.nextToken()), q1 = Integer.parseInt(st.nextToken()),
					p2 = Integer.parseInt(st.nextToken()), q2 = Integer.parseInt(st.nextToken());

			if ((x2 == p1 && y2 == q1) || (x1 == p2 && y2 == q1) || (x2 == p1 && y1 == q2) || (x1 == p2 && y1 == q2)) {
				bw.write("c\n");
			} else if ((x2 == p1 && y2 > q1 && y1 < q2) || (x1 == p2 && y2 > q1 && y1 < q2) || (y2 == q1 && x1 < p2 && x2 > p1)
					|| (y1 == q2 && x1 < p2 && x2 > p1 )) {
				bw.write("b\n");
			} else if (x2 < p1 || p2 < x1 || y2 < q1 || q2 < y1) {
				bw.write("d\n");
			} else {
				bw.write("a\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
