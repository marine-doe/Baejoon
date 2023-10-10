import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] p;
    static int city, n;
    static boolean isPossible = true;
    static final String YES = "YES";
    static final String NO = "NO";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        city = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        p = new int[city + 1];
        for (int i = 1; i <= city; i++) {
            p[i] = i;
        }

        for (int i = 1; i <= city; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= city; j++) {
                int m = Integer.parseInt(st.nextToken());
                if (m == 1) union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] plan = new int[n];

        for (int i = 0; i < n; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
            if (i > 0) isUnion(plan[i - 1], plan[i]);
        }

        System.out.println(isPossible ? YES : NO);
    }

    private static void isUnion(int x, int y) {
        if (findSet(x) != findSet(y)) isPossible = false;
    }

    private static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (px > py) {
            p[y] = px;
            p[x] = px;
        } else {
            p[x] = py;
            p[y] = py;
        }
    }

    private static int findSet(int x) {
        if (p[x] == x) return x;
        return p[x] = findSet(p[x]);
    }
}