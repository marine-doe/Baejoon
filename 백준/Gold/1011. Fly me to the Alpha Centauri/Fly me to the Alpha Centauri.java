import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long n = y - x;

            long dist = 0;
            long top = 0;
            long answer = 0;
            boolean flag = true;

            while (dist < n) {
                if (flag) top += 1;
                dist += top;
                flag = !flag;
                answer++;
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}