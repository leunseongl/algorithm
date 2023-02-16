class Solution {
	
	static int answer;
    public static int solution(int[] numbers, int target) {
        answer = 0;
        DFS(numbers, target, 0, 0);
        return answer;
    }
    
    private static void DFS(int[] numbers, int target, int idx, int total) {
    	
    	if(idx == numbers.length) {
    		if(total == target) answer++;
    		return;
    	}
    	
    	DFS(numbers, target, idx+1, total+numbers[idx]);
    	DFS(numbers, target, idx+1, total-numbers[idx]);

    }
    
	// public static void main(String[] args) {
	// 	//int[] numbers = {1,1,1,1,1};
	// int[] numbers = {4,1,2,1};
	// 	int target = 4;
	// solution(numbers, target);
	// }
    
}