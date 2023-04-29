import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static int N, result;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		result = Integer.MIN_VALUE;
		dp = new int[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				result = Math.max(result, dfs(i, j));
			}
		}
		
		System.out.println(result);
		
	}
	
	//x, y
	private static int dfs(int x, int y) {

		if(dp[x][y] != 0) return dp[x][y];
		
		int cnt = 1; 
		
		for(int k = 0; k<4; k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			
			if(nx>=0 && nx<N && ny>=0 && ny<N) {
				if(map[nx][ny] > map[x][y]) {
					cnt = Math.max(dfs(nx, ny)+1, cnt);
					dp[x][y] = cnt;
				}
			}
			
		}
		return cnt;
	}

}
