import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//중복 조합
public class Main {

	static int N;
	static int M;
	static int[] picked;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		picked = new int[M];
		
		duplicateCombination(0, 1);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void duplicateCombination(int cnt, int start) throws IOException {
		
		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				bw.write(String.valueOf(picked[i]) + " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i = start; i<=N; i++) {
			picked[cnt] = i;
			duplicateCombination(cnt+1, i);
		}
	}

}