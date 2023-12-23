import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int[] row = {1, -1}, col = {1, -1};
    static int n, m, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];

        dfs(0, 0, 0);

        System.out.println(result);
    }

    private static void dfs(int x, int y, int sum) {
        if (x >= n) {
            result = Math.max(result, sum);
            return;
        } else if (y >= m) {
            dfs(x + 1, 0, sum);
            return;
        } else if (visited[x][y]) {
            dfs(x, y + 1, sum);
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int dx = x + row[i];
                int dy = y + col[j];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[x][dy] && !visited[dx][y]) {
                    int value = 2 * map[x][y] + map[x][dy] + map[dx][y];

                    visited[x][y] = true;
                    visited[x][dy] = true;
                    visited[dx][y] = true;

                    dfs(x, y + 1, sum + value);

                    visited[x][y] = false;
                    visited[x][dy] = false;
                    visited[dx][y] = false;
                }
            }
        }

        dfs(x, y + 1, sum);
    }
}