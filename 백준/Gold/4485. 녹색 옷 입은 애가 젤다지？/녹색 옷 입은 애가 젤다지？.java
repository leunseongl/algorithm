import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 가중치가 있는 최단경로는 다익스트라 알고리즘 사용
 * 이 문제의 경우 도둑루피 = 가중치
 * 이전에 풀었던 다익스트라 문제와는 달리 인접 리스트 사용 x, 그래프 자료구조 형태의 문제가 아님
 * 
 */
public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int N;
	static int[][] cave;
	static int[][] dist;
	static boolean[][] visit;
	
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
		int cnt = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			cave = new int[N][N];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료
			
			dist = new int[N][N];
			for(int i = 0; i<N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			dijkstra(0,0);
			
//			for(int i = 0; i<N; i++) {
//				System.out.println(Arrays.toString(dist[i]));
//			}
			
			System.out.println("Problem " + cnt + ": " + dist[N-1][N-1]);
			cnt++;
		}
		
	}
	
	private static void dijkstra(int x, int y) {
		
		visit = new boolean[N][N];
		visit[x][y] = true;
		dist[x][y] = cave[x][y];
		
		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		pq.offer(new Data(x, y, cave[x][y]));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			
			if(cur.x == N-1 && cur.y == N-1) { //종료 조건
				return;
			}
			
			if(dist[cur.x][cur.y] < cur.cost) continue;
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(!visit[nx][ny] && dist[nx][ny]>cur.cost+cave[nx][ny]) {
					visit[nx][ny] = true;
					dist[nx][ny] = cur.cost+cave[nx][ny];
					pq.offer(new Data(nx, ny, dist[nx][ny]));
				}	
			}
		}
		
	}

}