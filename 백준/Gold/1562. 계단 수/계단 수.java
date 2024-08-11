import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int G = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /*
        초기 설계를 자릿수, 숫자, 0~9까지의 비트 on off로 설계 했지만
        한 자리 수 차이의 숫자를 결과에 담기 때문에 0과 9가 포함되기만 하면 됨
        즉 두 개의 비트로 0과 9의 포함여부를 체크하면 되고
        00 01 10 11 이므로 세 번째 range는 4
        0을 포함하면 01 = 1
        9를 포함하면 10 = 2
        둘 다 포함하게 되면 11 = 3이 되겠지?
         */
        int[][][] dp = new int[n][10][4]; // 자릿수, 숫자
        for (int i = 1; i < 9; i++) {
            dp[0][i][0] = 1;
        }
        dp[0][9][2] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][0][3] = (dp[i - 1][1][3] + dp[i - 1][1][2]) % G;
                    dp[i][0][1] = (dp[i - 1][1][0] + dp[i - 1][1][1]) % G;
                } else if (j == 9) {
                    dp[i][9][3] = (dp[i - 1][8][3] + dp[i - 1][8][1]) % G;
                    dp[i][9][2] = (dp[i - 1][8][2] + dp[i - 1][8][0]) % G;
                } else {
                    dp[i][j][0] = (dp[i - 1][j - 1][0] + dp[i - 1][j + 1][0]) % G;
                    dp[i][j][1] = (dp[i - 1][j - 1][1] + dp[i - 1][j + 1][1]) % G;
                    dp[i][j][2] = (dp[i - 1][j - 1][2] + dp[i - 1][j + 1][2]) % G;
                    dp[i][j][3] = (dp[i - 1][j - 1][3] + dp[i - 1][j + 1][3]) % G;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[n - 1][i][3]) % G;
        }

        System.out.println(answer);

        br.close();
    }
}