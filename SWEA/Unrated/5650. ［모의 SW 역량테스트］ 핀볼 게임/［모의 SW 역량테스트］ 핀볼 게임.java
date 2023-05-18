import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	//상좌하우
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static class Pinball {
		int x, y, d;
		public Pinball(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Pinball [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
	}
	
	static int N, answer;
	static int[][] map;
	static Pinball ball;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//입력 완료
			
			answer = Integer.MIN_VALUE;
			for(int i = 0; i<N; i++) { //x
				for(int j = 0; j<N; j++) { //y
					if(map[i][j] == 0) { //빈공간이면 
						for(int k = 0; k<4; k++) { //4방향 전부 돌려보기
							ball = new Pinball(i, j, k);
							int result = game(i, j);
							//System.out.println(result);
							answer = Math.max(answer, result);
						}
					}
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
		}
		
	}
	
	//게임 시뮬레이션, 점수 반환
	private static int game(int sx, int sy) {
		
		int score = 0; //현재 게임 점수 저장
		while(true) {
			
			//System.out.println(ball);
			
			//먼저 이동
			ball.x += dx[ball.d];
			ball.y += dy[ball.d];

			//이동 한 곳이 벽인 경우
			if(ball.x<0 || ball.x>=N || ball.y<0 || ball.y>=N) {
				ball.d = wall(ball.d);
				score++;
				continue; //변경된 방향으로 이동할 수 있게 continue 처리
			}
			
			//다음 위치가 시작 위치면 게임 종료
			if(ball.x == sx && ball.y == sy) {
				return score;
			}
			
			//다음으로 갈 곳이 블랙홀이면 게임 종료
			if(map[ball.x][ball.y] == -1) {
				return score;
			}
			
			//이동 한 곳이 블록 인 경우
			if(1<=map[ball.x][ball.y] && map[ball.x][ball.y]<=5) {
				int var = map[ball.x][ball.y]; //몇 번 블록인지
				ball.d = block(var, ball.d);
//				ball.x = ball.x + dx[ball.d];
//				ball.y = ball.y + dy[ball.d];
				score++;
			}
			
			//이동 한 곳이 웜홀 인 경우
			if(6<=map[ball.x][ball.y] && map[ball.x][ball.y]<=10) {
				int var = map[ball.x][ball.y]; //몇번 웜홀인지
				int[] res = wormhole(var);
				ball.x = res[0];
				ball.y = res[1];
				//continue;
			}
		}
	}
	
	//벽
	private static int wall(int dir) {
		if(dir == 0) return 2;
		else if(dir == 1) return 3;
		else if(dir == 2) return 0;
		else if(dir == 3) return 1;
		return -1;
	}
	
	//블록 (방향을 중심으로 잡아야 하나, 블록을 중심으로 잡아야 하나)
	private static int block(int num, int d) {
		
		if(num == 1) { //1번 블록
			if(d == 2) return 3; //상 -> 하
			else if(d == 3) return 1; //우 -> 좌
			else if(d == 0) return 2; //하 -> 우
			else if(d == 1) return 0; //좌 -> 상
		}
		
		else if(num == 2) { //2번 블록
			if(d == 0) return 3; //하 -> 상
			else if(d == 3) return 1; //우 -> 좌
			else if(d == 2) return 0; //상 -> 우
			else if(d == 1) return 2; //좌 -> 하
		}
		
		else if(num == 3) { //3번 블록
			if(d == 0) return 1; //하 -> 상
			else if(d == 1) return 3; //좌 -> 우
			else if(d == 2) return 0; //상 -> 좌
			else if(d == 3) return 2;//우 -> 하
		}
		
		else if(num == 4) { //4번 블록
			if(d == 1) return 3; //좌 -> 우
			else if(d == 2) return 1; //상 -> 하
			else if(d == 0) return 2; //하 -> 좌
			else if(d == 3) return 0; //우 -> 상
		}
		
		else if(num == 5) { //5번 블록
			if(d == 0) return 2; //하 -> 상
			else if(d == 1) return 3; //좌 -> 우
			else if(d == 2) return 0; //상 -> 하
			else if(d == 3) return 1; //우 -> 좌
		}
		return -1;
	}
	
	//웜홀
	private static int[] wormhole(int num) {
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == num) { //현재 웜홀과 같은 번호 웜홀인데
					if(i != ball.x || j != ball.y) { //현재 위치와 같지 않으면
						return new int[] {i, j};
					}
				}
			}
		}
		return new int[] {0, 0};
	}
}