import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 크로아티아 알파벳
		String[] ca = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		String line = sc.next();

		int count = 0;
		for (int i = 0; i < ca.length; i++) {
			line = line.replace(ca[i], "+");
		}

		System.out.println(line.length());
	}
}