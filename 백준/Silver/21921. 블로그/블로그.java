import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//입력 완료
		
		int sum = 0, big = 0, cnt = 1;
		
		//첫 부분
		for(int i = 0; i<X; i++) {
			sum += arr[i];
		}
		big = sum;
		
		//이후 부분
		for(int i = X; i<N; i++) {
			sum -= arr[i-X];
			sum += arr[i];
			
			if(sum>big) {
				cnt = 1;
				big = sum;
			}
			else if(sum == big) {
				cnt++;
			}
		}
		
		if(big == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(big);
			System.out.println(cnt);
		}
		
	}

}