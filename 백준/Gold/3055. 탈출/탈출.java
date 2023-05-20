import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}
	
	static int R, C, ex, ey;
	static boolean flag;
	static char[][] map;
	static Queue<Node> wq = new ArrayDeque<>();
	static Queue<Node> dq = new ArrayDeque<>();
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i<R; i++) {
			String line = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'S') dq.offer(new Node(i, j));
				if(map[i][j] == '*') wq.offer(new Node(i, j));
				if(map[i][j] == 'D') {
					ex = i;
					ey = j;
				}
			}
		}
		//입력 완료
		
		int time = 0;
		flag = false;
		visit = new boolean[R][C];
		while(!dq.isEmpty()) {
			//System.out.println("이제부터 물");
			water();
			//System.out.println("이제부터 도치");
			dochi();
			if(flag) break;
			time++;
		}
		
		System.out.println(!flag?"KAKTUS":time);
		
	}
	
	//물 bfs
	private static void water() {

		int size = wq.size();
		while(size-->0) {
			Node cur = wq.poll();
			//System.out.println(cur);
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<R && ny>=0 && ny<C && !visit[nx][ny]) {
					if(map[nx][ny] != 'D' && map[nx][ny] != 'X') {
						visit[nx][ny] = true;
						wq.offer(new Node(nx, ny));
					}
				}
			}
		}
	}
	
	//도치 bfs
	private static void dochi() {
		
		int size = dq.size();
		while(size-->0) {
			Node cur = dq.poll();
			//System.out.println(cur);
			
			if(cur.x == ex && cur.y == ey) flag = true;
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<R && ny>=0 && ny<C && !visit[nx][ny]) {
					if(map[nx][ny] == 'D' || map[nx][ny] == '.') {
						visit[nx][ny] = true;
						dq.offer(new Node(nx, ny));
					}
				}
			}
		}
		
	}

}