import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adj;
    static int[] indegree;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];

        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int k = Integer.parseInt(st.nextToken());

            int pre = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k - 1; j++) {
                int post = Integer.parseInt(st.nextToken());

                adj[pre].add(post);

                indegree[post]++;

                pre = post;
            }
        }

        String answer = topologySort();

        System.out.print(answer);
    }

    private static String topologySort() {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            list.add(cur);

            for (int next :adj[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (list.size() != n) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(list.get(i)).append("\n");
        }

        return sb.toString();
    }
}