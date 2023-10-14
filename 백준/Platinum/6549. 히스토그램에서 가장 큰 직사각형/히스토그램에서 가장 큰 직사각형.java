import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while(true){
            int n = sc.nextInt();

            if (n == 0) break;

            long[] histogram = new long[n];

            for (int i = 0; i < n; i++) histogram[i] = sc.nextLong();

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