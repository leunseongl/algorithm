import java.util.Stack;

public class Solution {
    
	static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i<s.length(); i++) {
        	char tmp = s.charAt(i);
        	if(tmp == '(') 
        		stack.push(tmp);
        	else {
        		if(stack.isEmpty()) return false;
        		stack.pop();
        	}
        }
        
        if(!stack.isEmpty()) return false;
        
        return answer;
    }
	
// 	public static void main(String[] args) {

// 		String s = ")()(";
// 		System.out.println(solution(s));
		
// 	}

}
