import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Set<Loc> set;
    static int[][] map;
    static int[] row = {0, 0, 1, -1}, col = {1, -1, 0, 0};
    static int r, c, count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        set = new HashSet<>();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] < 1) {
                    for (int d = 0; d < 4; d++) {
                        int dx = i + row[d];
                        int dy = j + col[d];
                        if (dx >= 0 && dx < r && dy >= 0 && dy < c && map[dx][dy] > 0) {
                            set.add(new Loc(i, j));
                            break;
                        }
                    }
                } else {
                    count++;
                }
            }
        }

        for (int year = 0; ; year++) {
            if (set.isEmpty()) {
                System.out.println(0);
                break;
            }

            if(melting()) {
                System.out.println(++year);
                break;
            }
        }
    }

    private static boolean melting() {
        Stack<Loc> stack = new Stack<>();
        List<Loc> list = new ArrayList<>();

        for (Loc cur : set) {
            boolean flag = false;

            for (int d = 0; d < 4; d++) {
                int dx = cur.x + row[d];
                int dy = cur.y + col[d];
                if (dx >= 0 && dx < r && dy >= 0 && dy < c && map[dx][dy] > 0) {
                    stack.push(new Loc(dx, dy));
                    flag = true;
                }
            }

            if (!flag) list.add(cur);
        }

        for (Loc cur : list) {
            set.remove(cur);
        }

        while (!stack.isEmpty()) {
            Loc cur = stack.pop();

            if (map[cur.x][cur.y] > 0) {
                if (--map[cur.x][cur.y] == 0) {
                    set.add(cur);
                    count--;
                }
            }

            if (stack.isEmpty() && isSplit(cur)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isSplit(Loc loc) {
        Queue<Loc> q = new LinkedList<>();
        q.offer(loc);
        boolean[][] vst = new boolean[r][c];
        vst[loc.x][loc.y] = true;
        int temp = 0;
        if (map[loc.x][loc.y] > 0) temp = 1;

        while (!q.isEmpty()) {
            Loc cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int dx = cur.x + row[d];
                int dy = cur.y + col[d];
                if (map[dx][dy] > 0 && !vst[dx][dy]) {
                    q.offer(new Loc(dx, dy));
                    vst[dx][dy] = true;
                    temp++;
                }
            }
        }

        if (temp != count) return true;

        return false;
    }
}