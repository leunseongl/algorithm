import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//적록색약인 사람은 R==G
//적록색약이 아닌 사람은 R, G, B
public class Main {

	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static int N;
	static char[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i = 0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		//입력 완료
		
		visit = new boolean[N][N];
		int RGB = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visit[i][j]) {
					RGB++;
					bfsRGB(i, j);
				}
			}
		}
		
		visit = new boolean[N][N];
		int RB = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visit[i][j]) {
					RB++;
					bfsRB(i, j);
				}
			}
		}
		
		System.out.printf("%d %d%n", RGB, RB);
		
	}

	private static void bfsRGB(int x, int y) {
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node pop = q.poll();
			
			for(int i = 0; i<4; i++) {
				int nx = dx[i] + pop.x;
				int ny = dy[i] + pop.y;
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny] && map[nx][ny] == map[x][y]) {
					q.offer(new Node(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}		
	}
	
	private static void bfsRB(int x, int y) {
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node pop = q.poll();
			
			for(int i = 0; i<4; i++) {
				int nx = dx[i] + pop.x;
				int ny = dy[i] + pop.y;
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny]) {
					if(map[x][y] == 'R' || map[x][y] == 'G') {
						if(map[nx][ny] == 'R' || map[nx][ny] == 'G') {
							q.offer(new Node(nx, ny));
							visit[nx][ny] = true;
						}
					}
					
					else {
						if(map[nx][ny] == map[x][y]) {
							q.offer(new Node(nx, ny));
							visit[nx][ny] = true;
						}
					}
					
				}
			}
		}
		
	}
	
}
