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
		
		int[][] dist = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k<N; k++) {
			for(int i = 0; i<N; i++) {
				if(k==i) continue;
				for(int j = 0; j<N; j++) {
					if(i==j || k==j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			if(dist[start-1][end-1] <= time) {
				System.out.println("Enjoy other party");
			}
			else if(dist[start-1][end-1] > time){
				System.out.println("Stay here");
			}
		}
		
	}

}