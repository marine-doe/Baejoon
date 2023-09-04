import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Loc implements Comparable<Loc> {
        int x, y, w;

        public Loc(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Loc o) {
            return this.w - o.w;
        }

        @Override
        public String toString() {
            return "Loc{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static Loc[] swans = new Loc[2];
    static boolean[][] visited;
    static char[][] map;
    static int[][] mapCalc;
    static Queue<Loc> iceQueue = new LinkedList<>();
    static Queue<Loc> waterQueue = new LinkedList<>();
    static int[] row = {-1, 1, 0, 0}, col = {0, 0, -1, 1};
    static int r, c, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        mapCalc = new int[r][c];

        int count = 0;
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'L') swans[count++] = new Loc(i, j, 0);
                if (map[i][j] != 'X') waterQueue.offer(new Loc(i, j, 0));
            }
        }

        visited = new boolean[r][c];
        Melt();

        visited = new boolean[r][c];
        dijkstra(swans[0].x, swans[0].y);

        System.out.println(result);
    }

    private static void dijkstra(int p, int q) {
        PriorityQueue<Loc> pq = new PriorityQueue<>();
        pq.offer(new Loc(p, q, mapCalc[p][q]));

        while (!pq.isEmpty()) {
            Loc cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            int w = mapCalc[x][y];

            if (visited[x][y]) continue;

            result = Math.max(w, result);

            if (x == swans[1].x && y == swans[1].y) return;

            visited[x][y] = true;

            for (int d = 0; d < 4; d++) {
                int nx = x + row[d];
                int ny = y + col[d];
                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    pq.offer(new Loc(nx, ny, mapCalc[nx][ny]));
                }
            }
        }
    }

    private static void Melt() {
        while (!waterQueue.isEmpty() || !iceQueue.isEmpty()) {
            while (!waterQueue.isEmpty()) {
                Loc cur = waterQueue.poll();

                int x = cur.x;
                int y = cur.y;
                int w = cur.w;

                if (visited[x][y]) continue;

                visited[x][y] = true;

                for (int d = 0; d < 4; d++) {
                    int nx = x + row[d];
                    int ny = y + col[d];
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] == 'X') {
                        iceQueue.offer(new Loc(nx, ny, w + 1));
                    }
                }
            }

            while (!iceQueue.isEmpty()) {
                Loc cur = iceQueue.poll();

                int x = cur.x;
                int y = cur.y;
                int w = cur.w;

                if (mapCalc[x][y] == 0) mapCalc[x][y] = w;
                else mapCalc[x][y] = Math.min(mapCalc[x][y], w);

                waterQueue.offer(cur);
            }
        }
    }
}