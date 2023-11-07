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

        boolean flag = true;
        for (int i = l; i < 101; i++) {
            if (i % 2 == 0) {
                int mid = n / i;
                if (mid - i / 2 + 1 >= 0) {
                    int sum = 0;
                    for (int j = mid - i / 2 + 1; j <= mid + i / 2; j++) {
                        sum += j;
                    }
                    if (sum == n) {
                        for (int j = mid - i / 2 + 1; j <= mid + i / 2; j++) {
                            System.out.print(j + " ");
                        }
                        flag = false;
                        break;
                    }
                }
            } else {
                int mid = n / i;
                if (mid - i / 2 >= 0) {
                    int sum = 0;
                    for (int j = mid - i / 2; j <= mid + i / 2; j++) {
                        sum += j;
                    }
                    if (sum == n) {
                        for (int j = mid - i / 2; j <= mid + i / 2; j++) {
                            System.out.print(j + " ");
                        }
                        flag = false;
                        break;
                    }
                }
            }
        }
        if (flag) {
            System.out.println(-1);
        }
    }
}