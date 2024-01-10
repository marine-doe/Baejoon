import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int start = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            if (start > i) {
                break;
            }
            
            if (people[i] + people[start] <= limit) {
                start++;
            }
            
            answer++;
        }
        
        return answer;
    }
}