import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int[][] lab;
	static boolean[][] visit;
	static int answer;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		answer = Integer.MAX_VALUE;
		virus(0, 0);
		
		System.out.println(answer==Integer.MAX_VALUE? -1:answer);
	}
	
	//바이러스 놓기 - 조합
	private static void virus(int start, int cnt) {
		
		if(cnt == M) {
			//조합 완성 시 bfs로
			int result = bfs();
			if(result != -1 && result<answer) {
				answer = result;
			}
			
//			for(int i = 0; i<N; i++) {
//				System.out.println(Arrays.toString(lab[i]));
//			} System.out.println();
			
			return;
		}
		
		for(int i = start; i<N*N; i++) {
			int x = i/N;
			int y = i%N;
			
			//바이러스를 놓을 수 있는 칸이면
			if(lab[x][y] == 2) {
				lab[x][y] = 3;
				virus(i+1, cnt+1);
				lab[x][y] = 2;
			}
		}
	}

	//바이러스 퍼트리기 - bfs
	private static int bfs() {
		
		//배열 복제
		int[][] copy = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				copy[i][j] = lab[i][j];
			}
		}
		
		int time = 0;
		visit = new boolean[N][N];
		Queue<Node> q = new ArrayDeque<>();
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(copy[i][j] == 3) { //바이러스인 곳 
					visit[i][j] = true; //방문 처리하고
					q.offer(new Node(i, j)); //큐에 넣기
				}
			}
		}
		
		while(!q.isEmpty()) {
			
			if(isEnd(copy)) {
				return time;
			}
			
			int size = q.size(); //레벨별 탐색을 위한 size
			while(size-- > 0) {
				Node cur = q.poll();
				
				for(int k = 0; k<4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					
					if(nx>=0 && nx<N && ny>=0 && ny<N) { //범위 체크
						if(copy[nx][ny] != 1 && !visit[nx][ny]) { //조건, 방문 체크
							copy[nx][ny] = 3;//copy에 바이러스 체크
							visit[nx][ny] = true;//방문 체크
							q.offer(new Node(nx, ny));//큐에 넣기
						}
					}
				}
				
			}
			time++;
		}
		return -1; //-1을 반환하면 모든 빈칸에 퍼트리지 못한 것
	}
	
	//모든 빈칸에 바이러스가 퍼트려졌는지 확인
	private static boolean isEnd(int[][] arr) {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				//하나라도 빈 칸이 있으면
				if(arr[i][j] == 0 || arr[i][j] == 2) return false;
			}
		}
		return true;
	}
}