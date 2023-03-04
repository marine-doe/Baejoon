import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc < t + 1; tc++) {
			int n = sc.nextInt();
			int[] tree = new int[n];

			int max = 0;
			for (int i = 0; i < n; i++) { // 입력과 동시에 최대값 저장
				tree[i] = sc.nextInt();
				max = Math.max(tree[i], max);
			}
			
			int[] diff = new int[120];
			for (int i = 0; i < n; i++) { // 키 차이 저장
				diff[max - tree[i]]++;
			}

			int day = 0;
			for (int i = max - 1; i >= 3; i--) { // 3까지 먼저 보자
				if (diff[i] > 0) {
					while (diff[i] > 0) {
						day++;
						if (day % 2 == 1) { // 홀수 날인데
							if(diff[1] > 0) { // 키 차이 1 부터 물 주기
								diff[1]--;
							}else { // 키 차이 1 없으면 계획대로
								diff[i]--;
								diff[i - 1]++;
							}
						} else { // 짝수 날이면
							diff[i]--;
							diff[i - 2]++;
						}
					}
				}
			}
			
			int x = Math.min(diff[2], diff[1]); // 2랑 1 중 작은애를
			diff[2] -= x; // 서로한테 빼줘
			diff[1] -= x; // 그럼 둘 중 하나는 0이겠지
			day += 2 * x; // 날짜는 이틀씩 지났을 테고
			
			if(diff[2] > 0) { // 남은 애가 2 차이면
				int height = 2 * diff[2];
				while(height > 0) { // 음수 되는건 신경 안써도 됨
					day++;
					if (day % 2 == 1) { // 걍 빼든 하루 기다려서 빼든 알빠ㄴ
						height--;
					} else {
						height-=2;
					}
				}
			}
			
			if(diff[1] > 0) { // 남은 애가 1이면
				while(diff[1] > 0) {
					day++;
					if (day % 2 == 1) { // 홀수 날에만 물 주면 됨
						diff[1]--;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, day);
		}
		sc.close();
	}
}