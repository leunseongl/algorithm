import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* bfs */
//출발지에서 도착지까지 가는 경로 중에 복구 시간이 가장 짧은 경로에 대한 총 복구 시간
//최소의 최소 -> pq 사용
public class Solution {

	static class Node implements Comparable<Node>{
		int x, y, time;
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}
	
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0; i<N; i++) {
				String[] line = br.readLine().split("");
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}
			//입력 완료
			
			visit = new boolean[N][N];
			int res = bfs(0,0,0); //시작지점은 어차피 0
			
			System.out.printf("#%d %d%n", tc, res);
			
		}
		
		
	}
	
	private static int bfs(int x, int y, int sum) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(x, y, sum));
		visit[x][y] = true;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.x == N-1 && cur.y == N-1) 
				return cur.time;
			
			for(int i = 0; i<4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny]) {
					pq.offer(new Node(nx, ny, cur.time+map[nx][ny]));
					visit[nx][ny] = true;
				}
			}
		}
		return -1;
	}
}