import java.util.*;

//맨 앞자리가 가장 큰 수가 앞에 와야 한다
//비교하는 두 숫자를 앞, 뒤로 번갈아가며 이어붙인 것을 기준으로 비교한다는 아이디어가 포인트

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i = 0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        //System.out.println(Arrays.toString(arr));
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<arr.length; i++) {
            sb.append(arr[i]);
        }
        
        String answer = String.valueOf(sb);
        if(answer.charAt(0)=='0') answer = "0";
        return answer;
    }
}