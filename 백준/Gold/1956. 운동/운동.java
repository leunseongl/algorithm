import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[V][V];
		for(int i = 0; i<V; i++) {
			for(int j = 0; j<V; j++) {
				if(i==j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[a-1][b-1] = c;
		}
		
		for(int k = 0; k<V; k++) {
			for(int i = 0; i<V; i++) {
				if(i==k) continue;
				for(int j = 0; j<V; j++) {
					if(i==j || k==j) continue;
					
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		
//		for(int i = 0; i<V; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		
		int answer = INF;
		for(int i = 0; i<V; i++) {
			for(int j = 0; j<V; j++) {
				if(i == j) continue;
				else {
					if(dist[i][j] != INF && dist[j][i] != INF) {
						int tmp = dist[i][j] + dist[j][i];
						answer = Math.min(answer, tmp);
					}
				}
			}
		}
		
		System.out.println(answer == INF ? -1 : answer);
		
	}

}