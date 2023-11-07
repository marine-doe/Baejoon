import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 10억
        int l = Integer.parseInt(st.nextToken()); // 2 <= l <= 100

        int s = 0;
        int e = 0;
        int sum = 0;
        int dist = 1;
        int min = INF;

        int j = 0;
        for (int i = 0; i < n / 2 + 2; i++, dist++) {
            sum += i;
            while (sum > n) {
                sum -= j++;
                dist--;
            }
            while (dist > 100) {
                sum -= j++;
                dist--;
            }
            if (sum == n && dist < 101 && dist >= l) {
                if (min > dist) {
                    s = j;
                    e = i;
                    min = dist;
                }
            }
        }

        if (min != INF) {
            if (s == 0 && min - 1 >= l) {
                for (int i = s + 1; i < e + 1; i++) {
                    System.out.print(i + " ");
                }
            }else {
                for (int i = s; i < e + 1; i++) {
                    System.out.print(i + " ");
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}