import java.util.*;

class Solution {
    public List<Integer> solution(String s) {

        List<Integer> answer = new ArrayList<>();
        
        s = s.substring(2, s.length()-2); //맨 앞의 {{, }} 제거
        s = s.replace("},{", "-");
        String[] tmp = s.split("-");

        Arrays.sort(tmp, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        for(String t: tmp) {
            String[] arr = t.split(",");
            
            for(int i = 0; i<arr.length; i++) {
                if(!answer.contains(Integer.parseInt(arr[i]))) {
                    answer.add(Integer.parseInt(arr[i]));
                }
            }
        }
        
        return answer;
    }
}