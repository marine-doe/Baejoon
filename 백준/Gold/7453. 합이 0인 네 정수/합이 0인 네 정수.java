import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] CD;
    static int n, N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        N = n * n;

        int[][] arrays = new int[n][4];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());

                arrays[i][j] = num;
            }
        }

        int[] AB = new int[N];
        CD = new int[N];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx] = arrays[i][0] + arrays[j][1];
                CD[idx++] = arrays[i][2] + arrays[j][3];
            }
        }

        Arrays.sort(CD);

        long answer = 0L;

        for (int i = 0; i < N; i++) {
            int cur = AB[i];

            answer += (upperBound(-cur) - lowerBound(-cur));
        }

        System.out.println(answer);
    }

    private static long lowerBound(int target) {
        int left = 0, right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (CD[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static long upperBound(int target) {
        int left = 0, right = N;

        while (left < right) {
            int mid = (left + right) / 2;

            if (CD[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}