import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
	static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
	
	static class Node {
		int cnt, x, y;
		public Node(int cnt, int x, int y) {
			this.cnt = cnt;
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [cnt=" + cnt + ", x=" + x + ", y=" + y + "]";
		}
	}
	
	static int N, M, result;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		result = Integer.MIN_VALUE;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] != 1) bfs(i, j);
			}
		}
		
		System.out.println(result);
		
	}
	
	private static void bfs(int x, int y) {
		
		visit = new boolean[N][M];
		visit[x][y] = true;
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, x, y));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(map[cur.x][cur.y] == 1) {
				result = Math.max(result, cur.cnt);
				return;
			}
			
			for(int k = 0; k<8; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.offer(new Node(cur.cnt+1, nx, ny));
				}
			}
			
		}
		
	}

}