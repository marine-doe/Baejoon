import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> isChar;
    static boolean[] vst;
    static int n, result;
    static String[] lines;
    static int[] charNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        lines = new String[n];
        charNum = new int[26];
        Arrays.fill(charNum, -1);

        for (int i = 0; i < n; i++) {
            lines[i] = br.readLine();

            for (int j = 0; j < lines[i].length(); j++) {
                char c = lines[i].charAt(j);
                charNum[c - 'A'] = 0;
            }
        }

        isChar = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (charNum[i] >= 0) isChar.add(i);
        }

        vst = new boolean[10];
        perm(0);

        System.out.println(result);
    }

    private static void perm(int depth) {
        if (depth == isChar.size()) {
            calc();
            return;
        }

        for (int i = 9; i >= 0; i--) {
            if (!vst[i]) {
                charNum[isChar.get(depth)] = i;

                vst[i] = true;
                perm(depth + 1);
                vst[i] = false;
            }
        }
    }

    private static void calc() {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < lines[i].length(); j++) {
                char c = lines[i].charAt(j);

                sb.append(charNum[c - 'A']);
            }
            sum += Integer.parseInt(sb.toString());
        }

        result = Math.max(sum, result);
    }
}