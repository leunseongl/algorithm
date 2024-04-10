import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static int N, M, answer;
	static char[][] campus;
	static boolean[][] visit;
	
	static class Data {
		int x, y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		campus = new char[N][M];
		for(int i = 0; i<N; i++) {
			campus[i] = br.readLine().toCharArray();
		}
		
		answer = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(campus[i][j] == 'I') bfs(i, j);
			}
		}
		
		System.out.println(answer==0? "TT":answer);
		
	}

	private static void bfs(int x, int y) {
		
		visit = new boolean[N][M];
		visit[x][y] = true;
	
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(x, y));
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x+dx[k];
				int ny = cur.y+dy[k];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(!visit[nx][ny] && campus[nx][ny] != 'X') {
						visit[nx][ny] = true;
						q.offer(new Data(nx, ny));
						if(campus[nx][ny] == 'P') answer++;
					}
				}
			}
		}
	}
}