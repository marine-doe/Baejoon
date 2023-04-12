import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int sum = truck_weights[0];
        int idx = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{truck_weights[0], 1});
        
        while(!q.isEmpty()){
            time++;
            for(int i = 0; i < q.size(); i++){
                int[] cur = q.poll();
                cur[1]++;
                q.offer(cur);
            }
            if(q.peek()[1] == bridge_length + 1){
                int[] cur = q.poll();
                sum -= cur[0];
            }
            if(idx < truck_weights.length && sum + truck_weights[idx] <= weight){
                sum += truck_weights[idx];
                q.offer(new int[]{truck_weights[idx++], 1});
            }
        }
        
        return time;
    }
}