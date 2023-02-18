import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int size = 1000000;
		List<Integer> primeArr = new ArrayList<>(); // 소수인 친구들 모음집
		boolean[] isPrime = new boolean[size + 1];
		isPrime[1] = true;
		for(int i = 2; i <= size; i++) { // isPrime이 false면 소수
			if(isPrime[i]) {
				continue;
			}
			primeArr.add(i);
			for(int j = 2; j * i <= size; j++) {
				isPrime[j * i] = true; // 누군가의 배수니? 그럼 넌 참이야
			}
		}		
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String d = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int count = 0;
			for(int i = a; i <= b; i++) {
				// a부터 b까지 isPrime이 false이면서 i가 d를 포함하고 있나요?
				if(!isPrime[i] && String.valueOf(i).contains(d)) {
					count++;
				}
			}
			
			bw.write("#" + tc + " " + count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
