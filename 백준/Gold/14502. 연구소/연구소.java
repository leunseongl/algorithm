import java.io.*;
import java.util.*;


public class Main {
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static int n,m;
	static int[][] arr;
	static int res = Integer.MIN_VALUE;
	
	static class xy {
		int x;
		int y;
		xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void wall(int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(cnt+1);
					arr[i][j] = 0;
					
				}
			}
		}
	}
	
	public static void bfs() {
		int[][] copy = new int[n][m];

		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		
		Queue<xy> q = new LinkedList<>();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(copy[i][j] == 2) {
					q.add(new xy(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			xy z = q.poll();
			
			for(int k = 0; k<4; k++) {
				int nx = dx[k] + z.x;
				int ny = dy[k] + z.y;
				
				if(nx>=0 && nx<n && ny>=0 && ny<m && copy[nx][ny] == 0) {
					q.offer(new xy(nx, ny));
					copy[nx][ny] = 2;
				}
			}
		}
		
		int tmp = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(copy[i][j] == 0) tmp++;
			}
		}
		
		res = Math.max(tmp, res);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer nm = new StringTokenizer(br.readLine());
		n = Integer.parseInt(nm.nextToken());
		m = Integer.parseInt(nm.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		wall(0);
		System.out.println(res);	
		
	}
}