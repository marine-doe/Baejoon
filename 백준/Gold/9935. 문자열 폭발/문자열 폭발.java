import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        int len1 = line1.length();

        String line2 = br.readLine();
        int len2 = line2.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len1; i++) {
            stack.push(line1.charAt(i));

            if (stack.size() >= len2){
                boolean isSame = true;

                for (int j = 0; j < len2; j++) {
                    if (stack.get(stack.size() - len2 + j) != line2.charAt(j)){
                        isSame = false;
                        break;
                    }
                }

                if (isSame){
                    for (int j = 0; j < len2; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character c : stack) {
            result.append(c);
        }

        System.out.println(result.length() == 0 ? "FRULA" : result);
    }
}