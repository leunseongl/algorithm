import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, answer;
	static int[][] lab;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		answer = Integer.MIN_VALUE;
		combination(0,0);
		
		System.out.println(answer);
	}
	
	//벽 세우기 - 조합
	private static void combination(int cnt, int start) {
		
		if(cnt == 3) {
			bfs();
			return;
		}
		
		for(int i = start; i<N*M; i++) {
			int x = i/M;
			int y = i%M;
			
			if(lab[x][y] == 0) {
				lab[x][y] = 1;
				combination(cnt+1, i+1);
				lab[x][y] = 0;
			}
		}
	}
	
	//바이러스 퍼트리고, 안전영역 갯수 세기 - bfs
	private static void bfs() {
		
		int[][] copy = new int[N][M];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				copy[i][j] = lab[i][j];
			}
		}
		//배열 복사 완료
		
		boolean[][] visit = new boolean[N][M];
		Queue<Node> q = new ArrayDeque<>();
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(copy[i][j] == 2) { //바이러스면
					visit[i][j] = true;
					q.offer(new Node(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(!visit[nx][ny] && copy[nx][ny]==0) {
						copy[nx][ny] = 2; //바이러스로 만들기
						visit[nx][ny] = true;
						q.offer(new Node(nx, ny));
					}
				}
			}
		}
		
		//안전영역 세기
		int safe = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(copy[i][j] == 0) safe++;
			}
		}
		answer = Math.max(answer, safe);
	}
}
