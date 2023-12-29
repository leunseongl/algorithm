import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static int N, M;
	static int[][] maze;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		for(int i = 0; i<N; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j<M; j++) {
				maze[i][j] = Integer.parseInt(line[j]);
			}
		}
		//입력 완료
		
		dijkstra(0,0);
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		
		System.out.println(dist[N-1][M-1]);
		
	}
	
	private static void dijkstra(int x, int y) {
	
		dist = new int[N][M];
		for(int i = 0; i<N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[x][y] = 0;
		
		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		pq.offer(new Data(x, y, 0));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			//System.out.println("x " + cur.x + " y " + cur.y);
			
			if(cur.x == N-1 && cur.y == M-1) return;
			
			if(dist[cur.x][cur.y] < cur.cost) continue;
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x+dx[k];
				int ny = cur.y+dy[k];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				
				if(dist[nx][ny] > cur.cost+maze[nx][ny]) {
					dist[nx][ny] = cur.cost+maze[nx][ny];
					pq.offer(new Data(nx, ny, dist[nx][ny]));
				}
			}
		}
		
	}

}