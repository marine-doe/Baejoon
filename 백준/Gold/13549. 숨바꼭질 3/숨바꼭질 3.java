import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Node {
        int x, time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    static final int range = 100000;
    static boolean[] visited;
    static int sb, ds, result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sb = sc.nextInt(); // 수빈
        ds = sc.nextInt(); // 동생

        visited = new boolean[range + 1];
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sb, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            visited[x] = true;
            int time = cur.time;
            if (x == ds) {
                result = Math.min(result, time);
            }
            if (x * 2 <= range && !visited[x * 2]) {
                q.offer(new Node(x * 2, time));
            }
            if (x + 1 <= range && !visited[x + 1]) {
                q.offer(new Node(x + 1, time + 1));
            }
            if (x - 1 >= 0 && !visited[x - 1]) {
                q.offer(new Node(x - 1, time + 1));
            }
        }
    }
}