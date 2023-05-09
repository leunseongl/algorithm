import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static char[][] map;
	static boolean[][] visit;
	static Stack<Character> stack = new Stack<>();
	static int chain;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6];
		for(int i = 0; i<12; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}
		//입력 완료
		
		chain = 0; 
		game();
		System.out.println(chain);
		
	}
	
	private static void game() {
		
		boolean isOver = false;
		while(!isOver) {
			isOver = true;
			visit = new boolean[12][6];
			for(int i = 0; i<12; i++) {
				for(int j = 0; j<6; j++) {
					if(map[i][j] != '.') {
						if(bfs(i, j)) {
							isOver = false;
						}
					}
				}
			}
			if(!isOver) {
				down();
				chain++;
			}
		}
		
	}
	
	private static void down() {
		for(int i = 0; i<6; i++) {
			for(int j = 0; j<12; j++) {
				if(map[j][i] != '.') {
					stack.push(map[j][i]);
					map[j][i] = '.';
				}
			}
			int x = 11;
			while(!stack.isEmpty()) {
				map[x--][i] = stack.pop();
			}
		}
	}

	private static boolean bfs(int x, int y) {

		List<Node> bomb = new ArrayList<>();
		bomb.add(new Node(x, y));
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx>=0 && nx<12 && ny>=0 && ny<6) {
					if(!visit[nx][ny] && map[nx][ny] == map[cur.x][cur.y]) {
						visit[nx][ny] = true;
						bomb.add(new Node(nx, ny));
						q.offer(new Node(nx, ny));
					}
				}
			}
		}
		if(bomb.size()<4) {
			return false;
		}
		else {
			for(Node n: bomb) {
				map[n.x][n.y] = '.';
			}
			return true;
		}
	}
	
}