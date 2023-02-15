import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i<clothes.length; i++) {
        	if(map.containsKey(clothes[i][1])) {
        		map.put(clothes[i][1], map.get(clothes[i][1])+1);
        	}
        	else map.put(clothes[i][1], 1);
        }
        
        for(int a : map.values()) {
        	answer *= a+1;
        }
        answer--; //아무것도 안입는 경우 빼주기
        return answer;
    }

// 	public static void main(String[] args) {
		
// 		String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},
// 				{"green_turban", "headgear"}};
		
// 		solution(clothes);
// 	}

	
}
