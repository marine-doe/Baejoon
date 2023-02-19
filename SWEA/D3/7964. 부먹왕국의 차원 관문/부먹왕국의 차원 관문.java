import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 왕국 개수
			int n = Integer.parseInt(st.nextToken());
			int[] kd = new int[n];
			
			// 차원 포탈 이동 제한 거리
			int dist = Integer.parseInt(st.nextToken());
			int count = 0;
			
			// 필요한 차원 포탈의 개수
			int need = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) { // 입력과 동시에 필요한 차원 포탈의 개수 세기
				kd[i] = Integer.parseInt(st.nextToken());
				if(kd[i] == 0 ) { // count는 0을 만날 때마다 1씩 증가
					count++;
				}else { // 1을 만나면 초기화
					count = 0;
				}
				if(count >= dist) { // 세는 도중 dist면 count 초기화, need +1
					count = 0;
					need++;
				}
			}
			bw.write("#" + tc + " " + need + "\n");
		}
		// 출력 와르르
		bw.flush();
		bw.close();
		br.close();
	}
}