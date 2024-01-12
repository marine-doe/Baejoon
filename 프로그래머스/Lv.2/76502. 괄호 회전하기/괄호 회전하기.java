import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            queue.offer(queue.poll());
            if (isCorrect(queue)) {
                answer++;
            }
        }

        return answer;
    }
    
    private static boolean isCorrect(Queue<Character> queue) {
        Stack<Character> stack = new Stack<>();

        for (char c : queue) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}