import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	//상우하좌
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
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
	
	static int N,M,R,C,L;
	static int[][] map;
	static boolean[][] visit;
	static int[][] tunnel = new int[][] {
		{0,0,0,0}, //0
		{1,1,1,1}, //1
		{1,0,1,0}, //2
		{0,1,0,1}, //3
		{1,1,0,0}, //4
		{0,1,1,0}, //5
		{0,0,1,1}, //6
		{1,0,0,1}  //7
		}; 
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken()); //시작 x
			C = Integer.parseInt(st.nextToken()); //시작 y
			L = Integer.parseInt(st.nextToken()); //소요 시간
			
			map = new int[N][M];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료
			
			visit = new boolean[N][M];
			bfs();
			
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(visit[i][j]) cnt++;
				}
			}
			System.out.printf("#%d %d%n", tc, cnt);
		}
	}
	
	private static void bfs() {
		
		int time = 1;
		visit[R][C] = true;
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(R, C));
		
		while(true) {
			if(time == L) return;
			int size = q.size();
			
			while(size-->0) {
				Node cur = q.poll();
//				System.out.println(cur);
				
				for(int k = 0; k<4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					
					//경계선 , 터널인지, 방문 체크
					if(nx>=0 && nx<N && ny>=0 && ny<M && !visit[nx][ny] && map[nx][ny] != 0) {
						if(tunnel[map[cur.x][cur.y]][k] == 1 && tunnel[map[nx][ny]][(k+2)%4] == 1) {
							visit[nx][ny] = true;
							q.offer(new Node(nx, ny));
						}
					}
				}
			}
			time++;
		}
	}
}