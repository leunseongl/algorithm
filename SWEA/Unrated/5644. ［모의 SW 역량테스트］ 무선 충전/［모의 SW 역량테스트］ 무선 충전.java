import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	//고정,상,우,하,좌
//	static int[] dx = {0,-1,0,1,0};
//	static int[] dy = {0,0,1,0,-1};
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0};
	
	static class BC {
		int x, y, range, power;
		public BC(int x, int y, int range, int power) {
			this.x = x;
			this.y = y;
			this.range = range;
			this.power = power;
		}
		@Override
		public String toString() {
			return "BC [x=" + x + ", y=" + y + ", range=" + range + ", power=" + power + "]";
		}
	}
	
	static class User {
		int x, y;
		public User(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "User [x=" + x + ", y=" + y + "]";
		}
	}
	
	static int M,A,answer;
	static int[] dirA;
	static int[] dirB;
	static BC[] info;
	static User userA, userB;
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //총 이동시간
			A = Integer.parseInt(st.nextToken()); //bc의 개수
			
			dirA = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) {
				dirA[i] = Integer.parseInt(st.nextToken());
			}
			
			dirB = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) {
				dirB[i] = Integer.parseInt(st.nextToken());
			}
			
			info = new BC[A]; //bc 정보
			for(int i = 0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				info[i] = new BC(a,b,c,d);
			}
			//입력 완료
			
			answer = 0;
			
			//사용자들 초기 위치
			userA = new User(1, 1);
			userB = new User(10, 10);
			charge(); //초기위치 충전
			
			for(int i = 0; i<M; i++) {
				move(i); //사용자 이동
				//System.out.println("시간 " + i);
				//System.out.println(userA);
				//System.out.println(userB);
				charge(); //충전
			}
			System.out.printf("#%d %d%n", tc, answer);
		}
	}
	
	//사용자 이동 메소드
	private static void move(int dir) {
		int aDir = dirA[dir]; //a 이동 방향
		int bDir = dirB[dir]; //b 이동 방향
		
		userA.x += dx[aDir];
		userA.y += dy[aDir];
		userB.x += dx[bDir];
		userB.y += dy[bDir];
	}
	
	//현재 위치 충전 메소드
	private static void charge() {
		//현재 위치에서 사용자 a, b가 갈 수 있는 bc 담는 리스트
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();
		
		//모든 bc 다 돌기
		for(int i = 0; i<A; i++) {
			int c = info[i].range; //현재 bc의 충전 범위
			
			//userA
			if(c>=Math.abs(userA.x-info[i].x)+Math.abs(userA.y-info[i].y)) {
				listA.add(i); //현재 bc의 인덱스 넣어주기
			}
			
			//userB
			if(c>=Math.abs(userB.x-info[i].x)+Math.abs(userB.y-info[i].y)) {
				listB.add(i); //현재 bc의 인덱스 넣어주기
			}
		}
		
		int max = 0; //현재 칸에서 구할 수 있는 최대 충전량
		//a, b 모두 충전 할 수 있는 bc 존재, 겹칠 가능성 있음
		if(listA.size()>0 && listB.size()>0) {
			//System.out.println("1번");
			for(int a : listA) {
				for(int b : listB) {
					int tmp = 0;
					if(a==b) { //겹치면
						tmp = info[a].power;
					}
					else { //겹치지 않으면
						tmp += info[a].power;
						tmp += info[b].power;
					}
					max = Math.max(tmp, max);
				}
			}
		}
		
		//a만 충전할 수 있는 bc가 존재할 때
		else if(listA.size()>0) {
			//System.out.println("2번");
			for(int a : listA) {
				if(info[a].power>max) max = info[a].power;
			}
		}
		
		//b만 충전할 수 있는 bc가 존재할 때
		else if(listB.size()>0) {
			//System.out.println("3번");
			for(int b : listB) {
				if(info[b].power>max) max = info[b].power;
			}
		}
		//System.out.println(max);
		answer += max; //정답에 현재 칸의 최댓 값 더해주기
	}
}