import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.prefs.NodeChangeEvent;

public class Main {
    static class Node{
        int v, idx;

        public Node(int v, int idx){
            this.v = v;
            this.idx = idx;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Node> dq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            while(!dq.isEmpty() && dq.getLast().v > v){
                dq.removeLast();
            }
            dq.addLast(new Node(v, i));
            if (dq.getFirst().idx <= i - l){
                dq.removeFirst();
            }
            sb.append(dq.getFirst().v + " ");
        }

        System.out.println(sb);
    }
}