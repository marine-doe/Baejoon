import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[t];
        int w = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[3][t][w + 1];

        int count = 0;
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] == 1) {
                dp[1][i][0] = ++count;
            }
        }

        if (arr[0] == 2) {
            dp[2][0][1] = 1;
        }

        for (int i = 1; i < t; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (arr[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1);
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);
                } else {
                    dp[1][i][j] = Math.max(dp[2][i - 1][j - 1], dp[1][i - 1][j]);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j] + 1, dp[1][i - 1][j - 1] + 1);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < w + 1; i++) {
            result = Math.max(result, Math.max(dp[1][t - 1][i], dp[2][t - 1][i]));
        }

        System.out.println(result);
    }
}