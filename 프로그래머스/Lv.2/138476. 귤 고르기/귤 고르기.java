import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        
        Collections.sort(keys, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
        
        for (Integer key : keys) {
            answer++;
            k -= map.get(key);
            if (k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}