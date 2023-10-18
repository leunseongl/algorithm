import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, pl, mi, mul, div, big, small;
	static int[] numbers;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		pl = Integer.parseInt(st.nextToken());
		mi = Integer.parseInt(st.nextToken());
		mul = Integer.parseInt(st.nextToken());
		div = Integer.parseInt(st.nextToken());
		//입력 완료
		
		small = Integer.MAX_VALUE;
		big = Integer.MIN_VALUE;
		dfs(1, numbers[0], pl, mi, mul, div);
		
		System.out.println(big);
		System.out.println(small);
		
	}

	private static void dfs(int cnt, int res, int plus, int minus, int multiple, int divide) {
		
		if(cnt == N) {
			small = Math.min(small, res);
			big = Math.max(big, res);
			return;
		}
		
		if(plus>0) {
			dfs(cnt+1, res+numbers[cnt], plus-1, minus, multiple, divide);
		}
		
		if(minus>0) {
			dfs(cnt+1, res-numbers[cnt], plus, minus-1, multiple, divide);
		}
		
		if(multiple>0) {
			dfs(cnt+1, res*numbers[cnt], plus, minus, multiple-1, divide);
		}
		
		if(divide>0) {
			dfs(cnt+1, res/numbers[cnt], plus, minus, multiple, divide-1);
		}
	}
	
}
