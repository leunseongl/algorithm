import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Long[] money = new Long[N];
		for(int i = 0; i<N; i++) {
			money[i] = Long.parseLong(st.nextToken());
		}
		//입력 완료
		
		long sum = 0, big = 0;
		for(int i = 0; i<M; i++) {
			sum += money[i];
		}
		
		big = sum;
		
		for(int i = M; i<N; i++) {
			sum -= money[i-M];
			sum += money[i];
			big = Math.max(big, sum);
		}
		
		System.out.println(big);
		
	}
}