import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n];

        int sum = 0;
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());

            sum += map[i];
            max = Math.max(max, map[i]);
        }

        int m = Integer.parseInt(br.readLine());

        if (m < sum) {
            Arrays.sort(map);

            int avg = m / n;
            int rest = m;
            int idx = 0;

            while(true) {
                for (; idx < n; idx++) {
                    if (map[idx] > avg) break;
                    else rest -= map[idx];
                }

                if (idx == n) break;

                avg = rest / (n - idx);

                if (avg <= map[idx]) {
                    max = avg;
                    break;
                }
            }
        }

        System.out.println(max);
    }
}