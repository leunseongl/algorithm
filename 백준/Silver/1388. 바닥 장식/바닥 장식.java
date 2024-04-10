import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] room;
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		room = new char[N][M];
		for(int i = 0; i<N; i++) {
			room[i] = br.readLine().toCharArray();
		}
		//입력 완료
		
		int tree = 0;
		visit = new boolean[N][M];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(visit[i][j]) continue;
				if(room[i][j] == '-') dfs(i, j, true);
				else dfs(i, j, false);
				tree++;
			}
		}
		
		System.out.println(tree);
		
	}
	
	private static void dfs(int x, int y, boolean row) {
		
		visit[x][y] = true;
		
		if(row) {
			if(y+1<M && room[x][y+1] == '-') {
				dfs(x, y+1, true);
			}
		}
		
		else {
			if(x+1<N && room[x+1][y] == '|') {
				dfs(x+1, y, false);
			}
		}
		
	}

}