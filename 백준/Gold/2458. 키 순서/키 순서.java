import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] check = new boolean[N][N];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			check[a-1][b-1] = true;
		}
		
		for(int k = 0; k<N; k++) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(check[i][k] && check[k][j]) check[i][j] = true;
				}
			}
		}	

		int[] cnt = new int[N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(check[i][j] || check[j][i]) cnt[i]++;
			}
		}
		
		int answer = 0;
		for(int c: cnt) {
			if(c == N-1) answer++;
		}
		
		System.out.println(answer);
	}
}