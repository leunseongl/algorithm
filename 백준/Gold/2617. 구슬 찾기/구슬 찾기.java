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
		
		boolean[][] dist = new boolean[N][N];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;

			dist[a][b] = true;
		}
		
		for(int k = 0; k<N; k++) {
			for(int i = 0; i<N; i++) {
				if(k==i) continue;
				for(int j = 0; j<N; j++) {
					if(k==j || i==j) continue;
					if(dist[i][k] && dist[k][j]) dist[i][j]=true;
				}
			}
		}
		
		int[] big = new int[N];
		int[] small = new int[N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(i == j || !dist[i][j]) continue;
				big[i]++;
				small[j]++;
			}
		}
		
		int answer = 0;
		for(int i = 0; i<N; i++) {
			if(big[i]>N/2) answer++;
			if(small[i]>N/2) answer++;
		}
		
		System.out.println(answer);
	}

}