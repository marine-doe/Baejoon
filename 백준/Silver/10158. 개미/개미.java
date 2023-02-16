import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		// 휴.. 입력 다 받았다..
		int x = p + t;
		int y = q + t;
		int xRest = x % w;
		int yRest = y % h;
		int xVal = x / w;
		int yVal = y / h;
		
		if(xVal % 2 == 1) {
			x = w - xRest;
		}else {
			x = xRest;
		}
		if(yVal % 2 == 1) {
			y = h - yRest;
		}else {
			y = yRest;
		}

		bw.write(Math.abs(x) + " " + Math.abs(y));
		bw.flush();
		bw.close();
		br.close();
	}
}
