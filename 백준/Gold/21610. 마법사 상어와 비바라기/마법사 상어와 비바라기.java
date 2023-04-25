import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	static int[] dx2 = {-1,-1,1,1,};
	static int[] dy2 = {-1,1,1,-1};
	
	static class Cloud {
		int x, y;
		public Cloud(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Cloud> clouds = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//구름 위치 초기화
		clouds.add(new Cloud(N-2, 0));
		clouds.add(new Cloud(N-2, 1));
		clouds.add(new Cloud(N-1, 0));
		clouds.add(new Cloud(N-1, 1));

		visit = new boolean[N][N];
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken())-1; //방향
			int s = Integer.parseInt(st.nextToken()); //칸 개수
			
			move(d, s);
			copy();
			makeCloud();
			
		}
		
		int answer = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				answer +=map[i][j];
			}
		}
		
		System.out.println(answer);
	}

	//이동 후 물의 양 1씩 증가
	private static void move(int d, int s) {
		//구름 이동
		for(Cloud cur : clouds) {
			cur.x = (N + cur.x + dx[d] * (s % N)) % N;
			cur.y = (N + cur.y + dy[d] * (s % N)) % N;
			map[cur.x][cur.y]++; //물의 양 증가
		}	
	}

	//구름 삭제, 물 복사 버그 마법
	private static void copy() {

		while(!clouds.isEmpty()) {
			Cloud cur = clouds.poll();
			visit[cur.x][cur.y] = true;
			
			int count = 0; //대각선에 있는 바구니 수 세기
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx2[k];
				int ny = cur.y + dy2[k];
				
				//범위 안에 있고 0이 아니라면
				if(isRange(nx, ny) && map[nx][ny] > 0) count++;
			}
			map[cur.x][cur.y]+=count;
		}
	}
	
	private static boolean isRange(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) return false;
		return true;
	}
	
	//구름 만들기
	private static void makeCloud() {

		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] >= 2 && !visit[i][j]) {
					clouds.add(new Cloud(i, j));
					map[i][j] -= 2;
				}
			}
		}
		visit = new boolean[N][N];
	}
}