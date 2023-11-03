import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Set<Loc> students = new HashSet<>();
    static char[][] map;
    static int[] row = {0, 0, 1, -1}, col = {1, -1, 0, 0};
    static int n;
    static boolean[][] visited;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'S') students.add(new Loc(i, j));
            }
        }

        dfs(0, 0, 0);

        System.out.println(flag ? "YES" : "NO");
    }

    private static void dfs(int depth, int x, int y) {
        if (flag) return;
        if (depth == 3) {
            if (isPossible()) flag = true;
            return;
        }

        int j = y;
        for (int i = x; i < n; i++) {
            for (; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 'X') {
                    visited[i][j] = true;
                    map[i][j] = 'O';
                    dfs(depth + 1, i, j);
                    map[i][j] = 'X';
                    visited[i][j] = false;
                }
            }
            j = 0;
        }
    }

    private static boolean isPossible() {
        for (Loc student : students) {
            int x = student.x;
            int y = student.y;
            for (int d = 0; d < 4; d++) {
                for (int k = 1; k < n; k++) {
                    int dx = x + row[d] * k;
                    int dy = y + col[d] * k;
                    if (dx >= 0 && dx < n && dy >= 0 && dy < n) {
                        if (map[dx][dy] == 'T') return false;
                        else if (map[dx][dy] == 'O') break;
                    }
                }
            }
        }

        return true;
    }
}