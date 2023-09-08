import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static int N, M, T, answer;
	static int[][] castle;
	static boolean[][][] visit;
	
	static class Data {
		int x, y, time, isFind; //isFind 그람이 없으면 0, 있으면 1
		public Data(int x, int y, int time, int isFind) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.isFind = isFind;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		castle = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			} 
		}
		//입력 완료
		
		answer = Integer.MAX_VALUE;
		visit = new boolean[N][M][2]; //그람 없으면 0, 있으면 1
		bfs();
		
		System.out.println(answer == Integer.MAX_VALUE? "Fail":answer);
	
	}
	
	private static void bfs() {
		
		visit[0][0][0] = true; //초기에는 그람 없음, 초기 위치 방문 체크
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(0,0,0,0));
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
			
			if(cur.x == N-1 && cur.y == M-1 && cur.time <= T) {
				answer = cur.time;
				return;
			}
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue; //경계선 컷
				if(castle[nx][ny] == 2) cur.isFind = 1; //그람 획득
				
				if(cur.isFind == 0) { //그람이 없는 경우
					if(!visit[nx][ny][0] && castle[nx][ny] == 0) {
						visit[nx][ny][0] = true;
						q.offer(new Data(nx, ny, cur.time+1, cur.isFind));
					}
				}
				
				else if(cur.isFind == 1) { //그람이 있는 경우
					if(!visit[nx][ny][1]) {
						visit[nx][ny][1] = true;
						q.offer(new Data(nx, ny, cur.time+1, cur.isFind));
					}
				}
				
			}
			
		}
		
	}

}