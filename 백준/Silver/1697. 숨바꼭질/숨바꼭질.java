import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int size = 100001;
	static int[] line = new int[size];
	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		line[n] = 1; // 일단 1로 초기화
		
		bfs(n);
		
		bw.write(line[k] - 1 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int x) {
		if(x == k) {
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		while (!q.isEmpty()) {
			x = q.poll();
			for(int i = 0; i < 3; i++) {
				int nx;
				if(i == 0) {
					nx = 2 * x;
				}else if(i==1) {
					nx = x + 1;
				}else {
					nx = x - 1;
				}
				if(nx == k) {
					line[nx] = line[x] + 1;
					return;
				}
				if (nx > 0 && nx < size && line[nx] == 0) {
					line[nx] = line[x] + 1;
					q.offer(nx);
				}
			}
		}
	}
}