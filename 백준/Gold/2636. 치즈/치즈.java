import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] row = {1, -1, 0, 0};
    static int[] col = {0, 0, -1, 1};
    static int[][] map;
    static int r, c, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        int time = 0;
        int result = 0;

        while (count != 0) {
            result = count;
            Air();
            Melt();
            time++;
        }

        System.out.println(time);
        System.out.println(result);
    }

    // 2와 접촉한 0을 2로 만들자
    private static void Air() {
        int x = 0, y = 0;

        outer: for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) {
                    x = i;
                    y = j;
                    break outer;
                }
            }
        }

        boolean[][] visited = new boolean[r][c];
        Queue<Loc> locs = new LinkedList<>();
        locs.offer(new Loc(x, y));
        visited[x][y] = true;
        while (!locs.isEmpty()) {
            Loc cur = locs.poll();
            if (map[cur.x][cur.y] == 0) {
                map[cur.x][cur.y] = 2;
            }
            for (int d = 0; d < 4; d++) {
                int nr = cur.x + row[d];
                int nc = cur.y + col[d];
                if (nr >= 0 && nr < r && nc >= 0 && nc < c && (map[nr][nc] == 0 || map[nr][nc] == 2) && !visited[nr][nc]) {
                    locs.offer(new Loc(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    // 2와 접촉한 1을 표시한 후 표시한 곳을 0으로 바꾼다.
    private static void Melt() {
        int result = 0;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + row[d];
                        int nc = j + col[d];
                        if (map[nr][nc] == 2) {
                            visited[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visited[i][j]) {
                    count--;
                    map[i][j] = 0;
                }
            }
        }
    }
}