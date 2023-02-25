import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//0만 탐색 가능, 1은 벽
public class Main {

	//가로, 세로, 대각선
	static int[] dx = {0,1,1};
	static int[] dy = {1,0,1};
	static int N;
	static int[][] map;
	static int count = 0;
	
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
		
		DFS(0, 1, 0);
		System.out.println(count);
	}
	
	//현재 방향 매개변수 - 0: 가로 / 1: 세로 / 2: 대각선
	private static void DFS(int x, int y, int dir) {
		
		if(x == N-1 && y == N-1) {
			count++;
			return;
		}
		
		for(int i = 0; i<3; i++) {
			//가로 -> 세로 안됨, 세로 -> 가로 안됨
			if((dir == 0 && i == 1)||(dir == 1 && i == 0)) {
				continue;
			}
			
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] != 1) {
				
				if(i == 2 && (map[x+1][y] == 1 || map[x][y+1] == 1)) {
					continue;
				}
				
				DFS(nx, ny, i);
			}
			
		}
		
	}
	
	

}