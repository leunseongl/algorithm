import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//중요도가 높은 문서를 먼저 인쇄
//location은 0부터
public class Solution {

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        
        //큐에다가 값 담기
        for(int i = 0; i<priorities.length; i++) {
        	int[] list = {i, priorities[i]};
        	q.offer(list);
        }
        
        while(!q.isEmpty()) {
        	boolean flag = true;
        	int[] tmp = q.poll();
        	System.out.println(Arrays.toString(tmp));
        	for(int[] a : q) {
        		if(tmp[1] < a[1]) {
        			flag = false;
        			break;
        		}
        	}
        	
        	if(flag == false) q.add(tmp);
        	else {
        		answer++;
        		if(tmp[0] == location) {
        			break;
        		}
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
	
	public static void main(String[] args) {

		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		
		solution(priorities, location);
	}

}
