import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int good = 0;
        for (int i = 0; i < n; i++) {
            int lo = 0;
            int hi = n - 1;
            int key = arr[i];
            while (hi > lo) {
                if (lo == i) {
                    lo++;
                    continue;
                } else if (hi == i) {
                    hi--;
                    continue;
                }

                int isGood = arr[lo] + arr[hi];

                if (isGood > key) {
                    hi--;
                } else if (isGood < key) {
                    lo++;
                } else {
                    good++;
                    break;
                }
            }
        }

        System.out.println(good);
    }
}