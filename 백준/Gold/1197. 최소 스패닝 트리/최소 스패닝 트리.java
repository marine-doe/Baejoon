import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x, w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[v + 1];

        List<Node>[] adj = new ArrayList[v + 1];
        for (int i = 1; i < v + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int aft = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[pre].add(new Node(aft, w));
            adj[aft].add(new Node(pre, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        int answer = 0;
        int count = 0;

        here:
        while (count < v) {
            Node cur = pq.poll();
            int pre = cur.x;
            int w = cur.w;

            if (!visited[pre]) {
                visited[pre] = true;
                for (int i = 0; i < adj[pre].size(); i++) {
                    if (!visited[adj[pre].get(i).x]) {
                        pq.offer(adj[pre].get(i));
                    }
                }
                count++;
                answer += w;
            }
        }

        System.out.println(answer);
    }
}