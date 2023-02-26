import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] array;
	static int[] picked;
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		picked = new int[M];
		visit = new boolean[N];
		permutation(0);
		
		bw.flush();
		bw.close();
	}
	
	private static void permutation(int cnt) throws IOException {
		
		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				bw.write(picked[i] + " ");
			} 
			bw.newLine();
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				picked[cnt] = array[i];
				permutation(cnt+1);
				visit[i] = false;
			}
		}
		
	}
}