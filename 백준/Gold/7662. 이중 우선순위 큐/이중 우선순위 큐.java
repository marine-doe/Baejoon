import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < tc; test_case++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Long, Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                String operation = st.nextToken();
                long value = Long.parseLong(st.nextToken());

                if (operation.equals("I")) {
                    if (treeMap.containsKey(value)) {
                        treeMap.put(value, treeMap.get(value) + 1);
                    } else {
                        treeMap.put(value, 1);
                    }
                } else if (!treeMap.isEmpty()) {
                    if (value == -1) {
                        long key = treeMap.firstKey();
                        if (treeMap.get(key) == 1) {
                            treeMap.remove(key);
                        }else{
                            treeMap.put(key, treeMap.get(key) - 1);
                        }
                    } else {
                        long key = treeMap.lastKey();
                        if (treeMap.get(key) == 1) {
                            treeMap.remove(key);
                        }else{
                            treeMap.put(key, treeMap.get(key) - 1);
                        }
                    }
                }
            }

            if (!treeMap.isEmpty()) {
                bw.append(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
            } else {
                bw.append("EMPTY\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}