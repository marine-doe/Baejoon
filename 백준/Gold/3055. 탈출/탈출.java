import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Loc implements Comparable<Loc>{
        int x, y, t;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
            this.t = 0;
        }

        public Loc(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        @Override
        public int compareTo(Loc o) {
            return this.t - o.t;
        }
    }

    static char[][] map;
    static int[][] copyMap;
    static int[] row = {0, 0, -1, 1}, col = {1, -1, 0, 0};
    static final int INF = Integer.MAX_VALUE;
    static int r, c, result = INF;
    static List<Loc> waters = new ArrayList<>();
    static Loc start;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        copyMap = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(copyMap[i], INF);
        }

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') {
                    waters.add(new Loc(i, j));
                } else if (map[i][j] == 'S') {
                    start = new Loc(i, j);
                }
            }
        }

        waterBfs();
        System.out.println(isPossible() ? result : "KAKTUS");
    }

    private static void waterBfs() {
        for (Loc water : waters) {
            PriorityQueue<Loc> pq = new PriorityQueue<>();
            boolean[][] visited = new boolean[r][c];
            pq.offer(water);
            visited[water.x][water.y] = true;
            copyMap[water.x][water.y] = 0;

            while (!pq.isEmpty()) {
                Loc cur = pq.poll();

                for (int d = 0; d < 4; d++) {
                    int dx = cur.x + row[d];
                    int dy = cur.y + col[d];
                    if (dx >= 0 && dx < r && dy >= 0 && dy < c && !visited[dx][dy] && map[dx][dy] == '.' && copyMap[dx][dy] > cur.t + 1) {
                        pq.offer(new Loc(dx, dy, cur.t + 1));
                        visited[dx][dy] = true;
                        copyMap[dx][dy] = cur.t + 1;
                    }
                }
            }
        }
    }

    private static boolean isPossible() {
        PriorityQueue<Loc> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[r][c];
        pq.offer(start);
        visited[start.x][start.y] = true;

        while (!pq.isEmpty()) {
            Loc cur = pq.poll();
            int x = cur.x;
            int y = cur.y;

            if (map[x][y] == 'D') {
                result = cur.t;
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int dx = x + row[d];
                int dy = y + col[d];
                if (dx >= 0 && dx < r && dy >= 0 && dy < c && !visited[dx][dy] && map[dx][dy] != 'X') {
                    if (copyMap[dx][dy] > cur.t + 1) {
                        pq.offer(new Loc(dx, dy, cur.t + 1));
                        visited[dx][dy] = true;
                    }
                }
            }
        }

        return false;
    }
}