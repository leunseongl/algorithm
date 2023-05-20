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
		int x, y, time;
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", time=" + time + "]";
		}
	}
	
	static int N, sx, sy, ex, ey, answer;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			//입력 완료
			
			answer = -1;
			visit = new boolean[N][N];
			bfs();
			
			System.out.printf("#%d %d%n", tc, answer);
		}
		
	}
	
	private static void bfs() {
		
		visit[sx][sy] = true;
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(sx, sy, map[sx][sy]));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			//기저 조건
			if(cur.x == ex && cur.y == ey) {
				answer = cur.time;
				return;
			}
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny]) {	
					if(map[nx][ny]==0) { //지나갈 수 있는 곳
						visit[nx][ny] = true;
						q.offer(new Node(nx, ny, cur.time+1));
					}
					else if(map[nx][ny] == 2) { //소용돌이
						if(cur.time%3 == 2) { //현재 시간이 갈 수 있는 시간이면
							visit[nx][ny] = true; //다음 곳으로 이동
							q.offer(new Node(nx, ny, cur.time+1));
						}
						else { //현재 시간이 못가는 시간이면 
							q.offer(new Node(cur.x, cur.y, cur.time+1)); //현재 위치에서 시간만 +1
						}
					}
					
				}
				
			}
			
			
		}
		
	}
	
}