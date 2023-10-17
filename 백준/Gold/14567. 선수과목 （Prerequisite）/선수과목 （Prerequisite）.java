import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 1000까지
        int m = Integer.parseInt(st.nextToken()); // 500000까지

        int[] dp = new int[n + 1];
        boolean[][] adj = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int pre = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            adj[pre][after] = true;
        }

        for (int after = 1; after < n + 1; after++) {
            dp[after] = 1;

            for (int pre = 1; pre < after; pre++) {
                if (adj[pre][after]) dp[after] = Math.max(dp[after], dp[pre] + 1);
            }
        }

        for (int i = 1; i < n + 1; i++) {
            bw.write(dp[i] + " ");
        }

        bw.flush();
    }
}