import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dist = new int[n - 1];
        int[] cost = new int[n];
        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
            total += dist[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        int start = 0, end = 1;
        while (end < n - 1) {
            if (cost[start] > cost[end]) { // 뒤에가 더 싸면
                while (start < end) {
                    result += cost[start] * dist[start];
                    total -= dist[start++];
                }
            }
            end++;
        }

        result += cost[start] * total;

        System.out.println(result);
    }
}