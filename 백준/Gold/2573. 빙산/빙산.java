import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	//0개수 세서 녹이기용
	static class Info {
		int x, y, sea;
		
		public Info(int x, int y, int sea) {
			this.x = x;
			this.y = y;
			this.sea = sea;
		}
	}
	
	//bfs용
	static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int N, M;
	static int[][] map;
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
			
			if(isZero()) { //모두 녹았을 경우
				System.out.println(0);
				break;
			}
			
			year++;
			List<Info> list = seaCount();
			melt(list);
			int lump = bfs();
			
			if(lump > 1) {
				System.out.println(year);
				break; //덩어리가 1보다 클 경우 break
			}
		}
		
	}
	
	//인접 바다(0) 개수 세기
	private static List<Info> seaCount() {
		List<Info> list = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] != 0) {
					int count = 0; //인접 바다 개수 
					for(int k = 0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(map[nx][ny] == 0) count++;
					}
					list.add(new Info(i, j, count));
				}
			}
		}
		
		return list;
	}
	
	//녹이기
	private static void melt(List<Info> list) {
		for(int i = 0; i<list.size(); i++) {
			Info tmp = list.get(i);
			if(map[tmp.x][tmp.y] - tmp.sea <= 0) map[tmp.x][tmp.y] = 0;
			else map[tmp.x][tmp.y] = map[tmp.x][tmp.y] -= tmp.sea;
		}
	}
	
	//덩어리 탐색
	private static int bfs() {
		int lump = 0; //덩어리 개수
		boolean[][] visit = new boolean[N][M]; //방문 처리
		
		Queue<Node> q = new ArrayDeque<>();
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] != 0 && !visit[i][j]) {
					q.offer(new Node(i, j));
					visit[i][j] = true;
					lump++;
					
					while(!q.isEmpty()) {
						Node cur = q.poll();
						
						for(int k = 0; k<4; k++) {
							int nx = dx[k] + cur.x;
							int ny = dy[k] + cur.y;
							
							if(nx>=0 && nx<N && ny>=0 && ny<M && !visit[nx][ny] && map[nx][ny]!=0) {
								visit[nx][ny] = true;
								q.offer(new Node(nx, ny));
							}
						}
					}
				}
			}
		}
		return lump;
	}
	
	//모두 녹았는지를 판단하는 메서드
	private static boolean isZero() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] != 0) return false;
			}	
		}
		return true;
	}
}