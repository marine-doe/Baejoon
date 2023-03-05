import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] 한수 = new boolean[1001];
		int[] num = new int[3];
		
		for (int i = 1; i < 1000; i++) {
			if(i < 100) {
				한수[i] = true;
			}else {
				int temp = i, idx = 0;
				while(idx < 3) {
					num[idx] = temp / (int) Math.pow(10, 2 - idx);
					temp %= (int) Math.pow(10, 2 - idx);
					idx++;
				}
				if(num[0] - num[1] == num[1] - num[2]) {
					한수[i] = true;
				}
			}
		}
		
		int n = sc.nextInt();
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if(한수[i]) {
				result++;
			}
		}
		System.out.println(result);
	}
}