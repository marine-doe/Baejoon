import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int ed, dist;

        public Edge(int ed, int dist) {
            this.ed = ed;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
    static final int INF = Integer.MAX_VALUE;
    static int v, e, init;
    static int[] result;
    static List<Edge>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        init = Integer.parseInt(br.readLine());

        result = new int[v + 1];
        Arrays.fill(result, INF);

        adj = new ArrayList[v + 1];
        for (int i = 1; i < v + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[start].add(new Edge(end, dist));
        }

        ShortCut(init);

        for (int i = 1; i < v + 1; i++) {
            if (result[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }

    private static void ShortCut(int init) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v + 1];
        pq.add(new Edge(init, 0));
        result[init] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int ed = cur.ed;

            if (visited[ed]) continue;
            visited[ed] = true;

            for (Edge e : adj[ed]) {
                if (result[e.ed] > result[ed] + e.dist) {
                    result[e.ed] = result[ed] + e.dist;
                    pq.add(new Edge(e.ed, result[e.ed]));
                }
            }
        }
    }
}