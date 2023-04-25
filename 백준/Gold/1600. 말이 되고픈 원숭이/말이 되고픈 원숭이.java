import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	static class Info {
		int x, y, cnt, horseCnt;
		public Info(int x, int y, int cnt, int horseCnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt; //전체 이동 횟수
			this.horseCnt = horseCnt; //말 이동 횟수
		}
	}
	
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[W][H];
		for(int i = 0; i<W; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<H; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		visit = new boolean[W][H][K+1];
		bfs();
		
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}

	private static void bfs() {
		
		visit[0][0][0] = true;
		
		Queue<Info> q = new ArrayDeque<>();
		q.offer(new Info(0, 0, 0, 0));
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			if(cur.x == W-1 && cur.y == H-1) {
				//System.out.println(cur.cnt);
				answer = cur.cnt;
				return;
			}
			
			//원숭이 이동
			for(int k = 0; k<4; k++) {
				int nx = dx[k] + cur.x;
				int ny = dy[k] + cur.y;
				
				if(nx>=0 && nx<W && ny>=0 && ny<H) {
					if(!visit[nx][ny][cur.horseCnt] && map[nx][ny] != 1) {
						visit[nx][ny][cur.horseCnt] = true;
						q.offer(new Info(nx, ny, cur.cnt+1, cur.horseCnt));
					}
				}
			}
			
			if(cur.horseCnt == K) continue;
			
			//말 이동
			for(int k = 0; k<8; k++) {
				int nx = hx[k] + cur.x;
				int ny = hy[k] + cur.y;
				
				if(nx>=0 && nx<W && ny>=0 && ny<H) {
					if(!visit[nx][ny][cur.horseCnt+1] && map[nx][ny] != 1) {
						visit[nx][ny][cur.horseCnt+1] = true;
						q.offer(new Info(nx, ny, cur.cnt+1, cur.horseCnt+1));
					}
				}
			}
		}
		
	}
 	
}
