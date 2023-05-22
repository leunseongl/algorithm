import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}
	
	static class Island {
		int x, y, cnt;
		public Island(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int islandIdx = 1;
	static int minDistance = Integer.MAX_VALUE;
	static int start;
	static Node end;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		visit = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					map[i][j] = islandIdx; //섬에 번호 붙이기
					makeIsland(i, j);
					islandIdx++;
				}
			}
		}
		//섬 연결, 번호 붙이기 완료
		
		for(int i = 1; i<islandIdx; i++) {
			buildBridge(i);
		}
		//다리 짓기
		
		System.out.println(minDistance);
		
		//System.out.println("start " + start);
		//System.out.println("end " + end);
		
		
	}
	
	//섬 연결 용 bfs
	private static void makeIsland(int x, int y) {
		
		visit[x][y] = true;
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				//경계선 체크
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					//방문하지 않았고, 거기도 섬이면
					if(!visit[nx][ny] && map[nx][ny] == 1) {
						visit[nx][ny] = true;
						map[nx][ny] = islandIdx;
						q.offer(new Node(nx, ny));
					}
				}
			}
		}
	}
	
	//다리 짓기용 bfs
	private static void buildBridge(int islandNum) {
		
		boolean[][] bVisit = new boolean[N][N];
		Queue<Island> q = new ArrayDeque<>();
		
		//해당 섬 큐에 다 넣기
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == islandNum) {
					q.offer(new Island(i, j, 0));
					bVisit[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Island cur = q.poll();
						
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				
				//다른 섬의 가장자리를 만나면
				if(map[nx][ny] != islandNum && map[nx][ny] > 0) {
					minDistance = Math.min(minDistance, cur.cnt);
					return;
				}
				
				//아니면 bfs 탐색 계속
				if(!bVisit[nx][ny]) {
					bVisit[nx][ny] = true;
					q.offer(new Island(nx, ny, cur.cnt+1));
				}
			}
		}
	}
}
