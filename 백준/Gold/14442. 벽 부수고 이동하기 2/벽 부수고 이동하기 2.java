import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Info {
		int x, y, cnt, breakCnt;
		public Info(int x, int y, int cnt, int breakCnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.breakCnt = breakCnt;
		}
	}
		
	static int N, M, K;
	static int[][] map;
	static boolean[][][] visit;
	static int answer = -1;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		//입력 완료
		
		visit = new boolean[N][M][K+1];
		bfs();
		
		System.out.println(answer!=-1?answer:-1);
	}

	private static void bfs() {

		visit[0][0][0] = true;
		//(0,0)을 벽을 한 개도 안부수고 갔다
		
		Queue<Info> q = new ArrayDeque<>();
		q.offer(new Info(0, 0, 1, 0));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();

			//마지막 칸에 도달하면 멈춤
			if(cur.x == N-1 && cur.y == M-1) {
				//System.out.println(cur.cnt);
				answer = cur.cnt;
				return;
			}
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				//경계선, 검사
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					
					//벽 안부수고 이동
					if(map[nx][ny] == 0 && !visit[nx][ny][cur.breakCnt]) {
						visit[nx][ny][cur.breakCnt] = true;
						q.offer(new Info(nx, ny, cur.cnt+1, cur.breakCnt));
					}
					
					//벽 부술 갯수가 남지 않았으면 continue
					if(cur.breakCnt == K) continue;
					
					//벽 부수고 이동
					else if(map[nx][ny] == 1 && !visit[nx][ny][cur.breakCnt+1]) {
						visit[nx][ny][cur.breakCnt+1] = true;
						q.offer(new Info(nx, ny, cur.cnt+1, cur.breakCnt+1));
					}
				}
			}
		}
	}
}