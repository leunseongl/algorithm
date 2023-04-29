import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//0-북쪽 / 1-동쪽 / 2-남쪽 / 3-서쪽
//0이 빈칸, 1이 벽
public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int N, M;
	static int[][] map;
	static boolean[][] isCleaned;
	
	static class Cleaner {
		int x, y, dir;
		public Cleaner(int x, int y, int dir) {
			this.x = x; 
			this.y = y;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		Cleaner cleaner = new Cleaner(a,b,c);
		
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		isCleaned = new boolean[N][M];
		clean(cleaner);
		
		int res = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(isCleaned[i][j]) res++;
			}
		}
		System.out.println(res);
	}

	private static void clean(Cleaner cleaner) {
		
		//처음에 로봇청소기가 들어오는 곳부터 시작
		int x = cleaner.x;
		int y = cleaner.y;
		int nowDir = cleaner.dir;

		//동작이 중지할 때까지
		while(true) {
			
			//System.out.println("x: " + x +" y: " + y+ " dir: " + nowDir);
			
			//1. 현재 칸이 아직 청소되지 않은 경우, 청소
			if(!isCleaned[x][y]) isCleaned[x][y] = true;
			
			boolean flag = true; //인접 4칸 판단
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(map[nx][ny] == 1) continue; //멀까?
				if(!isCleaned[nx][ny]) { 
					flag = false;
				}
			}
			
			//2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			if(flag) {
				int[] arr = backDir(x, y, nowDir);
				int nextX = arr[0];
				int nextY = arr[1];
				
				if(map[nextX][nextY] == 0) {
					x = nextX;
					y = nextY;
					continue;
				} else if(map[nextX][nextY] == 1) { //벽이면 작동 멈춤
					return;
				}
			}
			
			//3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
			if(!flag) {
				nowDir = roateDir(nowDir);
				int[] arr = goDir(x, y, nowDir);
				int nextX = arr[0];
				int nextY = arr[1];
				
				if(map[nextX][nextY] == 0 && !isCleaned[nextX][nextY]) {
					x = nextX;
					y = nextY;
				}
				continue;
			}
			
		}
	}
	
	//현재 x, y, 방향을 인자로 받고, 방향마다 한 칸 후진 한 x, y 값 반환
	private static int[] backDir(int x, int y, int dir) {
		switch(dir) {
		case 0: 
			return new int[] {x+1, y};
		case 1:
			return new int[] {x, y-1};
		case 2: 
			return new int[] {x-1, y};
		case 3:
			return new int[] {x, y+1};	
		}
		return new int[] {0,0};
	}
	
	//반시계 방향으로 90도 회전해서 회전한 방향 반환
	private static int roateDir(int dir) {
		switch(dir) {
		case 0:
			return 3;
		case 1:
			return 0;
		case 2:
			return 1;
		case 3:
			return 2;
		}
		return 0;
	}
	
	//앞쪽 전진
	private static int[] goDir(int x, int y, int dir) {
		switch(dir) {
		case 0: 
			return new int[] {x-1, y};
		case 1:
			return new int[] {x, y+1};
		case 2: 
			return new int[] {x+1, y};
		case 3:
			return new int[] {x, y-1};	
		}
		return new int[] {0,0};
	}
}