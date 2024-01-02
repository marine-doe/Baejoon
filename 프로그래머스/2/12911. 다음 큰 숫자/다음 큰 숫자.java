class Solution {
    public int solution(int n) {
        int answer = n + 1;

        while (Integer.bitCount(answer) != Integer.bitCount(n)) {
            answer++;
        }

        return answer;
    }
}