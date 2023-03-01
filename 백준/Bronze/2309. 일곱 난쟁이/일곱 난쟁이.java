import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int sum = 0;
		int[] shorts = new int[9]; // 0 ~ 8
		int[] shortsCount = new int[101]; // 0 ~ 100
		for (int i = 0; i < 9; i++) {
			shorts[i] = Integer.parseInt(br.readLine()); // 난쟁이 키 받기
			sum += shorts[i]; // 난쟁이 키를 sum에 더하기
			shortsCount[shorts[i]]++; // 카운터에 1더하기
		}

		int fake = sum - 100; // 다 더한거에 100 빼긔
		outer: for (int i = 0; i < 8; i++) { // 구라치는 쉐기 찾기 0 ~ 7까지
			for (int j = i + 1; j < 9; j++) { // i 다음부터 8까지
				if (shorts[i] + shorts[j] == fake) { // 만약 둘이 구라 친거 걸리면 카운터에서 빼기
					shortsCount[shorts[i]]--;
					shortsCount[shorts[j]]--;
					break outer;
				}
			}
		}
		
		for (int i = 1; i < 101; i++) { // 1부터 100까즤
			if (shortsCount[i] > 0) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}