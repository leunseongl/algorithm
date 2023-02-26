
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] array;
	static int[] picked;
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
		
		picked = new int[M];
		Arrays.sort(array);
		combination(0, 0);
		
		bw.flush();
		bw.close();
		
	}
	
	private static void combination(int cnt, int start) throws IOException {

		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				bw.write(picked[i] + " ");
			} 
			bw.newLine();
			return;
		} 
		
		
		for(int i = start; i<N; i++) {
			picked[cnt] = array[i];
			combination(cnt+1, i+1);
		}
		
	}
	
}
