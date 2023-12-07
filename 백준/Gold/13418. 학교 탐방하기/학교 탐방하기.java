import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int[] parent;
    static int n, m, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[m + 1][3];
        parent = new int[n + 1];

        for (int i = 0; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());

            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (c == 0) {
                graph[i][2] = 1;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
        maxKruskal();

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        minKruskal();

        System.out.println(result);
    }

    private static void minKruskal() {
        int tired = 0;
        for (int i = m; i >= 0; i--) {
            if (find(graph[i][0]) != find(graph[i][1])) {
                tired += graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
        result += (tired * tired);
    }

    private static void maxKruskal() {
        int tired = 0;
        for (int i = 0; i < m + 1; i++) {
            if (find(graph[i][0]) != find(graph[i][1])) {
                tired += graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
        result -= (tired * tired);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return find(parent[x]);
    }
}