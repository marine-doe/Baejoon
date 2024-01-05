import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] balls = br.readLine().toCharArray();

        int result = Math.min(red(balls), blue(balls));

        System.out.println(result);
    }

    private static int red(char[] balls) {
        int redSum = 0, result = 0;

        for (char ball : balls) {
            if (ball == 'R') {
                redSum++;
            } else {
                result += redSum;
                redSum = 0;
            }
        }

        return result;
    }

    private static int blue(char[] balls) {
        int blueSum = 0, result = 0;

        for (char ball : balls) {
            if (ball == 'B') {
                blueSum++;
            } else {
                result += blueSum;
                blueSum = 0;
            }
        }

        return result;
    }
}