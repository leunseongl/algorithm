import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 파이프는 2개의 연속된 칸을 차지
 * 파이프는 벽이 아닌 빈 칸만 차지
 * 파이프를 밀 수 있는 방향은 총 3가지 
 * 세로에서는 세로, 대각선
 * 가로에서는 가로, 대각선
 * 대각선은 대각선, 가로, 세로
 * DFS로 풀이
 */

//Q: visit 배열이 필요 없는 건 가로, 세로, 대각선만 가서?
public class Main {

	//방향: 가로-세로-대각선
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	
	static int N;
	static int[][] map;
	static int res;
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
		
		//시작 지점은 0,1
		dfs(0, 1, 0);
		System.out.println(res);
		
	}
	
	//0 - 가로, 1 - 세로, 2 - 대각선
	private static void dfs(int x, int y, int dir) {
		
		if(x == N-1 && y == N-1) {
			res++;
			return;
		}
		
		for(int i = 0; i<3; i++) {
			
			//가로일 때 세로 못가고, 세로일 때 가로 못감
			if(dir == 0 && i == 1) continue;
			if(dir == 1 && i == 0) continue;
			
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] == 0) {
				if(i == 2) {
					if(map[nx-1][ny]==0 && map[nx][ny-1]==0) {
						dfs(nx, ny, i);
					}
				}
				else dfs(nx, ny, i);
			}
		}
		
	}

}