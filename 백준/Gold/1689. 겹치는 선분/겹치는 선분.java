import java.util.*;

public class Main {
    static class Spot implements Comparable<Spot> {
        int point, type;

        public Spot(int point, int type) {
            this.point = point;
            this.type = type;
        }

        @Override
        public int compareTo(Spot o) {
            if (this.point == o.point) {
                return Integer.compare(this.type, o.type);
            }
            return Integer.compare(this.point, o.point);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Spot> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            pq.offer(new Spot(start, 1));
            pq.offer(new Spot(end, 0));
        }

        int result = 0;
        int crossCount = 0;

        while (!pq.isEmpty()) {
            Spot cur = pq.poll();
            if (cur.type == 1) {
                crossCount++;
                result = Math.max(result, crossCount);
            } else {
                crossCount--;
            }
        }

        System.out.println(result);
    }
}