import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	//방향 고정
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};
	
	static int N, answer;
	static int[][] map;
	static boolean[][] visit;
	static HashSet<Integer> set;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료
			
			answer = -1;
			for(int i = 0; i<N-2; i++) {
				for(int j = 1; j<N-1; j++) {
					visit = new boolean[N][N];
					set = new HashSet<>();
					visit[i][j] = true;
					set.add(map[i][j]);
					dfs(i, j, i, j, 0);
					visit[i][j] = false;
					set.remove(map[i][j]);
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
		}
		
	}
	
	private static void dfs(int curX, int curY, int sx, int sy, int dir) {
		
		for(int k = dir; k<4; k++) {
			int nx = curX + dx[k];
			int ny = curY + dy[k];
			
			//기저 조건
			if(set.size()>=4 && nx == sx && ny == sy) {
				answer = Math.max(answer, set.size());
				return;
			}
			
			if(nx>=0 && nx<N && ny>=0 && ny<N) {
				if(!visit[nx][ny] && !set.contains(map[nx][ny])) {
					visit[nx][ny] = true;
					set.add(map[nx][ny]);
					dfs(nx, ny, sx, sy, k);
					set.remove(map[nx][ny]);
					visit[nx][ny] = false;
				}
			}
		}
		
	}
	
}