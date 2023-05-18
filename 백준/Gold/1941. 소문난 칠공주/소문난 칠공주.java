import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Data {
		int x, y;
		char p;
		public Data(int x, int y, char p) {
			this.x = x;
			this.y = y;
			this.p = p;
		}
		@Override
		public String toString() {
			return "Data [x=" + x + ", y=" + y + ", p=" + p + "]";
		}
	}
	
	static int answer;
	static char[][] map;
	static Data[] picked;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		for(int i = 0; i<5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		//입력 완료
		
		picked = new Data[7];
		answer = 0;
		combination(0,0);
		
		System.out.println(answer);
	}
	
	//순서가 필요없음, 조합 돌리기
	private static void combination(int cnt, int start) {
		
		if(cnt == 7) {
			//조합 완성 시 찍어보기
//			System.out.println(Arrays.toString(picked));
//			System.out.println();

			if(check()) { //이다솜파 명 수 확인해서 true면
				bfs();//bfs 돌리기
			};

			return;
		}
		
		for(int i = start; i<25; i++) {
			int x = i/5;
			int y = i%5;
			
			picked[cnt] = new Data(x, y, map[x][y]);
			combination(cnt+1, i+1);
		}
		
		
	}
	
	//이다솜 파가 4명 이상이면 true 반환
	private static boolean check() {
		int cnt = 0;
		for(int i = 0; i<7; i++) {
			if(picked[i].p == 'S') cnt++;
		}
		
		if(cnt>=4) return true;
		else return false;
	}
	
	//서로 인접하는지 bfs 돌리기
	private static void bfs() {
		
		int cnt = 1;
		Queue<Data> q = new ArrayDeque<>();
		q.offer(picked[0]); //뽑힌 조합 중 맨 앞 값을 넣어줄거임

		visit = new boolean[5][5];
		visit[picked[0].x][picked[0].y] = true; //시작 지점 방문 체크
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
			
			for(int k = 0; k<4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				//경계선, 방문 체크
				if(nx>=0 && nx<5 && ny>=0 && ny<5 && !visit[nx][ny]) {
					for(int i = 0; i<7; i++) {
						if(picked[i].x==nx && picked[i].y==ny) {
							visit[nx][ny] = true;
							q.offer(new Data(nx, ny, 'S'));
							//새로운 클래스 만들기 귀찮으니까 임의의 S 넣기
							cnt++;
						}
					}
				}
			}
		}
		if(cnt == 7) answer++;
	}
 }