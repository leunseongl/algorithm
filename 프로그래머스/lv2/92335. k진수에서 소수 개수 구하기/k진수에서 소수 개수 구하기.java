import java.util.Arrays;

public class Solution {

    public static int solution(int n, int k) {
    	
    	int answer = 0;
    	String num = Integer.toString(n, k); //n을 k진법의 문자열로 변환
        String[] arr = num.split("0"); //0으로 분리해서 배열에 담기
//        System.out.println(Arrays.toString(arr));

        for(String s: arr) {
        	if(s.equals("")) continue;
        	if(isPrime(Long.parseLong(s))) answer++;;
        }
        System.out.println(answer);
        return answer;
    }
    
    //소수 세기
    static boolean isPrime(long num) {
    	
    	if(num == 1) return false;
    	if(num == 2) return true;
    	
    	for(int i = 2; i<=(int)Math.sqrt(num); i++) {
    		if(num%i == 0) return false;
    	}
    	return true;
    }
    
// 	public static void main(String[] args) {

// 		int n = 110011;
// 		int k = 10;
// 		solution(n, k);	
		
// 	}

}
