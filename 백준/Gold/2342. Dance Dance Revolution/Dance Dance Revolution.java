import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int INF = 0xf3f3f3;
    static int[][] cost = {
            {2, 2, 2, 2, 2,},
            {2, 1, 3, 4, 3,},
            {2, 3, 1, 3, 4,},
            {2, 4, 3, 1, 3,},
            {2, 3, 4, 3, 1,}
    };
    public static void main(String[] args) throws Exception {
        /*
        중앙 -> 발판 : 2
        인접한 발판 : 3
        반대편 발판 : 4
        같은 발판 : 1
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = input.length - 1;
        int[] order = new int[n];

        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(input[i]);
        }

        int[][][] dp = new int[n + 1][5][5]; // 입력, 왼발, 오른발

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }

        dp[0][0][0] = 0; // 초기 발 위치 0, 0 에서의 힘의 총량 = 0

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (dp[i][j][k] < INF) {
                        if (order[i] != k) {
                            dp[i + 1][order[i]][k] = Math.min(
                                    dp[i + 1][order[i]][k],
//                                    dp[i][j][k] + powerCalc(order[i], j)
                                    dp[i][j][k] + cost[order[i]][j]
                            );
                        }
                        if (order[i] != j) {
                            dp[i + 1][j][order[i]] = Math.min(
                                    dp[i + 1][j][order[i]],
//                                    dp[i][j][k] + powerCalc(order[i], k)
                                    dp[i][j][k] + cost[order[i]][k]
                            );
                        }
                    }
                }
            }
        }

        /*
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(dp[i][j][k] == INF ? "INF " : dp[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        */

        int answer = INF;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer = Math.min(answer, dp[n][i][j]);
            }
        }
        System.out.println(answer);
    }

//    private static int powerCalc(int x, int y) {
//        if (x == 0 || y == 0) return 2;
//        if (x == y) return 1;
//        if (x % 2 == y % 2) return 4;
//        return 3;
//    }
}