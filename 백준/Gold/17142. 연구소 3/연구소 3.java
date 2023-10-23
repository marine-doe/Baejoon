import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Loc implements Comparable<Loc>{
        int x, y, day;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
            this.day = 0;
        }

        public Loc(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }

        @Override
        public int compareTo(Loc o) {
            return this.day - o.day;
        }
    }

    static int[][] map;
    static int[] row = {0, 0, -1, 1}, col = {1, -1, 0, 0};
    static int n, m, empty, result = Integer.MAX_VALUE;
    static List<Loc> virus = new ArrayList<>();
    static PriorityQueue<Loc> pq;
    static boolean[][] filled;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    empty++;
                } else if (map[i][j] == 2) {
                    virus.add(new Loc(i, j));
                }
            }
        }

        visited = new boolean[virus.size()];
        combination(0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void combination(int start, int depth) {
        if (depth == m) {
            pq = new PriorityQueue<>();
            filled = new boolean[n][n];

            for (int i = 0; i < virus.size(); i++) {
                if (visited[i]) {
                    Loc temp = virus.get(i);
                    pq.offer(temp);
                    filled[temp.x][temp.y] = true;
                }
            }

            spread();

            return;
        }

        for (int i = start; i < virus.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void spread() {
        int temp = empty;
        int max = 0;

        while (!pq.isEmpty()) {
            Loc cur = pq.poll();

            if (map[cur.x][cur.y] == 0) temp--;

            max = Math.max(max, cur.day);

            if (temp == 0) result = Math.min(max, result);

            for (int d = 0; d < 4; d++) {
                int dx = cur.x + row[d];
                int dy = cur.y + col[d];
                if (dx >= 0 && dx < n && dy >= 0 && dy < n && !filled[dx][dy]) {
                    if (map[dx][dy] != 1) {
                        pq.offer(new Loc(dx, dy, cur.day + 1));
                        filled[dx][dy] = true;
                    }
                }
            }
        }
    }
}