import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 최댓값을 찾는다
 * 최댓값이 자기 자신이면 이동하지 않는다
 */
public class Main {

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      
      int[] arr = new int[N];
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i<N; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
      }
      //입력 완료
      
      int changeCnt = 0, big = 0;
      List<Integer> answer = new ArrayList<>();
      A: for(int i = N-1; i>0; i--) {
    	  big = i;
    	  
    	  for(int j = 0; j<i; j++) {
    		  if(arr[big] < arr[j]) {
    			  big = j;
    		  }
    	  }
    	  
    	  if(i != big) {
    		  changeCnt++;
    		  if(changeCnt == K) {
    			  answer.add(arr[i]);
    			  answer.add(arr[big]);
    			  break A;
    		  }
    		  
    		  int tmp = arr[i];
    		  arr[i] = arr[big];
    		  arr[big] = tmp;
    		  
    	  }
    	  
      }
      
      if(changeCnt>=K) {
    	  StringBuilder sb = new StringBuilder();
    	  for(int a: answer) {
    		  sb.append(a + " ");
    	  }
    	  System.out.println(sb);
      }
      else System.out.println(-1);
      
   }

}