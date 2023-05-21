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
	static int[][] city;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken()); //하나의 집이 지불할 수 있는 비용
			
			city = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					city[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료
			
			answer = 0;
			//모든 부분을 시작점을 bfs 돌리기
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

		visit[x][y] = true;
		int K = 1;
		int pay = K * K + (K - 1) * (K - 1);
		int home = 0;
		
		//K가 1일 때  계산
		if(city[x][y] == 1) { //현재 시작 위치가 집이면
			home++; //집 카운트 해주고
			if(pay<=M) answer = Math.max(1, answer);
		}
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-->0) { //레벨별 bfs 탐색, 현재 큐에 있는 애들 동시에 감
				Node cur = q.poll();
				
				for(int k = 0; k<4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					
					//경계선과 방문 조건 체크
					if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny]) {
						if(city[nx][ny] == 1) home++;
						visit[nx][ny] = true;
						q.offer(new Node(nx, ny));
					}
				}
			}
			K++;
			pay = K * K + (K - 1) * (K - 1); //운영 비용
			if(pay <= home*M) answer = Math.max(answer, home);
		}
	}
}