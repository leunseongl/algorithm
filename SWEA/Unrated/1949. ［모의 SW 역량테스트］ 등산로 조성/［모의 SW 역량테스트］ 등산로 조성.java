import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visit;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int big = 0; //봉우리를 찾기 위해 최대값 찾기
			map = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j] = tmp;
					big = Math.max(tmp, big);
				}
			}
			//입력 완료
			
			visit = new boolean[N][N];
			answer = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(map[i][j] == big) {
						visit[i][j] = true;
						DFS(1, i, j, false);
						visit[i][j] = false;
					}
				}
			}
			System.out.printf("#%d %d%n", tc, answer);
		}
	}
	
	private static void DFS(int depth, int x, int y, boolean isConst) {

		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny]) {
				if(map[nx][ny]<map[x][y]) {
					visit[nx][ny] = true;
					DFS(depth+1, nx, ny, isConst);
					visit[nx][ny] = false;
				} 
				
				else if(!isConst) {
					isConst = true;
					for(int j = 1; j<=K; j++) {
						if(map[nx][ny]-j<map[x][y]) {
							map[nx][ny] -= j;
							DFS(depth+1, nx, ny, isConst);
							map[nx][ny] += j;
						}
					}
					isConst = false;
				}
				
			}
		}
		
		answer = Math.max(depth, answer);
		
		
	}

}