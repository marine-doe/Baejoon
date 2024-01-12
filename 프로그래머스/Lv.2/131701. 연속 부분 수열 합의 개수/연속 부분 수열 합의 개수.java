import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int l = elements.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= l; i++) {
            for (int j = 0; j < l; j++) {
                int sum = 0;

                for (int k = j; k < j + i; k++) {
                    sum += elements[k % l];
                }

                set.add(sum);
            }
        }

        return set.size();
    }
}