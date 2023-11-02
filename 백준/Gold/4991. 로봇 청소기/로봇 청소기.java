import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class cleaner {
        int x, y, dist;

        public cleaner(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static char[][] map;
    static int[][] dustDist;
    static int[] col = {-1, 1, 0, 0}, row = {0, 0, -1, 1}, init;
    static int w, h, n, total, result;
    static boolean[][] visited;
    static boolean[] vp;
    static boolean isPossible;
    static List<int[]> dusts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        out: while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            isPossible = true;
            map = new char[h][w];
            dusts = new ArrayList<>();
            dusts.add(new int[]{});
            result = Integer.MAX_VALUE;

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 'o') {
                        init = new int[]{i, j};
                        map[i][j] = '.';
                    } else if (map[i][j] == '*') {
                        dusts.add(new int[]{i, j});
                    }
                }
            }

            n = dusts.size() - 1;

            dustDist = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                dustDist[i][0] = bfs(init[0], init[1], dusts.get(i)[0], dusts.get(i)[1]);
                dustDist[0][i] = dustDist[i][0];
                if (!isPossible) {
                    System.out.println(-1);
                    continue out;
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    dustDist[i][j] = bfs(dusts.get(i)[0], dusts.get(i)[1], dusts.get(j)[0], dusts.get(j)[1]);
                    dustDist[j][i] = dustDist[i][j];
                    if (!isPossible) {
                        System.out.println(-1);
                        continue out;
                    }
                }
            }

            vp = new boolean[n + 1];
            total = 0;

            permutation(0, 0);

            System.out.println(result);
        }
    }

    private static void permutation(int pre, int depth) {
        if (total >= result) return;
        else if (depth == n) {
            result = Math.min(result, total);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!vp[i]) {
                int dist = dustDist[pre][i];
                vp[i] = true;
                total += dist;

                permutation(i, depth + 1);

                total -= dist;
                vp[i] = false;
            }
        }
    }

    private static int bfs(int sx, int sy, int ex, int ey) {
        Queue<cleaner> q = new LinkedList<>();

        visited = new boolean[h][w];

        q.offer(new cleaner(sx, sy, 0));
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            cleaner cur = q.poll();

            if (map[cur.x][cur.y] == 'x') continue;

            if (ex == cur.x && ey == cur.y) {
                return cur.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + row[d];
                int ny = cur.y + col[d];
                if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny]) {
                    q.offer(new cleaner(nx, ny, cur.dist + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        isPossible = false;

        return 0;
    }
}