import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //횡단보도 개수
		int K = Integer.parseInt(st.nextToken()); //K만큼 연속한 신호등 존재 필요
		int B = Integer.parseInt(st.nextToken()); //고장난 신호등 개수
		
		boolean[] broke = new boolean[N+1];
		for(int i = 0; i<B; i++) {
			broke[Integer.parseInt(br.readLine())] = true;
		}
		//입력 완료
		
		int cnt = 0;
		int small = Integer.MAX_VALUE;
		for(int i = 1; i<=K; i++) {
			if(broke[i]) cnt++;
		}
		
		small = cnt;
		
		for(int i = K+1; i<=N; i++) {
			if(broke[i-K]) cnt--;
			if(broke[i]) cnt++;
			
			small = Math.min(cnt, small);
		}
		
		System.out.println(small);
		
	}

}