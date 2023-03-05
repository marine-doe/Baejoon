import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int size = 1000001;
		boolean[] visited = new boolean[size];
		int[] 분해합 = new int[size];
		
		for(int i = 1; i < size - 46; i++) {
			int[] num = new int[7];
			int temp = i;
			int idx = 0;
			while(idx < 7) {
				num[idx] = temp / (int) Math.pow(10, 6 - idx);
				temp %= (int) Math.pow(10, 6 - idx);
				idx++;
			}
			int sum = i;
			for (int j = 0; j < 7; j++) {
				sum += num[j];
			}
			if(!visited[sum]) {
				visited[sum] = true;
				분해합[sum] = i;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(분해합[n]);
	}
}