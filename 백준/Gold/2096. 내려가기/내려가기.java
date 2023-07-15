import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] minmap = new int[n][3];
        int[][] maxmap = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                minmap[i][j] = Integer.parseInt(st.nextToken());
                maxmap[i][j] = minmap[i][j];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    minmap[i][j] += Math.min(minmap[i - 1][j], minmap[i - 1][j + 1]);
                } else if (j == 1) {
                    minmap[i][j] += Math.min(Math.min(minmap[i - 1][j - 1], minmap[i - 1][j]), minmap[i - 1][j + 1]);
                } else {
                    minmap[i][j] += Math.min(minmap[i - 1][j - 1], minmap[i - 1][j]);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxmap[i][j] += Math.max(maxmap[i - 1][j], maxmap[i - 1][j + 1]);
                } else if (j == 1) {
                    maxmap[i][j] += Math.max(Math.max(maxmap[i - 1][j - 1], maxmap[i - 1][j]), maxmap[i - 1][j + 1]);
                } else {
                    maxmap[i][j] += Math.max(maxmap[i - 1][j - 1], maxmap[i - 1][j]);
                }
            }
        }

        int min = Math.min(Math.min(minmap[n - 1][0], minmap[n - 1][1]), minmap[n - 1][2]);
        int max = Math.max(Math.max(maxmap[n - 1][0], maxmap[n - 1][1]), maxmap[n - 1][2]);

        System.out.println(max + " " + min);
    }
}