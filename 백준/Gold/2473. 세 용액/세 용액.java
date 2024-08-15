import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long min = Long.MAX_VALUE;
    static long[] solution, answers = new long[3];
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        solution = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);

        for (int i = 0; i < n - 2; i++) {
            twoPointers(i);
        }

        Arrays.sort(answers);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            sb.append(answers[i] + " ");
        }

        System.out.println(sb);
    }

    private static void twoPointers(int idx) {
        int l = idx + 1, r = n - 1;

        while (l < r) {

            long mix = solution[idx] + solution[l] + solution[r];
            long mixAbs = Math.abs(mix);

            if (mixAbs < min) {
                answers[0] = solution[idx];
                answers[1] = solution[l];
                answers[2] = solution[r];
                min = mixAbs;
            }

            if (mix > 0) {
                r--;
            } else if (mix < 0) {
                l++;
            } else {
                return;
            }
        }
    }
}