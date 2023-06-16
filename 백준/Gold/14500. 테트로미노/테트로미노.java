import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int result = Integer.MIN_VALUE;
    static boolean[][] visited;
    static int[] row = {1, 0, 0, -1};
    static int[] col = {0, 1, -1, 0};
    static int[][] arr;
    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 1, 0);
                getSpecial(i, j);
            }
        }

        System.out.println(result);
    }

    private static void getSpecial(int x, int y) {
        int sum = 0;
        if (x > 0 && y > 0 && y < m - 1) {
            sum = arr[x][y] + arr[x - 1][y] + arr[x][y - 1] + arr[x][y + 1];
            result = Math.max(result, sum);
        }
        if (x < n - 1 && y > 0 && y < m - 1) {
            sum = arr[x][y] + arr[x + 1][y] + arr[x][y - 1] + arr[x][y + 1];
            result = Math.max(result, sum);
        }
        if (y > 0 && x > 0 && x < n - 1) {
            sum = arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y - 1];
            result = Math.max(result, sum);
        }
        if (y < m - 1 && x > 0 && x < n - 1) {
            sum = arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y + 1];
            result = Math.max(result, sum);
        }
    }

    private static void dfs(int i, int j, int depth, int sum) {
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j]) {
            return;
        }

        sum += arr[i][j];

        if (depth == 4) {
            result = Math.max(sum, result);
            return;
        }

        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int nr = i + row[d];
            int nc = j + col[d];
            dfs(nr, nc, depth + 1, sum);
        }
        visited[i][j] = false;
    }
}