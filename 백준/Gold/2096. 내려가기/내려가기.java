import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] maxMemo = new int[2][3];
        int[][] minMemo = new int[2][3];

        for (int i = 0; i < n; i++) {
            maxMemo[1][0] = map[i][0] + Math.max(maxMemo[0][0], maxMemo[0][1]);
            maxMemo[1][1] = map[i][1] + Math.max(maxMemo[0][0], Math.max(maxMemo[0][1], maxMemo[0][2]));
            maxMemo[1][2] = map[i][2] + Math.max(maxMemo[0][1], maxMemo[0][2]);

            minMemo[1][0] = map[i][0] + Math.min(minMemo[0][0], minMemo[0][1]);
            minMemo[1][1] = map[i][1] + Math.min(minMemo[0][0], Math.min(minMemo[0][1], minMemo[0][2]));
            minMemo[1][2] = map[i][2] + Math.min(minMemo[0][1], minMemo[0][2]);

            for (int j = 0; j < 3; j++) {
                maxMemo[0][j] = maxMemo[1][j];
                minMemo[0][j] = minMemo[1][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(Math.max(maxMemo[1][0], Math.max(maxMemo[1][1], maxMemo[1][2])));
        sb.append(" ");
        sb.append(Math.min(minMemo[1][0], Math.min(minMemo[1][1], minMemo[1][2])));
        System.out.println(sb);
    }
}