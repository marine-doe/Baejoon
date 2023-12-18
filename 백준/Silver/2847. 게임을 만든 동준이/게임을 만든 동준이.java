import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int max = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int cur = arr[i];

            if (cur >= max) {
                int diff = cur - max + 1;
                result += diff;
                cur -= diff;
            }

            max = cur;
        }

        System.out.println(result);
    }
}