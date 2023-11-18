import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static char[][] map;
    static int[] row = {-1, 1, 0, 0}, col = {0, 0, 1, -1};
    static int n, m, max;
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        if (!set.contains(map[i][j])) {
            set.add(map[i][j]);
            max = Math.max(max, set.size());

            for (int d = 0; d < 4; d++) {
                int dx = i + row[d];
                int dy = j + col[d];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[dx][dy]) {
                    dfs(dx, dy);
                }
            }

            set.remove(map[i][j]);
        }
        
        visited[i][j] = false;
    }
}