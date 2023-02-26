import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] picked;
//	static boolean[] isSelected;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		picked = new int[M];
		permutation(0);
//		isSelected = new boolean[N];
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static void permutation(int cnt) throws IOException {
		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				bw.write(picked[i] + " ");
			} bw.newLine();
			return;
		}
		
		for(int i = 0; i<N; i++) {
			picked[cnt] = i+1;
			permutation(cnt+1);
		}
		
	}
}