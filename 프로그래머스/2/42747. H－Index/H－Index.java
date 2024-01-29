import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        for(int i = 1; i<=citations.length; i++) {
            int small = 0, big = 0;
            for(int j = 0; j<citations.length; j++) {
                if(citations[j]>=i) big++;
            }
            small = citations.length-big;
            
            if(big>=i && small<=i) {
                answer = Math.max(answer, i);
            }
        } 
        return answer;
    }
}