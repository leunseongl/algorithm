import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(people);
        for(int i = 0; i<people.length; i++) {
        	list.add(people[i]);
        }
        
        while(list.size() > 1) {
        	if(list.get(0) + list.get(list.size()-1) <= limit) {
        		answer++;
        		list.remove(0);
        		list.remove(list.size()-1);
        	}
        	else {
        		answer++;
        		list.remove(list.size()-1);
        	}
        }
        
        if(list.size() == 1) answer++;
        
        return answer;
    }
	
// 	public static void main(String[] args) {

// 		int[] people = {70,50,80};
// 		int limit = 100;
// 		System.out.println(solution(people, limit));
		
// 	}
	
}
