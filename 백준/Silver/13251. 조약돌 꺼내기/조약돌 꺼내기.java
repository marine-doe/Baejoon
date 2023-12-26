import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] stones = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;

        for (int i = 0; i < n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
            sum += stones[i];
        }

        int k = Integer.parseInt(br.readLine());

        double totalCase = 1.0;
        for (int i = sum; i > sum - k; i--) {
            totalCase *= i;
        }

        double result = 0.0;

        for (int i = 0; i < n; i++) {
            if (stones[i] - k < 0) {
                continue;
            }

            double c = 1.0;

            for (int j = stones[i]; j > stones[i] - k; j--) {
                c *= j;
            }

            result += c / totalCase;
        }

        System.out.println(result);
    }
}