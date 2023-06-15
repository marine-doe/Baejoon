import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Gem implements Comparable<Gem> {
        int w, price;

        public Gem(int w, int price) {
            this.w = w;
            this.price = price;
        }

        @Override
        public int compareTo(Gem o) {
            if(o.w == this.w){
                return Integer.compare(o.price, this.price);
            }
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Gem[] gems = new Gem[n];
        int[] bag = new int[k];

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int price = sc.nextInt();
            gems[i] = new Gem(w, price);
        }

        for (int i = 0; i < k; i++) {
            bag[i] = sc.nextInt();
        }

        Arrays.sort(gems);
        Arrays.sort(bag);

        long result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < k; i++) {
            while(j < n && gems[j].w <= bag[i]){
                pq.offer(gems[j++].price);
            }

            if (!pq.isEmpty()){
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}