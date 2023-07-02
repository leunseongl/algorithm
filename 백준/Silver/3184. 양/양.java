import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * . 빈 필드 / # 울타리 / o 양 / v 늑대
 * 수평, 수직으로 이동해서 다른 칸으로 이동할 수 있다면 두 칸은 같은 영역 (우리)
 * 탈출 할 수 있는 칸은 어떤 영역에도 속하지 않음
 * 영역 안의 양의 수가 늑대의 수보다 많으면 이기고, 늑대를 쫓아냄
 * 그렇지 않다면 그 영역 안의 모든 양이 늑대에게 먹힘
 * 아침에 살아남은 양과 늑대의 수를 출력
 */
public class Main {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static class Node {
		int x, y;
		char var;
		public Node(int x, int y, char var) {
			this.x = x;
			this.y = y;
			this.var = var;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", var=" + var + "]";
		}
	}
	
	static int R, C, S, W;
	static char[][] map;
	static boolean[][] visit; 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i<R; i++) {
			String line = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'o') S++; //전체 양 수
				else if(map[i][j] == 'v') W++; //전체 늑대 수
			}
		}
		
//		for(int i = 0; i<R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		//입력 완료
		
		visit = new boolean[R][C];
		for(int i = 1; i<R-1; i++) { //가장자리 제외하고 돌리기
			for(int j = 1; j<C-1; j++) {
				if(map[i][j]!='#' && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(S + " " + W);
		
	}
	
	//영역을 나누고 영역 내 양과 늑대 수를 세는 bfs 함수
	private static void bfs(int x, int y) {
		
		int sheep = 0;
		int wolf = 0;
		
		visit[x][y] = true; //시작 부분 방문 처리
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y, map[x][y]));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(map[cur.x][cur.y] == 'o') sheep++;
			else if(map[cur.x][cur.y] == 'v') wolf++;
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<R && ny>=0 && ny<C) {
					if(map[nx][ny] != '#' && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new Node(nx, ny, map[nx][ny]));
					}
				}
			}
		}
		
		//여기서 양, 늑대 수 따져서 계산
		//System.out.println("양 수 " + sheep + " " + "늑대 수 " + wolf);
		if(sheep>wolf) W -= wolf;
		else S -= sheep;
	}

}