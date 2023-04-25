import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Node {
		int x, y, cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static int N, M;
	static char[][] map;
	static boolean[][] visit;
	static int result;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i = 0; i<N; i++) {
			String line = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		//입력 완료
		
		result = Integer.MIN_VALUE;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 'L') { //육지면 bfs 돌리기
					bfs(i, j);
				}
			}
		}
			
		System.out.println(result);
	}
	
	private static void bfs(int i, int j) {

		visit = new boolean[N][M];
		visit[i][j] = true;
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(i, j, 0));
		
		while(!q.isEmpty() ) {
			Node cur = q.poll();
			
			for(int k = 0; k<4; k++) {
				int nx = dx[k] + cur.x;
				int ny = dy[k] + cur.y;
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(!visit[nx][ny] && map[nx][ny] == 'L') {
						visit[nx][ny] = true;
						q.offer(new Node(nx, ny, cur.cnt+1));
					}
				}
			}
			result = Math.max(cur.cnt, result);
		}
	}

}