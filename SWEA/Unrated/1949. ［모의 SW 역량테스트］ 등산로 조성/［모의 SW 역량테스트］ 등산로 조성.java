import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static int N, K, big, answer;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			big = 0;
			map = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					big = Math.max(big, map[i][j]);
				}
			}
			//입력 완료
			
			answer = -1;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(map[i][j] == big) {
						visit = new boolean[N][N];
						visit[i][j] = true;
						dfs(1, i, j, big, 0);
//						visit[i][j] = false;
					}
				}
			}

			
			System.out.printf("#%d %d%n", tc, answer);
			
		}
	}
	
	//isBreak: 0은 공사 안한거, 1은 한거
	private static void dfs(int depth, int x, int y, int height, int isBreak) {
		
		//System.out.println(x + " " + y);
		answer = Math.max(depth, answer);
		
		for(int k = 0; k<4; k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			
			//경계선, 방문 조건 체크
			if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny]) {
				//현재보다 낮은 지형이면 그냥 고
				if(height>map[nx][ny]) { 
					visit[nx][ny] = true;
					dfs(depth+1, nx, ny, map[nx][ny], isBreak);
					visit[nx][ny] = false;
				}
				//현재보다 높거나 같은 지형이면 깎기
				else {
					if(isBreak == 0) { //공사 아직 안했으면 공사 시작
						if(map[nx][ny]-K < map[x][y]) {//깎으면 더 낮아지는 곳이면
							visit[nx][ny] = true;
							dfs(depth+1, nx, ny, height-1, isBreak+1);
							visit[nx][ny] = false;
						}
					}
				}
			}
		}
		
	}

}