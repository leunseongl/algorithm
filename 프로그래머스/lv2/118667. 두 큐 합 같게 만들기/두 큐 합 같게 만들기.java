import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
    	Queue<Integer> q2 = new ArrayDeque<>();
    	long sum1 = 0; 
    	long sum2 = 0;
    	
    	for(int i = 0; i<queue1.length; i++) {
    		q1.offer(queue1[i]);
    		q2.offer(queue2[i]);
    		sum1 += queue1[i];
    		sum2 += queue2[i];
    	}
        
    	if((sum1+sum2)%2 == 1) return -1; //전체 숫자의 합이 홀수면 -1 출력 후 return
    	
    	 int tmp = 0; //반복문 종료 조건 용
    	 int answer = 0;
    	 while(tmp<=300000) {
    		if(sum1>sum2) { //첫 번째 큐의 합이 더 큰 경우
    			sum1 -= q1.peek();
    			sum2 += q1.peek();
    			q2.offer(q1.poll());
    		}
    		else if(sum1<sum2) { //두 번째 큐의 합이 더 큰 경우
    			sum1 += q2.peek();
    			sum2 -= q2.peek();
    			q1.offer(q2.poll());
    		}
    		else if(sum1==sum2) break;
    		tmp++;
    		answer++;
    	 }
    	
    	 System.out.println(answer);
    	 if(tmp>300000) return -1;
    	 else return answer;
    }
	
// 	public static void main(String[] args) {

// 		int[] queue1 = {1,1};
// 		int[] queue2 = {1,5};
		
// 		solution(queue1, queue2);
		
// 	}

}
