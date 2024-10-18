import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        final int INF = 10_001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(value);

        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (value[i] * j <= k) {
                    dp[value[i] * j] = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = value[i] + 1; j < k + 1; j++) {
                if (dp[j - value[i]] != INF) {
                    dp[j] = Math.min(dp[j - value[i]] + 1, dp[j]);
                }
            }
        }

        int answer = dp[k];

        System.out.println(answer == INF ? -1 : answer);
    }
}