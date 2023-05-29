import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Node {
		int x, y, var;
		public Node(int x, int y, int var) {
			this.x = x;
			this.y = y;
			this.var = var;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", var=" + var + "]";
		}
	}
	
	static int N,W,H,answer;
	static int[][] map;
	static int[][] copy;
	static int[] picked;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new int[W][H];
			for(int i = 0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<H; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료
			
			answer = Integer.MAX_VALUE;
			picked = new int[N];
			duplication(0);
			
			System.out.printf("#%d %d%n", tc, answer);
		}
	}
	
	//중복 순열
	private static void duplication(int cnt) {
		
		if(cnt == N) { //중복 순열이 완성되면 게임 시작
//			System.out.println(Arrays.toString(picked));
			game();
			return;
		}
		
		for(int i = 0; i<H; i++) {
			picked[cnt] = i;
			duplication(cnt+1);
		}
	}
	
	//게임 (bfs)
	private static void game() {
		
		copyArr(); //배열 복사
		
		Queue<Node> q = new ArrayDeque<>();
		for(int i = 0; i<N; i++) {
			int y = picked[i];
			for(int j = 0; j<W; j++) {
				if(copy[j][y] > 0) { //벽돌이면
					q.offer(new Node(j, y, copy[j][y])); //큐에 담고
					copy[j][y] = 0; //깨트리기
					break;
					}
				}
				
			while(!q.isEmpty()) {
				Node cur = q.poll();
				int range = cur.var; //영향 줄 범위
					
				for(int r = 1; r<range; r++) { //range-1 만큼 가기
					for (int k = 0; k < 4; k++) { // 그 방향으로
						int nx = cur.x + dx[k] * r;
						int ny = cur.y + dy[k] * r;
							
						if(nx<0 || nx>=W | ny<0 || ny>=H) continue;
							
						if(copy[nx][ny] > 0) { //벽돌이면
							q.offer(new Node(nx, ny, copy[nx][ny])); //큐에 담고
							copy[nx][ny] = 0; //깨트리기
						}
					}
				}
			}
			down(); //다음 구슬 떨어트리기 전 내리기
		}
		//모든 구슬 다 떨어트렸으면 개수 세기
		countBricks();
	}
	
	//배열 복사 메소드
	private static void copyArr() {
		copy = new int[W][H];
		for(int i = 0; i<W; i++) {
			for(int j = 0; j<H; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	//내리기
	private static void down() {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				if(copy[j][i] > 0) {
					stack.push(copy[j][i]);
					copy[j][i] = 0;
				}
			}
			
			int x = W-1;
			while(!stack.isEmpty()) {
				copy[x--][i] = stack.pop();
			}
		}
	}
	
	//벽돌 개수 세기
	private static void countBricks() {
		
		int cnt = 0;
		for(int i = 0; i<W; i++) {
			for(int j = 0; j<H; j++ ) {
				if(copy[i][j] > 0) cnt++;
			}
		}
		//System.out.println(cnt);
		answer = Math.min(answer, cnt);
	}
}