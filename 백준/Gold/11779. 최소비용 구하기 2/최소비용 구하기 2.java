import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int s, e, w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Edge>[] edges = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[s].add(new Edge(s, e, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, start, 0));
        costs[start] = 0;

        Stack<int[]> stack = new Stack<>();

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.e]) continue;

            visited[cur.e] = true;
            stack.push(new int[]{cur.s, cur.e});

            if (cur.e == end) {
                System.out.println(cur.w);
                break;
            }

            for (Edge edge : edges[cur.e]) {
                if (costs[edge.e] > costs[cur.e] + edge.w) {
                    costs[edge.e] = costs[cur.e] + edge.w;
                    pq.offer(new Edge(cur.e, edge.e, costs[edge.e]));
                }
            }
        }

        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();

            if (cur[1] == end) {
                temp.push(end);
                end = cur[0];
            }
        }

        System.out.println(temp.size());
        while(!temp.isEmpty()){
            System.out.print(temp.pop() + " ");
        }
    }
}