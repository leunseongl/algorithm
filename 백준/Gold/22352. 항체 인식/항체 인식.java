import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int N, M;
	static int[][] before;
	static int[][] after;
	static boolean[][] visit;
	
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 백신 맞은 이전 조직
		before = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				before[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 백신 맞은 이후 조직
		after = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				after[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 완료

		visit = new boolean[N][M]; //방문 배열 초기화
		boolean tmp = compare();
		
		if(tmp) System.out.println("YES");
		else System.out.println("NO");
		
	}
	
	//백신 맞기 전, 후 배열 비교
	private static boolean compare() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(before[i][j] != after[i][j]) {
					visit[i][j] = true;
					boolean tmp = bfs(i, j);
					if(!tmp) return false; 
				}
			}
		}
		return true;
	}

	private static boolean bfs(int x, int y) {

		//bfs를 통해 before 배열을 바꿔야 함
		int newNum = after[x][y];
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			/* bfs 동작 방식 의문 - visit 처리가 안되는건가? */
//			System.out.println(cur);
//			
//			for(int i = 0; i<N; i++) {
//				for(int j = 0; j<M; j++) {
//					System.out.print(visit[i][j] + " ");
//				} System.out.println();
//			}
			
			for(int i = 0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx>= 0 && nx<N && ny>=0 && ny<M) { //경계선 체크
					if(!visit[nx][ny] && before[x][y] == before[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new Node(nx, ny));
						before[nx][ny] = newNum;
					}
				}
			}
		}
		before[x][y] = newNum;
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(before[i][j] != after[i][j]) return false;
			}
		}
		return true;
	}
}