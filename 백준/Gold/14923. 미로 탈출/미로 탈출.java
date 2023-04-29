import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Info {
		int x, y, cnt, isUse;
		public Info(int x, int y, int cnt, int isUse) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.isUse = isUse; //0은 안쓴거, 1은 쓴거
		}
	}
	
	static int N, M, Hx, Hy, Ex, Ey;
	static int[][] map;
	static boolean[][][] visit;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Hx = Integer.parseInt(st.nextToken())-1;
		Hy = Integer.parseInt(st.nextToken())-1;
		
		st = new StringTokenizer(br.readLine());
		Ex = Integer.parseInt(st.nextToken())-1;
		Ey = Integer.parseInt(st.nextToken())-1;
		
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		visit = new boolean[N][M][2]; 
		bfs();
		
		System.out.println(result == Integer.MAX_VALUE ? -1:result);
		
	}
	
	private static void bfs() {

		visit[Hx][Hy][0] = true;
		Queue<Info> q = new ArrayDeque<>();
		q.offer(new Info(Hx, Hy, 0, 0));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			//기저 조건, 도착 지점에 도착했을 경우
			if(cur.x == Ex && cur.y == Ey) {
				result = cur.cnt;
				return;
			}
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				//경계선 체크
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					//빈 칸일 경우
					if(map[nx][ny] == 0 && !visit[nx][ny][cur.isUse]) {
						visit[nx][ny][cur.isUse] = true;
						q.offer(new Info(nx, ny, cur.cnt+1, cur.isUse));
					}
					
					//벽이고, isUse가 false일 경우
					else if(map[nx][ny] == 1 && cur.isUse == 0 && !visit[nx][ny][1]) {
						visit[nx][ny][1] = true;
						q.offer(new Info(nx, ny, cur.cnt+1, 1));
					}
				}
			
			}
		}
	}
}