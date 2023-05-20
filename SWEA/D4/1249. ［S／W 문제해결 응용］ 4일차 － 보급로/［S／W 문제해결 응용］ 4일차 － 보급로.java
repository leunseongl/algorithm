import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Node implements Comparable<Node>{
		int x, y, num, time;
		public Node(int x, int y, int num, int time) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			return this.time-o.time;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", num=" + num + ", time=" + time + "]";
		}
	}
	
	static int N, answer;
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
			
			answer = 0;
			visit = new boolean[N][N];
			bfs();
			
			System.out.printf("#%d %d%n", tc, answer);
		}
	}

	private static void bfs() {

		visit[0][0] = true;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0,0,0)); //시작, 끝 위치는 num이 0
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			//System.out.println(cur);
			
			if(cur.x == N-1 && cur.y == N-1) {
				answer = cur.time;
				return;
			}
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny]) {
					visit[nx][ny] = true;
					pq.offer(new Node(nx, ny, map[nx][ny], cur.time+map[nx][ny]));
				}
			}
		}
		
		
	}
}