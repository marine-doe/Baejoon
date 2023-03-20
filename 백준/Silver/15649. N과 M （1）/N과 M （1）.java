import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] arr;
	static int n, m;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		permutation(0);
		bw.flush();
		bw.close();
	}
	
	private static void permutation(int cnt) throws Exception{
		if(cnt == m) {
			for (int i = 0; i < m; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[cnt] = i;
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}
}