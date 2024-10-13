import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] AB, CD;
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

        AB = new int[N];
        CD = new int[N];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx] = arrays[i][0] + arrays[j][1];
                CD[idx++] = arrays[i][2] + arrays[j][3];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0L;

        int left = 0, right = N - 1;

        while (left < N && right >= 0) {
            if (AB[left] + CD[right] < 0) left++;
            else if (AB[left] + CD[right] > 0) right--;
            else {
                int target = AB[left];
                long leftCnt = upperBound(target) - left;
                long rightCnt = right - lowerBound(-target);
                answer += leftCnt * rightCnt;
                left += leftCnt;
                right -= rightCnt;
            }
        }

        System.out.println(answer);
    }

    private static int lowerBound(int target) {
        int lo = -1, hi = N;

        while (hi - lo > 1) {
            int mid = (hi + lo) / 2;

            if (CD[mid] < target) lo = mid;
            else hi = mid;
        }

        return lo;
    }

    private static int upperBound(int target) {
        int lo = -1, hi = N;

        while (hi - lo > 1) {
            int mid = (hi + lo) / 2;

            if (AB[mid] > target) hi = mid;
            else lo = mid;
        }

        return hi;
    }
}