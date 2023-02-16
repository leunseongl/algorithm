import java.util.PriorityQueue;

public class Solution {

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i<scoville.length; i++) {
        	pq.offer(scoville[i]);
        }
        
        while(pq.peek()<K) {
        	if(pq.size() == 1) {
        		return -1;
        	}

        	int a = pq.poll();
        	int b = pq.poll();
         	
        	pq.offer(a + (b*2));
        	answer++;
        }
        
        return answer;
    }
	
 	public static void main(String[] args) {

 		int[] scoville = {1,2,3,9,10,12};
 		//int[] scoville = {1,2,1,1,1};
 		int K = 7;
		
 		System.out.println(solution(scoville, K));
 	}
	
}
