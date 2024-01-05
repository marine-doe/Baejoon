import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] balls = br.readLine().toCharArray();

        int result = Math.min(red(n, balls), blue(n, balls));

        System.out.println(result);
    }

    private static int red(int n, char[] balls) {
        int redSum = 0, result1 = 0;

        for (char ball : balls) {
            if (ball == 'R') {
                redSum++;
            } else {
                result1 += redSum;
                redSum = 0;
            }
        }

        int blueSum = 0, result2 = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (balls[i] == 'B') {
                blueSum++;
            } else {
                result2 += blueSum;
                blueSum = 0;
            }
        }

        return Math.min(result1, result2);
    }

    private static int blue(int n, char[] balls) {
        int blueSum = 0, result1 = 0;

        for (char ball : balls) {
            if (ball == 'B') {
                blueSum++;
            } else {
                result1 += blueSum;
                blueSum = 0;
            }
        }

        int redSum = 0, result2 = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (balls[i] == 'R') {
                redSum++;
            } else {
                result2 += redSum;
                redSum = 0;
            }
        }

        return Math.min(result1, result2);
    }
}