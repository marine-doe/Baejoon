import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[] dir = new int[6]; // 방위
		int[] dirCount = new int[5];
		int[] dist = new int[6]; // 동1 서2 남3 북4
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			dirCount[dir[i]]++;
			dist[i] = Integer.parseInt(st.nextToken());
		}
		int[] a = new int[2];
		int idx = 0;
		for(int i = 1; i < 5; i++) { // 동서남북 중 한 번만 입력 드간거 체크
			if(dirCount[i] == 1) {
				a[idx++] = i;
			}
		}
		int[] b = new int[2];
		int[] c = new int[2];
		idx = 0;
		int idx2 = 0;
		for(int i = 0; i < 6; i++) {
			if(a[0] == dir[i] || a[1] == dir[i]) {
				b[idx++] = dist[i];
				c[idx2++] = dist[(i + 3) % 6];
			}
		}
		
		int mat = b[0] * b[1] - c[0] * c[1]; // 자투리 땅 제거 전 크기
		int result = mat * n;
		System.out.println(result);
	}
}