import java.util.*;

/*
코스는 최소 2가지 이상의 단품 메뉴, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합만 후보
course 배열에 담긴 숫자만큼 돌려봐야 할듯?
반복문 돌리면서 map에 체크하면 되지 않을까 => 이렇게 하면 같이 주문된 것을 알 수 없음
course 배열에 담긴 숫자를 cnt로 조합을 돌려서 map으로 카운트.. 
orders의 String들이 정렬되어 있지 않음 주의, 따라서 원하는 대로 조합의 결과가 나오지 않을 수 있음, 예시 3번처럼
*/

class Solution {
    static Character[] picked;
    static Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        
        for(int i = 0; i<course.length; i++) {
            map = new HashMap<>();
            
            for(int j = 0; j<orders.length; j++) {
                picked = new Character[course[i]];
                char[] ch = orders[j].toCharArray();
                Arrays.sort(ch);
                String st = new String(ch);

                combination(0,0,course[i],orders[j].length(), st);
            }
            
            //System.out.println(map);
            
            int big = 0;
            for(String s: map.keySet()) {
                if(map.get(s) > big) {
                    big = map.get(s);
                }
            }
            
            if(big > 1) {
                for(String s: map.keySet()) {
                    if(map.get(s) == big) {
                        answerList.add(s);
                    }
                }
            }
        }
        
        //System.out.println(answerList);
        Collections.sort(answerList);
        //System.out.println(answerList);
        
        String[] answer = new String[answerList.size()];
        for(int i = 0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    //조합
    private static void combination(int cnt,int start,int res,int len,String st) {
        if(cnt == res) {
            //System.out.println(Arrays.toString(picked));
            String line = "";
            for(int i = 0; i<picked.length; i++) {
                line += picked[i];
            }
            
            //count 계산
            if(map.containsKey(line)) {
                map.put(line, map.get(line)+1);
            }
            else {
                map.put(line, 1);
            }
            return;
        }
        
        for(int i = start; i<len; i++) {
            picked[cnt] = st.charAt(i);
            combination(cnt+1, i+1, res, len, st);
        }
    }
}