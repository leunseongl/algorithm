import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i<discount.length-10+1; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            
            for(int j = 0; j<10; j++) {
                if(discountMap.containsKey(discount[i+j])) {
                    discountMap.put(discount[i+j], discountMap.get(discount[i+j])+1);
                }
                else {
                    discountMap.put(discount[i+j], 1);
                }
            }
            
            boolean check = true;
            for(String s : wantMap.keySet()) {
                if(wantMap.get(s) != discountMap.get(s)) {
                    check = false;
                    break;
                }
            }
            
            if(check) answer += 1;
        }
    
        return answer;
    }
}