import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> sum = new ArrayList<Integer>();
		sum.add(0);
		int tmp = 0;
		for(int i = 0; i<N; i++) {
			tmp += numbers[i];
			sum.add(tmp);
		}
		
		for(int tc = 0; tc<M; tc++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			
			System.out.println(sum.get(J) - sum.get(I-1));
		}
	}
	
}
