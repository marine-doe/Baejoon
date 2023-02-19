import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		if(m == 1) {
			System.out.println(0);
		}else {
			int[] friends = new int[n];
			friends[0]++;
			int idx = 0;
			int count = 0;
			while(true) {
				if(friends[idx] % 2 == 0) {
					if(idx - l < 0) {
						idx = n + idx - l;
					}else {
						idx -= l;
					}
					count++;
					friends[idx]++;
					if(friends[idx] == m) {
						System.out.println(count);
						break;
					}
				}else {
					idx = (idx + l) % n;
					count++;
					friends[idx]++;
					if(friends[idx] == m) {
						System.out.println(count);
						break;
					}
				}
			}
		}
	}
}
