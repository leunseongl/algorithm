class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        for(int i = 0; i<deliveries.length/2; i++) {
        	int tmp = deliveries[i];
        	deliveries[i] = deliveries[deliveries.length-i-1];
        	deliveries[deliveries.length-i-1] = tmp;
        }
        
        for(int i = 0; i<pickups.length/2; i++) {
        	int tmp = pickups[i];
        	pickups[i] = pickups[pickups.length-i-1];
        	pickups[pickups.length-i-1] = tmp;
        }
        
        int go_deli = 0;
        int go_pick = 0;
        for(int i = 0; i<n; i++) {
        	go_deli += deliveries[i];
        	go_pick += pickups[i];
        	
        	while(go_deli>0 || go_pick>0) {
        		go_deli -= cap;
        		go_pick -= cap;
        		answer += (n-i) * 2;
        	}
        }
        
        
        return answer;
    }
}