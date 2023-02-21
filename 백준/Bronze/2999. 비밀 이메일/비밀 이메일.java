import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		char[] msg = br.readLine().toCharArray();
		int length = msg.length;
		int r = 0;
		int c = 0;
		
		if((int) Math.sqrt(length) * (int) Math.sqrt(length) == length) {
			r = (int) Math.sqrt(length);
			c = (int) Math.sqrt(length);
		}else {
			int temp = (int) Math.sqrt(length);
			for(;;) {
				if(length % temp == 0) {
					c = temp;
					r = length / temp;
					break;
				}else {
					temp--;
				}
			}
		}
		
		char[][] map = new char[r][c];
		
		int idx = 0;
		for(int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = msg[idx++];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				sb.append(map[j][i]);
			}
		}
		System.out.println(sb);
	}
}