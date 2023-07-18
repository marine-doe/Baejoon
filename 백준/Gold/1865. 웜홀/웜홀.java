import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Way implements Comparable<Way> {
        int e, t;

        public Way(int e, int t) {
            this.e = e;
            this.t = t;
        }

        @Override
        public int compareTo(Way o) {
            return this.t - o.t;
        }
    }

    static List<Way>[] ways;

    static int n, m, w;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());

        outer:
        for (int tc = 0; tc < test_case; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            ways = new ArrayList[n + 1];
            for (int i = 1; i < n + 1; i++) {
                ways[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                ways[s].add(new Way(e, t));
                ways[e].add(new Way(s, t));
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                ways[s].add(new Way(e, -t));
            }

            for (int i = 1; i < n + 1; i++) {
                if (isPossible(i)) {
                    System.out.println("YES");
                    continue outer;
                }
            }

            System.out.println("NO");
        }
    }

    private static boolean isPossible(int init) {
        int[] times = new int[n + 1];
        Arrays.fill(times, INF);
        times[init] = 0;
        boolean renew = false;

        for (int i = 1; i < n; i++) {
            renew = false;

            for (int j = 1; j < n + 1; j++) {
                for (Way way : ways[j]) {
                    if (times[j] != INF && times[way.e] > times[j] + way.t){
                        times[way.e] = times[j] + way.t;
                        renew = true;
                    }
                }
            }

            if (!renew) break;
        }

        if (renew) {
            for (int i = 1; i < n + 1; i++) {
                for (Way way : ways[i]) {
                    if (times[i] != INF && times[way.e] > times[i] + way.t){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}