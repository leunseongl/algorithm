import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	
	static class Node {
		int sx, sy, curX, curY, cnt;
		public Node(int sx, int sy, int curX, int curY, int cnt) {
			this.sx = sx;
			this.sy = sy;
			this.curX = curX;
			this.curY = curY;
			this.cnt = cnt;
		}
	}
	
	static int N, M, big, password;
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
		
		big = 0;
		password = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] != 0) {
					//System.out.println("시작 지점 " + i + " " +j);
					visit = new boolean[N][M];
					bfs(i, j);
				}
			}
		}
		
		System.out.println(password);
		
	}
	
	private static void bfs(int x, int y) {
		
		visit[x][y] = true;
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y, x, y, 1)); //시작 위치도 cnt에 포함할거임
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			//System.out.println(cur.curX + " " + cur.curY + " " + cur.cnt);
			if(cur.cnt > big) { //현재 bfs의 길이가 가장 길다면 
				big = cur.cnt; //제일 긴 길이 값을 갱신해주고
				password = map[cur.sx][cur.sy] + map[cur.curX][cur.curY]; //비밀번호 갱신\
				//System.out.println("큰 값 갱신: " + password);
			}
			else if(cur.cnt == big) { //현재 bfs의 길이가 가장 긴 값과 같다면
				password = Math.max(password, map[cur.sx][cur.sy] + map[cur.curX][cur.curY]);
				//System.out.println("큰 값 동일: " + password);
			}
			
			for(int k = 0; k<4; k++) {
				int nx = cur.curX + dx[k];
				int ny = cur.curY + dy[k];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(!visit[nx][ny] && map[nx][ny]!=0) {
						visit[nx][ny] = true;
						q.offer(new Node(x, y, nx, ny, cur.cnt+1));
					}
				}
			}
			
		}
		
	}

}