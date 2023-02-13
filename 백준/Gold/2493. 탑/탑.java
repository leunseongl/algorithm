import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//1. 스택이 비면 넣는다, idx_stack도 같이 넣는다
//2. 스택.peek이 자기보다 작거나 같으면 작은애 pop하고 넣는다
//3. 스택.peek이 자기보다 크면 res배열 처리 후 넣는다 

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> idx_stack = new Stack<>();
		int[] res = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			boolean ifPop = false;
			int tmp = Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) { //스택이 비었을 때
				stack.push(tmp);
				idx_stack.push(i+1);
			}
			
			else if(stack.peek() <= tmp) { //스택.peek이 자기보다 같거나 작으면
				while(!stack.isEmpty() && stack.peek()<tmp) { //스택이 비거나 스택.peek이 자기보다 클때까지 pop
					stack.pop();
					idx_stack.pop();
					ifPop = true;
				}
				//pop한 후에 pop을 한 애들만 res문 따로 처리
				if(ifPop && !stack.isEmpty()) {
					res[i] = idx_stack.peek();
				}
		
				stack.push(tmp);
				idx_stack.push(i+1);	
			}
			
			else { //스택.peek이 자기보다 크면
				res[i] = idx_stack.peek(); //res배열 처리 후
				stack.push(tmp); //stack에 넣기
				idx_stack.push(i+1);
				}
						
			}
		
        for(int i = 0; i<N; i++){
            System.out.print(res[i] + " ");
        }
				
	}

}