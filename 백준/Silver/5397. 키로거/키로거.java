import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            int len = line.length;

            StringBuilder sb = new StringBuilder();

            Stack<Character> cur = new Stack<>();
            Stack<Character> temp = new Stack<>();

            for (int j = 0; j < len; j++) {
                if (line[j] == '<') {
                    if (!cur.isEmpty()) {
                        temp.push(cur.pop());
                    }
                } else if (line[j] == '>') {
                    if (!temp.isEmpty()) {
                        cur.push(temp.pop());
                    }
                } else if (line[j] == '-') {
                    if (!cur.isEmpty()) {
                        cur.pop();
                    }
                } else {
                    cur.push(line[j]);
                }
            }

            for (Character c : cur) {
                sb.append(c);
            }

            while (!temp.isEmpty()) {
                sb.append(temp.pop());
            }

            System.out.println(sb);
        }
    }
}