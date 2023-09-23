import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[N];
		int[] sum = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		sum[0] = input[0];
		for(int i = 1; i<N; i++) {
			sum[i] = input[i] + sum[i-1];
		}
		//누적합 구하기 완료
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			
			if(start != 0) System.out.println(sum[end]-sum[start-1]);
			else System.out.println(sum[end]);
			
		}
		
	}

}