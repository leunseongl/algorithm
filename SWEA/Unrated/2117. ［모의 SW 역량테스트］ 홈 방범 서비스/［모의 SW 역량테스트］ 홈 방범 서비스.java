import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x; 
			this.y = y;
		}
	}
	
	static int N, M, answer;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료
			
			answer = Integer.MIN_VALUE;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					visit = new boolean[N][N];	
					bfs(i, j);
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
		}
	}
	
	private static void bfs(int x, int y) {

		int K = 1; 
		int home = 0;
		
		//K=1 일 때 계산
		int cost = K*K+(K-1)*(K-1); //비용 계산
		if(map[x][y] == 1) home++; //현재 위치가 집이라면 +1
		if(home*M-cost>=0) answer = Math.max(answer, home);
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			K++;
			
			while(size-->0) {
				Node cur = q.poll();
				//System.out.println(cur);
				
				for(int k = 0; k<4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					
					if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new Node(nx, ny));
						if(map[nx][ny] == 1) home++;
					}
				}
			}
			
			cost = K*K+(K-1)*(K-1);
			if(home*M-cost>=0) answer = Math.max(answer, home);
			
			if(K == N+1) return;
		}
		
	}

}