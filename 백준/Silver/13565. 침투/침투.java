import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int N, M;
	static int[][] arr;
	static String answer;
	
	static class Data {
		private int x;
		private int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		//입력 완료
		
		answer = "NO";
		bfs();
		
		System.out.println(answer);
		
	}
	
	private static void bfs() {
		
		Queue<Data> q = new ArrayDeque<>();
		for(int i = 0; i<M; i++) {
			if(arr[0][i] == 0) {
				arr[0][i] = 1; //방문처리
				q.offer(new Data(0,i));
			}
		}
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
			//System.out.println("x " + cur.x + " y " + cur.y);
			
			if(cur.x == N-1) {
				answer = "YES";
				return;
			}
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(arr[nx][ny] == 0) {
						arr[nx][ny] = 1;
						q.offer(new Data(nx, ny));
					}
				}
			}
			
		}
		
	}
	
}