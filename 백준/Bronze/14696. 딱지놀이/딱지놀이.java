import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		
		outer: for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			int[] acount = new int[5];
			for(int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				acount[a[i]]++;
			}
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int[] b = new int[m];
			int[] bcount = new int[5];
			for(int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
				bcount[b[i]]++;
			}
			
			for(int i = 4; i >= 1; i--) {
				if(acount[i] > bcount[i]) {
					bw.write("A\n");
					continue outer;
				}else if(acount[i] < bcount[i]) {
					bw.write("B\n");
					continue outer;
				}
			}
			bw.write("D\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
