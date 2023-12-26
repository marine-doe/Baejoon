import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String line1, line2;
    static int[][] result;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        line1 = br.readLine();
        line2 = br.readLine();
        n = line1.length();
        m = line2.length();

        Lcs();

        System.out.println(result[n][m]);
    }

    private static void Lcs() {
        result = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (line1.charAt(i - 1) == line2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
    }
}