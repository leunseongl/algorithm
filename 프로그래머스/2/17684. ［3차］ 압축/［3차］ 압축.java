import java.util.*;

class Solution {
	public static int[] solution(String msg) {

        Map<String, Integer> dict = new HashMap<>();
        for(char i = 'A'; i<='Z'; i++) {
            dict.put(String.valueOf(i), i-64);
        }
        //사전 초기화
        
        int num = 27; //사전 추가 번호
        List<Integer> answerList = new ArrayList<>();
        int idx = 0;
        while(idx < msg.length()) { 
        	String str = "";
            while(idx < msg.length()) {
            	if(!dict.containsKey(str + msg.charAt(idx))) break;
            	else str += msg.charAt(idx);
            	idx++;
            }
            answerList.add(dict.get(str));
            
            if(idx < msg.length()) {
            	dict.put(str+msg.charAt(idx), num);
                num++;
            }
        }
        
        //System.out.println(dict);
        //System.out.println(answerList);
  
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}