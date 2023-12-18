import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        int max = stack.pop();

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (cur >= max) {
                int diff = cur - max + 1;
                result += diff;
                cur -= diff;
            }

            max = cur;
        }

        System.out.println(result);
    }
}