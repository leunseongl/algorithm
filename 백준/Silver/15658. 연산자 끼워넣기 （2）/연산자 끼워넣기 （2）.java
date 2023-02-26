import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] numbers;
	static int big = Integer.MIN_VALUE;
	static int small = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int multiple = Integer.parseInt(st.nextToken());
		int division = Integer.parseInt(st.nextToken());
		
		operator(1, numbers[0], plus, minus, multiple, division);
		System.out.println(big);
		System.out.println(small);
	}

	private static void operator(int idx, int sum, int plus, int minus, int multiple, int division) {
		
		if(idx == N) {
			big = Math.max(big, sum);
			small = Math.min(small, sum);
			return;
		}
		
		if(plus>0) {
			operator(idx+1, sum+numbers[idx], plus-1, minus, multiple, division);
		}
		
		if(minus>0) {
			operator(idx+1, sum-numbers[idx], plus, minus-1, multiple, division);
		}
		
		if(multiple>0) {
			operator(idx+1, sum*numbers[idx], plus, minus, multiple-1, division);
		}
		
		if(division>0) {
			operator(idx+1, (int)sum/numbers[idx], plus, minus, multiple, division-1);
		}
	}
	
}
