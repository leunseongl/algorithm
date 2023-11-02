import java.util.*;

/**
DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램
캐시 사이즈가 정해져 있고 LRU기 때문에 앞뒤로 계속 붙여야 할 거 같은데, 이럴 경우 링크드 리스트를 쓰나?
**/
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedList<String> list = new LinkedList<>();
        for(int i=0; i<cities.length; i++) {
            String now = cities[i].toUpperCase();
            //System.out.println(now);
            
            if(list.contains(now)) { //이미 존재하면
                answer += 1;
                list.remove(list.indexOf(now));
                list.add(now);
                //System.out.println(list);
            }
            
            else if(!list.contains(now)) { //존재하지 않으면
                answer += 5;
                
                if(list.size() >= cacheSize && !list.isEmpty()) { //캐시 크기가 다 찼으면
                    list.removeFirst();
                    list.add(now);
                    //System.out.println(list);
                }
                
                else if(list.size() < cacheSize) { //캐시 크기가 다 안찼으면
                    list.add(now);
                    //System.out.println(list);
                }
            }
        }
        return answer;
    }
}