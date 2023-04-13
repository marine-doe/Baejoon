class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;
        
        outer: for(int i = 3; i <= 2502; i++){
            for(int j = i; j <= 5002; j++){
                if(i * j > area){
                    continue outer;
                }else if((2 * i + 2 * j - 4) == brown && (i - 2) * (j - 2) == yellow){
                    answer[0] = j;
                    answer[1] = i;
                    break outer;
                }
            }
        }
        
        return answer;
    }
}