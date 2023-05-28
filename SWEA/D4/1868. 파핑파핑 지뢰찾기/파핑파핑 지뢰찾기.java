import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	//8방향
	static int[] dx = {-1,0,1,0,-1,1,-1,1};
	static int[] dy = {0,-1,0,1,1,1,-1,-1};
	
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static char[][] map;
	static int[][] count;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new char[N][N];
			for(int i = 0; i<N; i++) {
				String line = br.readLine();
				map[i] = line.toCharArray();
			}
			//입력 완료
			
			count = new int[N][N];
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(map[i][j] == '.') check(i,j);
				}
			}
			//근처 지뢰 개수 세기
 
			int click = 0;
			visit = new boolean[N][N];
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(map[i][j] == '.' && count[i][j] == 0 && !visit[i][j]) { //빈칸이면서 주위에 지뢰가 없는 곳
						//System.out.println("0개 " + i + " " + j);
						click++;
						bfs(i, j);
					}
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(!visit[i][j] && map[i][j] == '.') { //방문하지 않은 빈칸이면
						//System.out.println(i + " " + j);
						click++;
					}
				}
			}
			System.out.printf("#%d %d%n", tc, click);
		}
	}

	//지뢰 개수 세는 메서드
	private static void check(int x, int y) {
		
		int tmp = 0;
		for(int k = 0; k<8; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			if(map[nx][ny] == '*') tmp++;
		}
		count[x][y] = tmp;
	}
	
	private static void bfs(int x, int y) {
		
		visit[x][y] = true;
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int k = 0; k<8; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N) { //경계선 조건
					if(!visit[nx][ny] && map[nx][ny] == '.') { //방문하지 않은 빈칸이면
						if(count[nx][ny] == 0) { //연쇄일 땐(주변 지뢰 개수가 0인애라면)
							q.offer(new Node(nx, ny)); //큐에 넣어주기
						}
						visit[nx][ny] = true; //방문처리
					}
				}
			}
		}
		
	}
}