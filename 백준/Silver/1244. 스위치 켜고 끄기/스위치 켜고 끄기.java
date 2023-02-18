import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		// 스위치 개수 입력 받기
		int t = Integer.parseInt(br.readLine());

		// 스위치 배열 생성 1부터 t까지만 고려하자.
		int[] lights = new int[t + 1];

		// 스위치 상태 받기 20개씩 다음줄로 넘어가기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= t; i++) {
			lights[i] = Integer.parseInt(st.nextToken());
		}

		// 학생 수 입력 받기
		int n = Integer.parseInt(br.readLine());
		int act;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 1) {
				act = Integer.parseInt(st.nextToken());
				for (int j = act; j <= t; j += act) {
					if (lights[j] == 1) {
						lights[j] = 0;
					} else {
						lights[j] = 1;
					}
				}
			} else {
				act = Integer.parseInt(st.nextToken());
				if(lights[act] == 1) {
					lights[act] = 0;
				}else {
					lights[act] = 1;
				}
				for(int j = 1;;j++){
					if(act + j > t || act - j < 1) {
						break;
					}
					if(lights[act + j] == lights[act - j]) {
						if(lights[act+j] == 1) {
							lights[act+j] = 0;
						}else {
							lights[act+j] = 1;
						}
						if(lights[act-j] == 1) {
							lights[act-j] = 0;
						}else {
							lights[act-j] = 1;
						}
					}else {
						break;
					}
				}
			}
		}
		for(int i = 1; i <= t; i++) {
			if(i % 20 != 0) {
				bw.write(lights[i] + " ");
			}else {
				bw.write(lights[i] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
