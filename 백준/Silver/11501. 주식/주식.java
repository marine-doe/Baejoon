import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[] stock = new int[n];
            int[] count = new int[10001];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                stock[i] = Integer.parseInt(st.nextToken());
                count[stock[i]]++;
            }

            long result = 0L;

            int start = 0, end = 0;

            for (int cnt = 10000; cnt > 0; cnt--) {
                if (count[cnt] > 0) {
                    for (int i = end; i < n; i++) {
                        count[stock[i]]--;

                        if (cnt == stock[i]) {
                            end = i + 1;
                            while (start < end) {
                                result += cnt - stock[start++];
                            }
                            break;
                        }
                    }

                    cnt++;
                }
            }

            System.out.println(result);
        }
    }
}