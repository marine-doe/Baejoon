import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static List<Edge>[] edges;
    static List<Integer>[] removeList;
    static boolean[][] isRemoved;
    static int[] dist;
    static int n, m, s, d;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        while (true) {
            if (!input()) break;

            dijkstra();
            remove(d);
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra();

            sb.append(dist[d] == Integer.MAX_VALUE ? -1 : dist[d]).append("\n");
        }
        System.out.println(sb);
    }

    private static void remove(int cur) {
        if (cur == s) return;

        for (int post : removeList[cur]) {
            if (!isRemoved[post][cur]) {
                isRemoved[post][cur] = true;
                remove(post);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.offer(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.w > dist[cur.to]) continue;

            for (Edge next : edges[cur.to]) {
                if (isRemoved[cur.to][next.to]) continue;

                if (dist[next.to] > dist[cur.to] + next.w) {
                    dist[next.to] = dist[cur.to] + next.w;

                    removeList[next.to] = new ArrayList<>();
                    removeList[next.to].add(cur.to);

                    pq.offer(new Edge(next.to, dist[next.to]));
                }
                else if (dist[next.to] == dist[cur.to] + next.w) {
                    removeList[next.to].add(cur.to);
                }
            }
        }
    }

    private static boolean input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n == 0 || m == 0) return false;

        isRemoved = new boolean[n][n];
        dist = new int[n];
        removeList = new ArrayList[n];
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            removeList[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            edges[u].add(new Edge(v, p));
        }

        return true;
    }
}