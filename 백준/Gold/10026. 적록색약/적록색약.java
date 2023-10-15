import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] row = {0, 0, 1, -1}, col = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visited;
    static int n, result1, result2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) ;
                else {
                    bfs(i, j, map[i][j]);
                    result1++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'R') map[i][j] = 'G';
            }
        }

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) ;
                else {
                    bfs(i, j, map[i][j]);
                    result2++;
                }
            }
        }

        System.out.println(result1 + " " + result2);
    }

    private static void bfs(int i, int j, char c) {
        Queue<Loc> q = new LinkedList<>();

        q.offer(new Loc(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Loc cur = q.poll();

            int x = cur.x;
            int y = cur.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + row[d];
                int ny = y + col[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] == c) {
                    q.offer(new Loc(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}