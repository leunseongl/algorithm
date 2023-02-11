import java.util.Stack;

public class Solution {

    static String solution(String number, int k) {
        String answer = "";
        
        Stack<Integer> stack = new Stack<>();
        stack.push(number.charAt(0)-'0');
        
        for(int i = 1; i<number.length(); i++) {
        	int tmp = number.charAt(i)-'0';
        	while((!stack.isEmpty()) && (stack.peek() < tmp) && k>0) {
        		stack.pop();
        		k--;
        	}
        	stack.push(tmp);
        }
        
        if(k>0) {
        	while(k>0)
        		k--;
        		stack.pop();
        }
        
        for(int s: stack) {
        	answer += s;
        }

        return answer;
    }
	

}
