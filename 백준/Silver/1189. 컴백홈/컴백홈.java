import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int R, C, K, answer;
	static char[][] street;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		street = new char[R][C];
		for(int i = 0; i<R; i++) {
			street[i] = br.readLine().toCharArray();
		}
		//입력 완료
		
		answer = 0;
		visit = new boolean[R][C];
		visit[R-1][0] = true;
		dfs(R-1, 0, 1);
		
		System.out.println(answer);
		
	}
	
	private static void dfs(int x, int y, int cnt) {
		
		if(cnt>K) return;
		
		if(x==0 && y==C-1) { //집에 도착하면
			if(cnt == K) answer++;
			return;
		}
		
		visit[x][y] = true;
		
		for(int k = 0; k<4; k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			
			if(nx>=0 && nx<R && ny>=0 && ny<C) {
				if(!visit[nx][ny] && street[nx][ny] == '.') {
					dfs(nx, ny, cnt+1);
				}
			}
		}
		
		visit[x][y] = false;
		
	}

}