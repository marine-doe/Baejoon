import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static Set<Integer> treeSet = new TreeSet<>();
    static long result = 1L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            treeSet.add(i);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        long m = Long.parseLong(st.nextToken());

//        k의 값은 (n - 1)!의 합일 것이다.
        if (m == 1) {
            long k = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                long seq = 1L;

                for (int j = 2; j < n - i; j++) {
                    seq *= j;
                }

                int num = 0;

                for (int t : treeSet) {
                    num = t;
                    if (k > seq) {
                        k -= seq;
                    } else {
                        break;
                    }
                }

                treeSet.remove(num);

                sb.append(num + " ");
            }

            System.out.println(sb);
        }
//        nums[i] 값이 min 값이 아니라면 (n - 1)! * (nums[i] - min)의 과정을 겪었을 것이다.
        else {
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                for (int t : treeSet) {
                    if (nums[i] == t) {
                        treeSet.remove(t);
                        break;
                    } else {
                        long seq = 1L;

                        for (int j = 2; j < n - i; j++) {
                            seq *= j;
                        }

                        result += seq;
                    }
                }
            }

            System.out.println(result);
        }
    }
}