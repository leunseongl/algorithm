import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//입력 완료
		
		int[] answerArr = new int[2];
		int answer = Integer.MAX_VALUE;
		int left = 0, right = N-1;
		//0인 경우에는 멈추고 걔 출력
		//양수인 경우 -> 양수가 더 크다 양수- 필요, right--
		//음수인 경우 -> 음수가 더 크다  left++
		
		while(left<right) {
			//System.out.println("left " + left + " right " + right);
			
			int tmp = arr[left]+arr[right];
			if(Math.abs(tmp)<answer) {
				answer = Math.abs(tmp);
				answerArr[0] = arr[left];
				answerArr[1] = arr[right];
			}
			
			if(tmp>0) {
				right--;
			}
			else if(tmp == 0) {
				break;
			}
			else {
				left++;
			}
		}
		
		for(int i = 0; i<2; i++) {
			System.out.print(answerArr[i] + " ");
		}
		
		
	}

}