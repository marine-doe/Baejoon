import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 10억
        int l = Integer.parseInt(st.nextToken()); // 2 <= l <= 100

        for (int i = l; i < 101; i++) {
            int mid = n / i;
            if (i % 2 == 0) {
                int start = mid - i / 2 + 1;
                int end = mid + i / 2;
                if (start >= 0) {
                    if (i * (start + end) / 2 == n) {
                        for (int j = start; j <= end; j++) {
                            sb.append(j + " ");
                        }
                        break;
                    }
                }
            } else {
                int start = mid - i / 2;
                int end = mid + i / 2;
                if (start >= 0) {
                    if (i * (start + end) / 2 == n) {
                        for (int j = start; j <= end; j++) {
                            sb.append(j + " ");
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(sb.length() == 0 ? -1 : sb);
    }
}