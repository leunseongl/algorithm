import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] paper;
	static int cnt;
	static List<Integer> result = new ArrayList<>();
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(paper[i][j] == 1) {
					cnt = 1;
					BFS(i, j);
					result.add(cnt);
				}
			}
		}
		
		if(result.size() > 0) {
			System.out.println(result.size());
			System.out.println(Collections.max(result));
		}
		else {
			System.out.println(0);
			System.out.println(0);
		}
		
	}
	
	private static void BFS(int x, int y) {
		
		paper[x][y] = 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			for(int k = 0; k<4; k++) {
				int nx = dx[k] + tmp.x;
				int ny = dy[k] + tmp.y;
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && paper[nx][ny] == 1) {
					paper[nx][ny] = 0;
					cnt++;
					q.offer(new Node(nx, ny));
				}
				
			}
			
		}
		
	}

}