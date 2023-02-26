import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] picked;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		picked = new int[M];
		isSelected = new boolean[N];
		permutation(0);
		
	}
	
	private static void permutation(int cnt) {
		
		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				System.out.print(picked[i] + " ");
			} System.out.println();
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				picked[cnt] = i+1;
				permutation(cnt+1);
				isSelected[i] = false;
			}
		}
	}
}