import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		char[] text = br.readLine().toCharArray();

		for (int i = 0; i < text.length; i++) {
			if (text[i] == '<') {
				System.out.print(sb.reverse());
				sb.delete(0, i);
				for (int d = i; d < text.length; d++) {
					System.out.print(text[d]);
					if(text[d] == '>') {
						i = d;
						break;
					}
				}
			}else if(text[i] == ' ') {
				System.out.print(sb.reverse());
				sb.delete(0, i);
				System.out.print(' ');
			}else {
				sb.append(text[i]);
			}
		}
		System.out.println(sb.reverse());
	}
}
