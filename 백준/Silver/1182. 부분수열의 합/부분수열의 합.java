import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, S;
	static int[] array;
	static int count = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		powerSet(0, 0);
		System.out.println(S == 0? count-1:count);
	
		
	}
	
	private static void powerSet(int cnt, int sum) {
	
		if(cnt == N) {
			if(sum == S) {
				count++;
			}
			return;
		}
		
		powerSet(cnt+1, sum+array[cnt]);
		powerSet(cnt+1, sum);
		
	}

}