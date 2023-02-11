public class Solution {

	 public static int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];
	        int carpet = brown + yellow;
	        
	        for(int w = carpet; w>0; w--) {
	        	if(carpet%w != 0) continue;
	        	
	        	int h = carpet/w;
	        	int y = (w-2) * (h-2);
	        	int b = carpet-y;
	        	
	        	if(y == yellow && b == brown) {
	        		answer[0] = w;
	        		answer[1] = h;
	        		break;
	        	}
	        }
	        
	        return answer;
	 }
	
// 	public static void main(String[] args) {

		
// 		int n = 12;
// 		solution(10,2);
		
// 	}

}
