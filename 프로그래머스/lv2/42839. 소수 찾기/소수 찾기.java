import java.util.HashSet;
import java.util.Set;

class Solution {

	static Set<Integer> set = new HashSet<>();
	static boolean[] visit;
	static int N;
	
	public static int solution(String numbers) {
        int answer = 0;
        N = numbers.length();
        visit = new boolean[N];
        for(int i = 0; i<N; i++) {
        	permutation(numbers, "", i+1);
        }
        
        for(int s : set) {
        	boolean flag = true;
        	if(s < 2) continue;
        	
        	for(int i = 2; i*i<=s; i++) {
        		if(s%i == 0) flag = false;
        		else continue;
        	} 
        	
        	if(flag == true) answer++;
        	
        }
        
        return answer;
        
	}
	
	
	public static void permutation(String input, String tmp, int R) {
		
		if(tmp.length() == R) {
			set.add(Integer.parseInt(tmp));
		}
		
		
		for(int i = 0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				tmp += input.charAt(i);
				permutation(input, tmp, R);
				visit[i] = false;
				tmp = tmp.substring(0, tmp.length()-1);
			}
		}
		
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(solution("23"));
//	}
	
}
