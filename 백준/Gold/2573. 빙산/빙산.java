import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Iceberg {
		int x, y, cnt;
		public Iceberg(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Iceberg [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		int year = 0;
		while(true) {
			if(isZero()) {
				System.out.println(0);
				break;
			}
			year++;

			melt(); //녹이기
			
			visit = new boolean[N][M];
			
			int count = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(map[i][j] > 0 && !visit[i][j]) {
						count++;
						visit[i][j] = true;
						dfs(i, j);
					}
				}
			}
			
			if(count>=2) {
				System.out.println(year);
				break;
			}
		}
	}
	
	private static void melt() {
		
		List<Iceberg> list = new ArrayList<>();
		
		//녹일 애들 저장
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] > 0) { //빙산이면
					int count = 0;
					
					for(int k = 0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						
						if(map[nx][ny] == 0) count++;
					}
					list.add(new Iceberg(i, j, count));
				}
			}
		}
		
		//녹이기
		for(int i = 0; i<list.size(); i++) {
			Iceberg cur = list.get(i);
			if(map[cur.x][cur.y] - cur.cnt <= 0) map[cur.x][cur.y] = 0;
			else map[cur.x][cur.y] -= cur.cnt;
		}
	}
	
	//dfs
	private static void dfs(int x, int y) {
		
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<N && ny>=0 && ny<M) {
				if(!visit[nx][ny] && map[nx][ny] != 0) {
					visit[nx][ny] = true;
					dfs(nx, ny);
				}
			}
		}
		
	}
	
	private static boolean isZero() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] != 0) return false;
			}
		}
		return true;
	}
	
}