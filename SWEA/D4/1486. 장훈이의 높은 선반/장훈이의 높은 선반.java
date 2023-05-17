import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N,B,answer;
	static int[] tall;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			tall = new int[N];
			for(int i = 0; i<N; i++) {
				tall[i] = Integer.parseInt(st.nextToken());
			}
			//입력 완료
			
			answer = Integer.MAX_VALUE;
			subset(0,0);
			System.out.printf("#%d %d%n", tc, answer-B);
			
		}
		
	}
	
	private static void subset(int cnt, int sum) {
		
		//기저조건, 부분집합 완성
		if(cnt == N) {
			if(sum>=B) {
				answer = Math.min(answer, sum);
			}
			return;
		}
		
		subset(cnt+1, sum+tall[cnt]);
		subset(cnt+1, sum);
		
	}
}