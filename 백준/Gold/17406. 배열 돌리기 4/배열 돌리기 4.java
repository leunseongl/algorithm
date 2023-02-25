import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//배열 A의 값은 각 행에 있는 모든 수의 합 중 최솟값
//r,c,s -> (r-s, c-s)부터 (r+s, c+s)까지 범위

/* 회전 프로세스 */
//1. 시작점, 한 번에 몇 개가 회전을 해야하는지 찾기
//Math.min((r+s)-(r-s)+1, (c+s)-(c-s)+1)/2

public class Main {
	
	//하우상좌, 그릴 때 내 손이 나아가는 방향
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static int N, M, K;
	static int answer = Integer.MAX_VALUE; //정답
	static int[][] origin; //원본 배열
	static int[][] map; //실제 회전할 배열 (copy된 배열)
	
	static Rotation[] rotation; //회전 정보 (Rotation클래스 배열)
	static boolean[] isSelected; //회전 정보 선택 여부 체크
	static Rotation[] selected; //조합된 회전 정보
	
	//회전 정보 클래스
	static class Rotation {
		int r, c, s; 
		public Rotation(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		origin = new int[N+1][M+1];
		rotation = new Rotation[K];
		isSelected = new boolean[K];
		selected = new Rotation[K];
		
		//맵 정보 입력
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//회전 정보 입력
		for(int i = 0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			rotation[i] = new Rotation(r, c, s);
		}
		
		permutation(0);
		
		System.out.println(answer);		
	}
	
	private static void permutation(int cnt) {
		
		//1. 회전 연산 순서 정하기 완료
		if(cnt == K) {
			copyArray();
			
			//2. 회전 순서대로 배열 회전
			for(int i = 0; i<K; i++) {
				rotate(selected[i]);
			}
			
			//3. 해당 배열의 최솟값 구해서 최솟값 갱신
			answer = Math.min(calcMin(), answer);
			return;
		}
		
		for(int i = 0; i<K; i++) {
			if(isSelected[i]) continue;
			
			//조합 채워나가기
			selected[cnt] = rotation[i];
			
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}

	//회전 정보를 받아서 1회 로테이션
	private static void rotate(Rotation rot) {
		
		for(int i = 1; i<=rot.s; i++) {
			
			//시작점(왼쪽 상단의 꼭지점)
			int x = rot.r - i;
			int y = rot.c - i;
			
			//첫째 값 담아두기
			int tmp = map[x][y]; 
			int dir = 0;
			
			//4번 회전하게 되면 끝냄
			while(dir<4) {
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				
				//테두리 벗어나지 않으면
				if(nx>=rot.r-i && nx<=rot.r+i && ny>=rot.c-i && ny<=rot.c+i) {
					
					//값 당겨오기
					map[x][y] = map[nx][ny];
					
					//이름
					x = nx; 
					y = ny;
				}
				else dir++;
			}
			
			//시작점 바로 오른쪽에 tmp 값 담기
			map[x][y+1] = tmp;
			
		}
	}
	
	//배열 복사
	private static void copyArray() {
		map = new int[N+1][];
		for(int i = 1; i<=N; i++) {
			map[i] = origin[i].clone();
		}
	}
	
	//배열의 최솟값 반환
	private static int calcMin() {
		int arrMin = Integer.MAX_VALUE;
		for(int i = 1; i<=N; i++) {
			int rowSum = 0;
			for(int j = 1; j<=M; j++) {
				rowSum += map[i][j];
			}
			arrMin = Math.min(arrMin, rowSum);
		}
		return arrMin;
	}
}