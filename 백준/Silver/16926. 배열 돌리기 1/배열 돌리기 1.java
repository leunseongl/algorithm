import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//순서: 우하좌상
//시작 위치 정하기
//map[0][0] 값 빼놓기

public class Main {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] map; 
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
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
		
		int start = Math.min(N, M)/2;
		for(int s = 0; s<start; s++) {
			
			int x = s;
			int y = s;
			int dir = 0;
			
			int temp = map[x][y];
			
			while(dir<4) {
				int nx = dx[dir] + x;
				int ny = dy[dir] + y;
				
				if(nx>=s && nx<N-s && ny>=s && ny<M-s) {
					map[x][y] = map[nx][ny];
					
					x = nx;
					y = ny;
				}
				
				else dir++;
			}
			
			map[s+1][s] = temp;
		}
		
	}
}