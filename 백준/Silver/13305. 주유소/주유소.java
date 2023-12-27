import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dist = new long[n - 1];
        long[] cost = new long[n];
        long total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
            total += dist[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long result = 0;
        long past = 0;
        int start = 0, end = 1;
        while (end < n - 1) {
            past += dist[end - 1];
            if (cost[start] > cost[end]) { // 뒤에가 더 싸면
                result += cost[start] * past;
                total -= past;
                past = 0;
                start = end;
            }
            end++;
        }

        result += cost[start] * total;

        System.out.println(result);
    }
}