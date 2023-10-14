import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            long[] histogram = new long[n];

            for (int i = 0; i < n; i++) histogram[i] = Long.parseLong(st.nextToken());

            Stack<Integer> stack = new Stack<>();

            long max = 0;

            for (int i = 0; i < n; i++) {
                while(!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                    long h = histogram[stack.pop()];
                    long w;

                    if (stack.isEmpty()) w = i;
                    else w = i - 1 - stack.peek();

                    max = Math.max(max, h * w);
                }

                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long h = histogram[stack.pop()];
                long w;

                if (stack.isEmpty()) w = n;
                else w = n - 1 - stack.peek();

                max = Math.max(max, h * w);
            }

            System.out.println(max);
        }
    }
}