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

        int budget = Integer.parseInt(br.readLine()); // 배정된 예산
        int rest = budget;
        int m = n;
        int best = budget / m;
        int pre = 0;

        while (rest > 0 && best < arr[n - 1]) {
            int after = lowerBound(arr, best, pre);

            if (after == pre) break;

            for (int i = pre; i < after; i++) {
                rest -= arr[i];
            }

            m = n - after;

            best = rest / m;

            pre = after;
        }

        if (best > arr[n - 1]) {
            System.out.println(arr[n - 1]);
        } else {
            System.out.println(best);
        }

    }

    private static int lowerBound(int[] arr, int target, int start) {
        int lo = start - 1;
        int hi = arr.length;

        while (hi - lo > 1) {
            int mid = (hi + lo) / 2;

            if (arr[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return hi;
    }
}