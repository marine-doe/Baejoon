import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Point {
        int x, y, d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int[] row = {0, 0, 1, -1};
    static int[] col = {1, -1, 0, 0};
    static char[][] map;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            map[i] = line.toCharArray();
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    int dist = getDistance(i, j);
                    result = Math.max(result, dist);
                }
            }
        }

        System.out.println(result);
    }

    private static int getDistance(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.offer(new Point(x, y, 0));
        visited[x][y] = true;

        int max = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            max = Math.max(max, cur.d);
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + row[i];
                int ny = cur.y + col[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 'L') {
                    q.offer(new Point(nx, ny, cur.d + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return max;
    }
}