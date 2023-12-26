import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] kit;
    static int n, k, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kit = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);

        System.out.println(result);
    }

    private static void dfs(int depth, int std) {
        if (depth > n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && std + kit[i] >= depth * k) {
                visited[i] = true;

                dfs(depth + 1, std + kit[i]);

                visited[i] = false;
            }
        }
    }
}