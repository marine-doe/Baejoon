import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, result;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(result);
    }

    private static void dfs(int x, int y, int dir) {
        if (x == n - 1 && y == n - 1) {
            result++;
            return;
        }

        switch (dir) {
            case 0: // 가로
                if (y + 1 < n && map[x][y + 1] == 0) {
                    dfs(x, y + 1, 0);
                    if (x + 1 < n && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
                        dfs(x + 1, y + 1, 1);
                    }
                }
                break;
            case 1: // 대각선
                if (x + 1 < n && y + 1 < n && map[x + 1][y + 1] == 0 && map[x + 1][y] == 0 && map[x][y + 1] == 0) {
                    dfs(x + 1, y + 1, 1);
                }
                if (y + 1 < n && map[x][y + 1] == 0) {
                    dfs(x, y + 1, 0);
                }
                if (x + 1 < n && map[x + 1][y] == 0) {
                    dfs(x + 1, y, 2);
                }
                break;
            case 2: // 세로
                if (x + 1 < n && map[x + 1][y] == 0) {
                    dfs(x + 1, y, 2);
                    if (y + 1 < n && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
                        dfs(x + 1, y + 1, 1);
                    }
                }
                break;
        }
    }
}