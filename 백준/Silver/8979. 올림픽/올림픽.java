import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Olympic implements Comparable<Olympic> {
        int idx, g, s, b;

        Olympic(int idx, int g, int s, int b) {
            this.idx = idx;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public int compareTo(Olympic o) {
            if (this.g == o.g) {
                if (this.s == o.s) {
                    return Integer.compare(o.b, this.b);
                }
                return Integer.compare(o.s, this.s);
            }
            return Integer.compare(o.g, this.g);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Olympic target = new Olympic(0, 0, 0, 0); // 타겟이 되는 정보
        PriorityQueue<Olympic> pq = new PriorityQueue<>();

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(new Olympic(idx, g, s, b));
            if (idx == k) {
                target = new Olympic(idx, g, s, b);
            }
        }

        int result = 1;

        while (!pq.isEmpty()) {
            Olympic cur = pq.poll();
            if (cur.idx == target.idx) {
                break;
            } else if (cur.g == target.g && cur.s == target.s && cur.b == target.b) {

            } else {
                result++;
            }
        }

        System.out.println(result);
    }
}