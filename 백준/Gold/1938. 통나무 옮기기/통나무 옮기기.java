import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int[] tx = {0,-1,0,1,1,1,-1,-1};
	static int[] ty = {-1,0,1,0,1,-1,1,-1};
	
	static class Info {
		int x, y, dir, cnt;
		public Info(int x, int y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir; //0이면 세로, 1면 가로
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
	}
	static int N, sx, sy, sDir, ex, ey, eDir, answer;
	static char[][] map;
	static boolean[][][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i = 0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		//입력 완료
		
		for(int i = 0; i<N; i++) {
 			for(int j = 0; j<N; j++) {
 				if(map[i][j] == 'B') { //시작 지점이면
	 				if(i-1>=0 && i+1<N) { //범위 체크
	 					//위, 아래 모두가 B면 해당 좌표 정보 저장
	 					if(map[i-1][j]=='B' && map[i+1][j]=='B') {
	 						map[i-1][j] = '0'; map[i][j] = '0'; map[i+1][j] = '0';
	 						sx = i; sy = j; sDir = 0;
	 					}
	 				}
	 				if(j-1>=0 && j+1<N) { //범위 체크
	 					if(map[i][j-1]=='B' && map[i][j+1]=='B') {
	 						map[i][j-1] = '0'; map[i][j] = '0'; map[i][j+1] = '0';
	 						sx = i; sy = j; sDir = 1;
	 					}
	 				}
	 			}
 				else if(map[i][j] == 'E') { //끝 지점이면
 					if(i-1>=0 && i+1<N) { //범위 체크
	 					//위, 아래 모두가 E면 해당 좌표 정보 저장
	 					if(map[i-1][j]=='E' && map[i+1][j]=='E') {
	 						map[i-1][j] = '0'; map[i][j] = '0'; map[i+1][j] = '0';
	 						ex = i; ey = j; eDir = 0;
	 					}
	 				}
 					if(j-1>=0 && j+1<N) { //범위 체크
	 					if(map[i][j-1]=='E' && map[i][j+1]=='E') {
	 						map[i][j-1] = '0'; map[i][j] = '0'; map[i][j+1] = '0';
	 						ex = i; ey = j; eDir = 1;
	 					}
	 				}
 				}
 			}
		}
		//시작지점, 끝지점 정보 저장
		
		answer = 0;
		visit = new boolean[N][N][2];
		bfs();
		System.out.println(answer);
	}
	
	private static void bfs() {
		
		visit[sx][sy][sDir] = true;
		Queue<Info> q = new ArrayDeque<>();
		q.offer(new Info(sx, sy, sDir, 0));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			//System.out.println(cur);
			
			//종료 지점에 도착하면
			if(cur.x==ex && cur.y==ey && cur.dir==eDir) { 
				answer = cur.cnt;
				return;
			}
			
			for(int k = 0; k<4; k++) {
				//현재 방향이 세로면
				if(cur.dir == 0) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					//범위 체크 (틀리면 여기일듯)
					if(nx-1>=0 && nx+1<N && ny>=0 && ny<N) {
						//갈 수 있는 곳인지 체크
						if(map[nx-1][ny]=='0' && map[nx][ny]=='0' && map[nx+1][ny]=='0') {
							//방문하지 않은 곳인지 체크
							if(!visit[nx][ny][0]) {
								visit[nx][ny][0] = true;
								q.offer(new Info(nx, ny, cur.dir, cur.cnt+1));
							}
						}
					}
				}
				//현재 방향이 가로면
				else if(cur.dir == 1) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					
					//범위 체크
					if(nx>=0 && nx<N && ny-1>=0 && ny+1<N) {
						if(map[nx][ny-1]=='0' && map[nx][ny]=='0' && map[nx][ny+1]=='0') {
							if(!visit[nx][ny][1]) {
								visit[nx][ny][1] = true;
								q.offer(new Info(nx, ny, cur.dir, cur.cnt+1));
							}
						}
					}
				}
			}
			
			//회전
			int cnt = 0; //0이면 카운트++
			//회전을 하기 위해 주변이 0인지 체크
			for(int i = 0; i<8; i++) {
				int nx = cur.x + tx[i];
				int ny = cur.y + ty[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(map[nx][ny] == '0') cnt++;
				}
			}
			
			if(cnt == 8) { //주변이 모두 0이라면 회전
				//회전은 그냥 방향만 바꿔서 넣어주면 됨
				if(cur.dir == 0 && !visit[cur.x][cur.y][1]) { //세로면
					visit[cur.x][cur.y][1] = true;
					q.offer(new Info(cur.x, cur.y, 1, cur.cnt+1));
				}
				else if(cur.dir == 1 && !visit[cur.x][cur.y][0]) { //가로면
					visit[cur.x][cur.y][0] = true;
					q.offer(new Info(cur.x, cur.y, 0, cur.cnt+1));
				}
			}
			
		}
		
	}

}