import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int RANGE = 10_000;

    public static void main(String[] args) throws Exception {
        boolean[] prime = new boolean[RANGE]; // false는 소수인기라

        for (int i = 2; i < RANGE; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < RANGE; j += i) {
                    prime[j] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        here:
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{start, 0});

            boolean[] visited = new boolean[RANGE];
            visited[start] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (cur[0] == goal) {
                    sb.append(cur[1]).append("\n");
                    continue here;
                }

                for (int i = 0; i < 4; i++) {
                    char[] num = String.valueOf(cur[0]).toCharArray();
                    for (int j = 0; j < 10; j++) {
                        num[i] = (char) (j + '0');

                        int number = Integer.parseInt(new String(num));

                        if (!visited[number] && !prime[number] && number > 1000) {
                            visited[number] = true;
                            queue.offer(new int[]{number, cur[1] + 1});
                        }
                    }
                }
            }

            sb.append("Impossible\n");
        }

        System.out.print(sb);
    }
}