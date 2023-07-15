import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> trees = new HashMap<>();

        int count = 0;
        String str = br.readLine();
        while (true) {
            trees.put(str, trees.getOrDefault(str, 0) + 1);
            count++;

            str = br.readLine();
            if (str == null || str.length() == 0) {
                break;
            }
        }

        Object[] keys = trees.keySet().toArray();
        Arrays.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (Object key :
                keys) {
            String s = (String) key;
            double per = (double)(trees.get(s) * 100.0) / count;

            sb.append(s + " " + String.format("%.4f", per) + "\n");
        }

        System.out.println(sb);
    }
}