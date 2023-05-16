import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static int R, C;
	static char[][] board;
	static boolean[] visit;
	static int answer = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visit = new boolean[26];
		
		for(int i = 0; i<R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		visit[board[0][0] - 'A'] = true;
		DFS(1, 0, 0);
		System.out.println(answer);
		
	}
	
	private static void DFS(int depth, int x, int y) {
		
		answer = Math.max(depth, answer);
		
		for(int i = 0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y; 
			
			if(nx>=0 && nx<R && ny>=0 && ny<C && !visit[board[nx][ny]-'A']) {
				visit[board[nx][ny]-'A'] = true;
				DFS(depth+1, nx, ny);
				visit[board[nx][ny]-'A'] = false;
			}
		}
		
	}

}