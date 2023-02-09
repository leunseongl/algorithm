import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	static int N;
	
    public static int[] solution(int[] progresses, int[] speeds) {
    	List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        N = progresses.length;
        for(int i = 0; i<N; i++) {
        	if((100-progresses[i]) % speeds[i] == 0) 
        		q.offer((100-progresses[i]) / speeds[i]);
        	else q.offer((100-progresses[i]) / speeds[i]+1);
        }
        
        //System.out.println(q);
        
        int cnt = 1;
    	int pick = q.poll();
        while(!q.isEmpty()) {
        	if(pick >= q.peek()) {
        		cnt++;
        		q.poll();
        	}
        	else {
        		result.add(cnt);
        		cnt = 1;
        		pick = q.poll();
        	}

        }
        
        result.add(cnt);
        
        int[] answer = new int[result.size()];
        for(int i = 0; i<result.size(); i++) {
        	answer[i] = result.get(i);
        }
        
        return answer;
    }

}
