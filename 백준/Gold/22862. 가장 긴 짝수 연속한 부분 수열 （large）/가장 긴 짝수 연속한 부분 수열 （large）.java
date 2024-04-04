import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 완료

		int answer = 0;
		int left = 0, right = 0;
		int odd = 0, even = 0;
		
		//맨 앞꺼 홀수 체크
		if(arr[0]%2==1) odd++;
		else even++;
		
		while(right<N) {
			//System.out.println("left " + left+" right  "+ right);
			answer = Math.max(answer, even);
			
			if(odd<=K) {
				right++;
				if(right == N) {
					answer = Math.max(answer, even);
					break;
				}
				
				if(arr[right]%2==1) {
					odd++;
				}
				else {
					even++;
				}
				
			}
			
			else {
				if(arr[left]%2==1) { //홀수면
					odd--;
				}
				else {
					even--;
				}
				left++;
			}
			
			//System.out.println("홀 " + odd + " 짝 " + even);
			
		}
		
		System.out.println(answer);
		 
	}

}