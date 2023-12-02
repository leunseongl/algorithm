import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<tangerine.length; i++) {
            if(map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i])+1);
            }
            else {
                map.put(tangerine[i], 1);
            }
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1,o2) -> (map.get(o2).compareTo(map.get(o1))));
        
        int answer = 0;
        int sum = 0;
        for(int i: keys) {
            //System.out.println(i + " " + map.get(i));
            sum += map.get(i);
            answer++;
            if(sum >= k) break;
        }
        
        return answer;
    }
}