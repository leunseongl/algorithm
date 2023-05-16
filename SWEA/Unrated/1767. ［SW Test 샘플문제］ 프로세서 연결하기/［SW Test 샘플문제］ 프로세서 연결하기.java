import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Data {
		int x, y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Data [x=" + x + ", y=" + y + "]";
		}
	}
	
	static int N, connectCore, line;
	static int[][] map;
	static List<Data> cores;
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
					if(i!=0 && i!=N-1 && j!=0 && j!=N-1) { //가장 자리가 아닌 코어 넣기
						if(map[i][j] == 1) cores.add(new Data(i, j));
					}
				}
			}
			//입력 완료
			
			connectCore = -1; //연결한 코어 수
			line = -1; //사용한 전선 길이
			dfs(0, 0, 0);
			
			System.out.printf("#%d %d%n", tc, line);
		}
		
	}
	
	//dfs 깊이, 연결한 코어 수, 사용한 전선 길이
	private static void dfs(int cnt, int coreCnt, int length) {
		
		//기저 조건: 모든 코어들을 다 돌았으면
		if(cnt == cores.size()) {
			if(coreCnt > connectCore) { //최대한 많은 Core에 전원을 연결하였을 경우
				connectCore = coreCnt; //최대 연결 코어 개수 갱신
				line = length; //사용한 전선 길이도 같이 갱신
			}
			else if(coreCnt == connectCore) { //동일한 개수를 연결했을 경우
				line = Math.min(line, length); //더 작은 전선 길이로 갱신
			}
			return;
		}
		
		Data cur = cores.get(cnt);
		for(int k = 0; k<4; k++) {
			if(canConnect(cur, k)) { //해당 방향으로 연결 할 수 있으면
				int ea = fill(cur, k, 2);//해당 방향대로 map에 전선 채우기
				dfs(cnt+1, coreCnt+1, length+ea);//다음 코어 dfs 보내기
				fill(cur, k, 0);//전선 채운거 백트래킹
			}
		}
		
		dfs(cnt+1, coreCnt, length); //코어 연결 안하고 넘김
	}
	
	//해당 코어를 해당 방향으로 연결할 수 있는지 
	private static boolean canConnect(Data core, int dir) {
		
		int x = core.x;
		int y = core.y;
		
		while(true) {			
			x += dx[dir];
			y += dy[dir];
			
			if(x<0 || x>=N || y<0 || y>=N) break;
			if(map[x][y] != 0) return false;
		}
		return true;
	}
	
	//채우기
	private static int fill(Data core, int dir, int var) {
		int cnt = 0;
		int x = core.x;
		int y = core.y;
		
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