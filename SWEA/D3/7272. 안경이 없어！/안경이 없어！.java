import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		String zero = "CEFGHIJKLMNSTUVWXYZ";
		String one = "ADOPQR";
		String two = "B";
		
		int t = Integer.parseInt(br.readLine());
		outer: for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String line1 = st.nextToken();
			String line2 = st.nextToken();
			
			if(line1.length() != line2.length()) {
				bw.write("#" + tc + " " + "DIFF\n");
				continue outer;
			}
			
			for(int i = 0; i < line1.length(); i++) {
				if(zero.indexOf(line1.charAt(i)) >= 0) {
					if(zero.indexOf(line2.charAt(i)) < 0) {
						bw.write("#" + tc + " " + "DIFF\n");
						continue outer;
					}
				}else if(one.indexOf(line1.charAt(i)) >= 0) {
					if(one.indexOf(line2.charAt(i)) < 0) {
						bw.write("#" + tc + " " + "DIFF\n");
						continue outer;
					}
				}else if(two.indexOf(line1.charAt(i)) >= 0) {
					if(two.indexOf(line2.charAt(i)) < 0) {
						bw.write("#" + tc + " " + "DIFF\n");
						continue outer;
					}
				}
			}
			
			bw.write("#" + tc + " " + "SAME\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}