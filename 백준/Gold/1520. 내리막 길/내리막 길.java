import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] map, dp;
    static int[] row = {0, 0, 1, -1}, col = {1, -1, 0, 0};
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        System.out.println(dfs(n - 1, m - 1));
    }

    private static int dfs(int x, int y) {
        if (visited[x][y]) return dp[x][y];

        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int dx = x + row[d];
            int dy = y + col[d];

            if (dx >= 0 && dx < n && dy >= 0 && dy < m && map[dx][dy] > map[x][y]) {
                dp[x][y] += dfs(dx, dy);
            }
        }

        return dp[x][y];
    }
}