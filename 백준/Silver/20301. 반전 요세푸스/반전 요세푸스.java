import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        boolean plus = true;

        StringBuilder sb = new StringBuilder();

        int idx = k - 1;
        int cnt = 0;
        while (true) {
            sb.append(list.remove(idx) + "\n");

            if (list.size() <= 1) break;

            cnt++;

            if (cnt == m) {
                cnt = 0;
                plus = !plus;
            }

            if (plus) {
                idx = (idx + k - 1) % list.size();
            } else {
                idx -= k;
                while (idx < 0) {
                    idx += list.size();
                }
            }
        }
        if (list.size() == 1) {
            sb.append(list.remove(0) + "\n");
        }

        System.out.println(sb);
    }
}