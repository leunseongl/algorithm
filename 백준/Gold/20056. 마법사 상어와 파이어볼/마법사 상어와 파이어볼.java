import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static int[] arr1 = {0,2,4,6};
	static int[] arr2 = {1,3,5,7};
	static class Fireball {
		int x, y, mass, speed, dir;
		public Fireball(int x, int y, int mass, int speed, int dir) {
			this.x = x;
			this.y = y;
			this.mass = mass;
			this.speed = speed;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "Fireball [x=" + x + ", y=" + y + ", mass=" + mass + ", speed=" + speed + ", dir=" + dir + "]";
		}
	}
	
	static int N, M, K;
	static List<Fireball> balls;
	static List<Fireball> map[][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //파이어볼 개수
		K = Integer.parseInt(st.nextToken()); //이동 횟수
		
		map = new ArrayList[N+1][N+1];
		//Fireball 리스트를 담는 2차원 배열 초기화
		for(int i = 0; i<N+1; i++) {
			for(int j = 0; j<N+1; j++) {
				map[i][j] = new ArrayList<Fireball>();
			}
		}
		
		balls = new ArrayList<>();
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			map[r][c].add(new Fireball(r, c, m, s, d));
			balls.add(new Fireball(r, c, m, s, d));
		}
		//입력 완료
		
		while(K-->0) {
			move();
			checkAndCombine();
		}

		//System.out.println(balls);
		int result = 0;
		for(Fireball f: balls) {
			result += f.mass;
		}
		
		System.out.println(result);
	}
	
	//파이어볼 이동
	private static void move() {
		
		//모두 이동시킬 거기 때문에 초기화
		for(int i = 0; i<N+1; i++) {
			for(int j = 0; j<N+1; j++) {
				map[i][j].clear();
			}
		}
		
		for(Fireball f : balls) {
			f.x = (N + f.x + dx[f.dir] * (f.speed % N)) % N;
			f.y = (N + f.y + dy[f.dir] * (f.speed % N)) % N;
			
			map[f.x][f.y].add(f);
		}
		
	}
	
	//겹치는지 확인하고 합치기
	private static void checkAndCombine() {
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				
				if(map[i][j].size() > 1) { //겹치는 경우
					
					int massSum = 0; //질량의 합을 담을 변수
					int speedSum = 0; //속력의 합을 담을 변수
					boolean isOdd = true; //모두 홀수인지 판단 
					boolean isEven = true; //모두 짝수인지 판단
				
					//모든 애들 더하기
					for(int k = 0; k<map[i][j].size(); k++) {
						balls.remove(map[i][j].get(k)); //balls에서 겹치는 애 삭제
						massSum += map[i][j].get(k).mass;
						speedSum += map[i][j].get(k).speed;
						if(map[i][j].get(k).dir%2 == 0) isOdd = false;
						if(map[i][j].get(k).dir%2 != 0) isEven = false;
					}
					
					//나눈 질량이 0이 된 경우 소멸
					if(massSum/5 <= 0) continue;
					int newMass = massSum/5;
					int newSpeed = speedSum/map[i][j].size();
					for(int k = 0; k<4; k++) {
						if(isOdd || isEven) { //모두 홀수거나 짝수면 -> 방향  0,2,4,6
							balls.add(new Fireball(i, j, newMass, newSpeed, arr1[k]));
						}
						else { //아니면 -> 방향 1,3,5,7
							balls.add(new Fireball(i, j, newMass, newSpeed, arr2[k]));
						}
					}
				}
			}
		}
	}
}