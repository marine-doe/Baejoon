import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 크로아티아 알파벳
//		String[] ca = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		char[] line = sc.next().toCharArray();

		int count = 0;
		for (int i = 0; i < line.length - 1; i++) {
			if (line[i] == 'c') {
				if (line[i + 1] == '=' || line[i + 1] == '-') {
					count++;
				}
			} else if (line[i] == 'd') {
				if (line[i + 1] == '-') {
					count++;
				} else if (i < line.length - 2) {
					if (line[i + 1] == 'z' && line[i + 2] == '=') {
						count++;
					}
				}
			} else if (line[i] == 'l' && line[i + 1] == 'j') {
				count++;
			} else if (line[i] == 'n' && line[i + 1] == 'j') {
				count++;
			} else if (line[i + 1] == '=' && line[i] == 's') {
				count++;
			} else if (line[i + 1] == '=' && line[i] == 'z') {
				count++;
			}
		}

		System.out.println(line.length - count);
	}
}