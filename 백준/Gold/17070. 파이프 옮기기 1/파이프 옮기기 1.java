import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
        0 : 가로
        1 : 대각선
        2 : 세로
         */
        int[][][] dp = new int[n + 1][n + 1][3];

        dp[0][1][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (k == 0) { // 가로로 놓인 애
                        if (map[i][j + 1] == 0) {
                            // 가로로 놓을게
                            dp[i][j + 1][0] += dp[i][j][k];
                        }
                        if (map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0) {
                            // 대각선으로 놓을게
                            dp[i + 1][j + 1][1] += dp[i][j][k];
                        }
                    } else if (k == 1) { // 대각선으로 놓인 애
                        if (map[i][j + 1] == 0) {
                            // 가로로 놓을게
                            dp[i][j + 1][0] += dp[i][j][k];
                        }
                        if (map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0) {
                            // 대각선으로 놓을게
                            dp[i + 1][j + 1][1] += dp[i][j][k];
                        }
                        if (map[i + 1][j] == 0) {
                            // 세로로 놓을게
                            dp[i + 1][j][2] += dp[i][j][k];
                        }
                    } else { // k == 2 , 세로로 놓인 애
                        if (map[i + 1][j] == 0) {
                            // 세로로 놓을게
                            dp[i + 1][j][2] += dp[i][j][k];
                        }
                        if (map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0) {
                            // 대각선으로 놓을게
                            dp[i + 1][j + 1][1] += dp[i][j][k];
                        }
                    }
                }
            }
        }

        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
    }
}