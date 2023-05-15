import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	//상, 우, 우상 방향
	static int[] dx = {-1,0,-1};
	static int[] dy = {0,-1,-1};
	
	static class Warm {
		int value, diff;
		public Warm(int value, int diff) {
			this.value = value;
			this.diff = diff;
		}
		@Override
		public String toString() {
			return "Warm [value=" + value + ", diff=" + diff + "]";
		}
	}
	
	static int M,N;
	static Warm[][] map;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new Warm[M][M];
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<M; j++) {
				map[i][j] = new Warm(1, 0);
			}
		}
		//초기화: 첫째 날 값은 1, 자라난 양은 0으로 
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			edgeGrow(zero, one, two);//가장자리 자라기
			remainGrow(zero, one, two); //나머지 자라기
		}
		
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<M; j++) {
				System.out.print(map[i][j].value + " ");
			}
			System.out.println();
		}
		
		
	}

	//가장자리 자라기
	private static void edgeGrow(int zero, int one, int two) {
		
		for(int i = M-1; i>=0; i--) {
			if(zero>0) { //0이 남았으면
				map[i][0].value += 0;
				map[i][0].diff = 0;
				zero--;
			}
			else if(one>0) { //1이 남았으면
				map[i][0].value += 1;
				map[i][0].diff = 1;
				one--;
			}
			else if(two>0) { //2가 남았으면
				map[i][0].value += 2;
				map[i][0].diff = 2;
				two--;
			}
		}
		//왼쪽 아래부터 -> 왼쪽 위 끝까지
		for(int i = 1; i<M; i++) {
			if(zero>0) {
				map[0][i].value += 0;
				map[0][i].diff = 0;
				zero--;
			}
			else if(one>0) {
				map[0][i].value += 1;
				map[0][i].diff = 1;
				one--;
			}
			else if(two>0) {
				map[0][i].value += 2;
				map[0][i].diff = 2;
				two--;
			}
		}
		//왼쪽 위부터 -> 오른쪽  끝까지
	
	}
	
	//나머지 자라기
	private static void remainGrow(int zero, int one, int two) {
		
		int dist = M-1;
		for(int s = 1; s<M; s++) { //시작점
			int i = s;
			int j = s;
			int grow = findBest(i, j);
			map[i][j].value += grow;
			map[i][j].diff = grow;
			
			for(int d = 0; d<dist-1; d++) {
				i++;
				grow = findBest(i, j);
				map[i][j].value += grow;
				map[i][j].diff = grow;
				
				grow = findBest(j, i);
				map[j][i].value += grow;
				map[j][i].diff = grow;
				
			}
			dist--;
		}
	}
	
	//가장 많이 자란 곳 찾기
	private static int findBest(int x, int y) {
		
		int big = -1;
		//System.out.println(x + " " + y);
		for(int k = 0; k<3; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(map[nx][ny].diff>big) big = map[nx][ny].diff; 
		}
		return big;
	}
	
}