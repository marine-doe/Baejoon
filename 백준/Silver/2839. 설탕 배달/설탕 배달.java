import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int result = letsgo(n, 0);
		
		System.out.println(result);
	}

	private static int letsgo(int n, int i) {
		if( n < 3 ) {
			return -1;
		}
		int result = i;
		if (n % 5 == 0) {
			result = n / 5;
		} else if (n % 3 == 0) {
			if(n > 15) {
				int a = n / 15;
				n %= 15;
				result += a * 3;
			}
			result += n / 3;
		} else {
			result++;
			return letsgo(n-5, result);
		}
		return result;
	}
}