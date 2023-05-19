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
		int x, y, cnt, breakCnt;
		public Node(int x, int y, int cnt, int breakCnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.breakCnt = breakCnt;
		}
	}
	
	static int N,M,answer;
	static int[][] map;
	static boolean[][][] visit;
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
	
		answer = -1;
		visit = new boolean[N][M][2]; //0은 안부수고, 1은 부수고
		bfs();
	
		System.out.println(answer);
	}

	private static void bfs() {
		
		visit[0][0][0] = true;
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, 0, 1, 0)); //시작 위치도 카운트에 포함
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.x == N-1 && cur.y == M-1) {
				answer = cur.cnt;
				return;
			}
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					
					if(map[nx][ny]==0 && !visit[nx][ny][cur.breakCnt]) {
						visit[nx][ny][cur.breakCnt] = true;
						q.offer(new Node(nx, ny, cur.cnt+1, cur.breakCnt));
					}
					
					//if(cur.breakCnt > 0) continue;
					
					if(map[nx][ny] == 1) {						
						if(cur.breakCnt<1 && !visit[nx][ny][1]) { 
							visit[nx][ny][1] = true;
							q.offer(new Node(nx, ny, cur.cnt+1, cur.breakCnt+1));
						}
					}
				}
			}
		}
		
	}
}