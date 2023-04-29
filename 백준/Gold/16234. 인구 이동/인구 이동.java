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
	
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, L, R;
	static int[][] map;
	static boolean[][] visit;
	static List<Node> list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //N×N
		L = Integer.parseInt(st.nextToken()); //인구 차이가 L명 이상
		R = Integer.parseInt(st.nextToken()); //R명 이하
		
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		System.out.println(open());
	}
	
	private static int open() {
		
		int day = 0;
		
		while(true) {
			boolean flag = false;
			visit = new boolean[N][N];
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(!visit[i][j]) {
						int sum = bfs(i, j);
						
						if(list.size() > 1) {
							flag = true;
							move(sum);
						}
					}
				}
			}
			if(!flag) return day;
			day++;
		}
		
	}

	private static void move(int sum) {
		for(Node n:list) {
			map[n.x][n.y] = sum/list.size();
		}
	}

	private static int bfs(int x, int y) {

		visit[x][y] = true;
		int sum = map[x][y];
		
		list = new ArrayList<>();
		list.add(new Node(x, y));
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny]) {
					int tmp = Math.abs(map[nx][ny] - map[cur.x][cur.y]);
					if(L<=tmp && tmp<=R) {
						visit[nx][ny] = true;
						sum += map[nx][ny];
						list.add(new Node(nx, ny));
						q.offer(new Node(nx, ny));
					}
				}
			}
		}
		return sum;
	}
	
}