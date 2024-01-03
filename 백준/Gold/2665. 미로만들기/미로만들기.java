import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int N;
	static int[][] arr;
	static int[][] dist;
	
	static class Data {
		int x, y, cost;
		public Data(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for(int i = 0; i<N; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		//입력 완료
		
		dist = new int[N][N];
		dijkstra(0,0);
		
		System.out.println(dist[N-1][N-1]);
	}
	
	private static void dijkstra(int x, int y) {
		
		for(int i = 0; i<N; i++) {
			Arrays.fill(dist[i], 2500);
		}
		dist[x][y] = 0;
		
		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		pq.offer(new Data(x, y, 0));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			
			if(cur.x == N-1 && cur.y == N-1) {
				return;
			}
			
			if(dist[cur.x][cur.y]<cur.cost) continue;
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				
				if(arr[nx][ny] == 0) {
					if(dist[nx][ny] > dist[cur.x][cur.y]+1) {
						dist[nx][ny] = dist[cur.x][cur.y]+1;
						pq.offer(new Data(nx, ny, cur.cost+1));
					}
				}
				
				else if(arr[nx][ny] == 1) {
					if(dist[nx][ny] > dist[cur.x][cur.y]) {
						dist[nx][ny] = dist[cur.x][cur.y];
						pq.offer(new Data(nx, ny, cur.cost));
					}
				}
				
			}
		}
		
	}

}
