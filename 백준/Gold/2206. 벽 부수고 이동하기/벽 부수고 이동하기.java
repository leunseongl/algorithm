import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*bfs version*/
public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Node {
		int x, y, cnt;
		int breakCnt; //0은 안깬거, 1은 꺤거
		public Node(int x, int y, int cnt, int breakCnt) {			
			this.x = x;
			this.y = y;
			this.cnt = cnt; //이동 경로 개수
			this.breakCnt = breakCnt;
		}
		
	}
	
	static int[][] map;
	static boolean[][][] visit;
	static int N, M;
	static int answer = -1;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		//입력 완료
		
		visit = new boolean[N][M][2];
		bfs();

		System.out.println(answer==-1?-1:answer);
	}

	private static void bfs() {
		
		visit[0][0][0] = true; 
		//시작 점 방문처리
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, 0, 1, 0));
		//x, y - 시작점 (0,0), cnt - 시작점 포함해서 1, 부수기 횟수
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			//끝나는 칸에 도달하면
			if(cur.x == N-1 && cur.y == M-1) {
				answer = cur.cnt;
				return;
			}
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				//경계선 체크
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					//벽이 아니면
					if(map[nx][ny] == 0 && !visit[nx][ny][cur.breakCnt]) {
						visit[nx][ny][cur.breakCnt] = true;
						q.offer(new Node(nx, ny, cur.cnt+1, cur.breakCnt));
					}
					
					//쓴 횟수에 대한 정보
					if(cur.breakCnt == 1) continue;
					
					//벽이고, 부술 수 있으면
					if(map[nx][ny] == 1 && !visit[nx][ny][1]) {
						visit[nx][ny][1] = true;
						q.offer(new Node(nx, ny, cur.cnt+1, 1));
					}
				}
			}
		}
	}
}
