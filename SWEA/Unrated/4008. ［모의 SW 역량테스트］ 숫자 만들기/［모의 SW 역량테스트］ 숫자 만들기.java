import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] numbers;
	static int N;
	static int max;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int plus = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			int multiple = Integer.parseInt(st.nextToken());
			int divide = Integer.parseInt(st.nextToken());
			
			numbers = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			dfs(1, numbers[0], plus, minus, multiple, divide);
			System.out.printf("#%d %d%n", tc, max-min);
		}
		
		
	}
	
	private static void dfs(int cnt, int sum, int plus, int minus, int multiple, int divide) {
		
		if(cnt == N) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		
		if(plus > 0) {
			dfs(cnt+1, sum+numbers[cnt], plus-1, minus, multiple, divide);
		}
		
		if(minus > 0) {
			dfs(cnt+1, sum-numbers[cnt], plus, minus-1, multiple, divide);
		}
		
		if(multiple > 0) {
			dfs(cnt+1, sum*numbers[cnt], plus, minus, multiple-1, divide);
		}
		
		if(divide > 0) {
			dfs(cnt+1, sum/numbers[cnt], plus, minus, multiple, divide-1);
		}
	}

}