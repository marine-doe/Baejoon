import java.util.*;

class Solution {
    public long solution(int[] arr) {
        long answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            Set<Long> set = new HashSet<>();

            long temp = answer;

            for (int j = 1; j <= arr[i]; j++) {
                set.add(temp * j);
            }

            temp = arr[i];

            for (int j = 1; j <= answer; j++) {
                if (set.contains(temp * j)) {
                    answer = temp * j;
                    break;
                }
            }
        }

        return answer;
    }
}