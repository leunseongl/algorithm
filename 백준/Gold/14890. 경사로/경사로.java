import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, L;
	static int[][] map;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for(int i = 0; i<N; i++) {
			if(make(i,0,0)) cnt++;
			if(make(0,i,1)) cnt++;
		}
		
		System.out.println(cnt);
		
	}

	//d = 0 행, d = 1 열
	private static boolean make(int x, int y, int d) {
		
		int[] tmp = new int[N];
		boolean[] visit = new boolean[N];
		
		for(int i = 0; i<N; i++) {
			tmp[i] = (d == 0) ? map[x][y+i] : map[x+i][y];
		}
		
		for(int i = 0; i<N-1; i++) {
			
			if(tmp[i] == tmp[i+1]) continue;
			
			if(Math.abs(tmp[i]-tmp[i+1]) > 1) return false;
			
			//이전 칸이 현재칸보다 1칸 큰경우
			if(tmp[i]-tmp[i+1] == 1) {
				for(int j = i+1; j<=i+L; j++) {
					if(j>=N || tmp[i+1] != tmp[j] || visit[j]) return false;
					visit[j] = true;
				}
			}
			
			//이전 칸이 현재칸보다 1칸 작은경우
			if(tmp[i]-tmp[i+1] == -1) {
				for(int j = i; j>i-L; j--) {
					if(j<0 || tmp[i] != tmp[j] || visit[j]) return false;
					visit[j] = true;
				}
			}
			
		}
		
		return true;
	}
}