import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Loc implements Comparable<Loc> {
        int x, y, s;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Loc(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }

        @Override
        public int compareTo(Loc o) {
            return this.s - o.s;
        }
    }

    static List<Loc> fires;
    static char[][] map;
    static int[][] fire;
    static int[] row = {1, -1, 0, 0}, col = {0, 0, -1, 1}, init = new int[2];
    static int h, w, result;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        fires = new ArrayList<>();
        fire = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(fire[i], INF);
        }

        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'F') {
                    fires.add(new Loc(i, j));
                } else if (map[i][j] == 'J') {
                    init[0] = i;
                    init[1] = j;
                }
            }
        }

        fireBfs();
        result = INF;
        bfs(init[0], init[1]);

        System.out.println(result == INF ? "IMPOSSIBLE" : result);

    }

    private static void fireBfs() {
        PriorityQueue<Loc> q = new PriorityQueue<>();

        boolean[][] visited = new boolean[h][w];

        for (Loc loc : fires) {
            q.offer(new Loc(loc.x, loc.y, 0));
            visited[loc.x][loc.y] = true;
        }

        while (!q.isEmpty()) {
            Loc cur = q.poll();

            int x = cur.x;
            int y = cur.y;
            int s = cur.s;

            if (map[x][y] == '#') continue;

            if (fire[x][y] > s) {
                fire[x][y] = s;

                for (int d = 0; d < 4; d++) {
                    int dx = row[d] + x;
                    int dy = col[d] + y;

                    if (dx >= 0 && dx < h && dy >= 0 && dy < w && !visited[dx][dy]) {
                        q.offer(new Loc(dx, dy, s + 1));
                        visited[dx][dy] = true;
                    }
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        PriorityQueue<Loc> q = new PriorityQueue<>();

        boolean[][] visited = new boolean[h][w];

        q.offer(new Loc(x, y, 0));

        visited[x][y] = true;

        out:
        while (!q.isEmpty()) {
            Loc cur = q.poll();

            x = cur.x;
            y = cur.y;
            int s = cur.s;

            if (map[x][y] == '#') continue;
            if (fire[x][y] <= s) continue;

            for (int d = 0; d < 4; d++) {
                int dx = row[d] + x;
                int dy = col[d] + y;

                if (dx < 0 || dy < 0 || dx >= h || dy >= w) {
                    result = Math.min(result, s + 1);
                    break out;
                } else if (!visited[dx][dy]) {
                    q.offer(new Loc(dx, dy, s + 1));
                    visited[dx][dy] = true;
                }
            }
        }
    }
}