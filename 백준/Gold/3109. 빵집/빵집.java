import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,0,1};

	static int R,C,cnt;
	static char[][] map;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i<R; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}
		//입력 완료
		
		for(int i = 0; i<R; i++) {
			if(dfs(i,0)) cnt++;
		}
		
		System.out.println(cnt);
		
	}

	private static boolean dfs(int x, int y) {
		
		if(y==C-1) return true;
		
		for(int k = 0; k<3; k++) {
			int nx = x+dx[k];
			int ny = y+1;
			
			if(nx>=0 && nx<R && map[nx][ny]=='.') {
				map[nx][ny] = '-';
				if(dfs(nx, ny)) return true;
			}
		}
		return false;
	}
}
