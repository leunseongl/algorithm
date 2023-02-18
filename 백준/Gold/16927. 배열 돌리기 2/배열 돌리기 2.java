import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static int N,M,R; 
	static int[][] map;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate();
		
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				System.out.print(map[i][j] + " ");
			} System.out.println();
		}
		
	}
	
	private static void rotate() {
		
		int cnt = Math.min(N, M)/2;
		for(int s = 1; s<=cnt; s++) {
			
			int optR = R%(2*(N-2*s+1) + 2*(M-2*s+1));
			for(int i = 0; i<optR; i++) {
			
				int x = s;
				int y = s;

				int dir = 0;
				int tmp = map[x][y];

				while (dir < 4) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if (nx >= s && nx <= N - s + 1 && ny >= s && ny <= M - s + 1) {
						map[x][y] = map[nx][ny];

						x = nx;
						y = ny;
					}

					else
						dir++;
				}

				map[s + 1][s] = tmp;
			}
		}
		
	}
 
}
