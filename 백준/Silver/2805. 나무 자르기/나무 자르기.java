import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}

		int h = q.peek(), cnt = 0;
		long sum = 0L;
		while (!q.isEmpty() && sum < m && h > 0) {
			h--;
			if (q.peek() <= h) {
				sum += cnt;
			} else {
				while (!q.isEmpty() && q.peek() > h) {
					q.poll();
					cnt++;
				}
				sum += cnt;
			}
		}
		while (sum < m && h > 0) {
			h--;
			sum += cnt;
		}

		bw.write(h + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

//	private static int cut(int h) {
//		if (h < 0 || sum >= m) { // 조건을 충족하면 그만 둬라.
//			return h + 1;
//		}
//		if (!q.isEmpty() && q.peek() <= h) {
//			sum += cnt;
//			return cut(h - 1);
//		} else {
//			if (q.isEmpty()) {
//				sum += cnt;
//				return cut(h - 1);
//			} else {
//				while (!q.isEmpty() && q.peek() > h) {
//					q.poll();
//					cnt++;
//				}
//				sum += cnt;
//				return cut(h - 1);
//			}
//		}
//	}
}