import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] lis = new int[n];
		lis[0] = arr[0];

		for (int i = 1; i < n; i++) {
			int value = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					value = Math.max(value, lis[j]);
				}
			}
			lis[i] = value + arr[i];
		}
		
		int result = 0;
		for (int i : lis) {
			result = Math.max(result, i);
		}
		
		System.out.println(result);
	}
}