import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adj;
    static int[] p;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        p = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            p[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 0; i < adj[1].size(); i++) {
            FindChild(1, adj[1].get(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < n + 1; i++) {
            sb.append(p[i] + "\n");
        }
        System.out.println(sb);
    }

    private static void FindChild(int a, int b) {
        if (p[b] == b && b != 1) {
            p[b] = a;
            for (int i = 0; i < adj[b].size(); i++) {
                FindChild(b, adj[b].get(i));
            }
        } else {
            return;
        }
    }
}