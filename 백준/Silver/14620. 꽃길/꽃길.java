import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static int N, answer;
	static int[][] garden;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		garden = new int[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		answer = Integer.MAX_VALUE;
		visit = new boolean[N][N];
		dfs(0,0);
		
		System.out.println(answer);
	}
	
	private static void dfs(int flower, int cost) {
		
		if(flower == 3) {
			answer = Math.min(answer, cost); //가격 비교
			return;
		}
		
		for(int i = 1; i<N-1; i++) {
			for(int j = 1; j<N-1; j++) {
				 
				if(isPossible(i, j)) { //꽃잎 놓을 수 있으면	 
					 visit[i][j] = true;
					 
					 for(int k = 0; k<4; k++) {
						 int nx = i+dx[k];
						 int ny = j+dy[k];
						 visit[nx][ny] = true;
					 }
					 
					 int tmp = howMuch(i, j);
					 dfs(flower+1, cost+tmp);
					 
					 visit[i][j] = false;
					 
					 for(int k = 0; k<4; k++) {
						 int nx = i+dx[k];
						 int ny = j+dy[k];
						 visit[nx][ny] = false;
					 }
					 
				 }
			}
		}
		
	}
	
	//꽃잎 놓을 수 있는지 판별
	private static boolean isPossible(int x, int y) {
		
		if(visit[x][y]) return false; //방문 체크 되어있으면 false
		
		for(int k = 0; k<4; k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			if(visit[nx][ny]) return false;
		}
		
		return true;
	}
	
	//비용 계산
	private static int howMuch(int x, int y) {
		int tmp = 0;
		
		tmp += garden[x][y];
		
		for(int k = 0; k<4; k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			tmp += garden[nx][ny];
		}
		
		return tmp;
	}

}