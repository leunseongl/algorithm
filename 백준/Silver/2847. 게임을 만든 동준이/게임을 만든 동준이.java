import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		for(int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		//입력 완료
		
		int answer = 0;
		int now = numbers[N-1];
		for(int i = N-2; i>=0; i--) {
			if(now>numbers[i]) now = numbers[i];
			else {
				answer += numbers[i]-now+1;
				now--;
			}
		}
		
		System.out.println(answer);

	}

}