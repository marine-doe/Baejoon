import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int need = Integer.parseInt(st.nextToken());

        int[] memories = new int[n];
        int[] costs = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][10001];

        for (int i = 0; i < n; i++) {
            int memory = memories[i];
            int cost = costs[i];

            for (int j = cost; j < 10001; j++) {
                dp[0][j] = Math.max(dp[1][j], dp[1][j - cost] + memory);
            }

            for (int j = 0; j < 10001; j++) {
                dp[1][j] = dp[0][j];
            }
        }

        for (int i = 0; i < 10001; i++) {
            if (dp[1][i] >= need) {
                System.out.println(i);
                break;
            }
        }
    }
}