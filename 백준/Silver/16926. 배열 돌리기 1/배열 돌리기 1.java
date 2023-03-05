import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//반시계방향 회전
class Main {

	//우 하 좌 상
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); //회전의 개수
		
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<R; i++) {
			rotate();
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			} System.out.println();
		}
		
	}
	
	private static void rotate() {

		int start = Math.min(N, M)/2; //한 번 배열을 돌릴 때 시작점
		for(int s = 0; s<start; s++) {
			
			int x = s;
			int y = s; 
			int dir = 0;
			int tmp = map[x][y];
			
			while(dir<4) {
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				if(nx>=s && nx<N-s && ny>=s && ny<M-s) {
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				}
				else dir++;
			}
			map[s+1][s] = tmp;
		}
		
	}

}
