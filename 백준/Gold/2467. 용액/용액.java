import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] solution = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        int left = 0, right = n - 1;
        int l = left, r = right;

        while (l < r) {
            int mix = solution[l] + solution[r];

            if (Math.abs(mix) < min) {
                min = Math.abs(mix);
                left = l;
                right = r;
            }

            if (mix < 0) l++;
            else if (mix > 0) r--;
            else break;
        }

        System.out.print(solution[left] + " " + solution[right]);
    }
}