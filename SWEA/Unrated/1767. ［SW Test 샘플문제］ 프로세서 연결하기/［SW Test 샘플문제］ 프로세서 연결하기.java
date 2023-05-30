import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Core {
		int x, y;
		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Core [x=" + x + ", y=" + y + "]";
		}
	}
	
	static int N, core, line;
	static int[][] map;
	static List<Core> cores;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			cores = new ArrayList<>();
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(i!=0 && i!=N-1 && j!=0 && j!=N-1) cores.add(new Core(i, j));
					}
				}
			}
			//입력 완료
			
			core = Integer.MIN_VALUE;
			line = Integer.MAX_VALUE;
			dfs(0,0,0);
			
			System.out.printf("#%d %d%n", tc, line);
		}
	}

	private static void dfs(int cnt, int coreCnt, int length) {
		
		if(cnt == cores.size()) {
			if(coreCnt > core) {
				core = coreCnt;
				line = length;
			}
			else if(coreCnt == core) {
				line = Math.min(line, length);
			}
			return;
		}
		
		Core cur = cores.get(cnt); //현재 코어
		//현재 코어 연결
		for(int k = 0; k<4; k++) {
			if(canConnect(cur, k)) {
				int tmp = fill(cur, k, 2); //전선 연결
				dfs(cnt+1, coreCnt+1, length+tmp);
				fill(cur, k, 0); //백트래킹
			}
		}
		
		//현재 코어 연결 x
		dfs(cnt+1, coreCnt, length);
	}
	
	//그 방향으로 연결 가능한지
	private static boolean canConnect(Core c, int dir) {
		int x = c.x;
		int y = c.y;
		
		while(true) {
			x += dx[dir];
			y += dy[dir];
			
			if(x<0 || x>=N || y<0 || y>=N) break;
			if(map[x][y] != 0) return false; //빈공간이 아니라면 false
		}
		return true;
	}
	
	//채우기
	private static int fill(Core c, int dir, int var) {
		int cnt = 0; 
		int x = c.x;
		int y = c.y;
		
		while(true) {
			x += dx[dir];
			y += dy[dir];
			
			if(x<0 || x>=N || y<0 || y>=N) break;
			map[x][y] = var;
			cnt++;
		}
		return cnt;
	}
}