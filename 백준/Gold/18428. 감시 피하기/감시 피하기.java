import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Data {
		int x, y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Data [x=" + x + ", y=" + y + "]";
		}
	}
	
	static int N;
	static char[][] map;
	static boolean flag;
	static List<Data> teachers;
	static List<Data> students;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		teachers = new ArrayList<>();
		students = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') teachers.add(new Data(i, j));
				if(map[i][j] == 'S') students.add(new Data(i, j));
			}
		}
		//입력 완료
	
		flag = false;
		combination(0, 0);
		
		System.out.println(!flag?"NO":"YES");
	}
	
	//조합
	private static void combination(int cnt, int start) {
		
		if(cnt == 3) { //장애물 3개 완성 시
//			for(int i = 0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			} System.out.println();
			avoid();
			return;
		}
		
		for(int i = start; i<N*N; i++) {
			int x = i/N;
			int y = i%N;
			
			if(map[x][y] == 'X') {
				map[x][y] = 'O';
				combination(cnt+1, i+1);
				map[x][y] = 'X';
			}
		}
	}
	
	//피하기
	private static void avoid() {
		
		int sCnt = 0;
		
		for(int i = 0; i<teachers.size(); i++) { 
			Data teacher = teachers.get(i); //선생님 하나 꺼내서
			
			for(int k = 0; k<4; k++) { //4방향
				int nx = teacher.x;
				int ny = teacher.y;
			
				while(true) {
					nx += dx[k]; //계속 그 방향으로 전진
					ny += dy[k];
					
					//경계선 넘어가면 멈춤
					if(nx<0 || nx>=N || ny<0 || ny>=N) break;
					//장애물을 만나면 멈춤
					if(map[nx][ny]=='O') break;
					//학생을 만나면 카운트 올리기
					if(map[nx][ny]=='S') {
						sCnt++;
						break;
					}
				}
				
			}
			
		}
		//모든 학생이 걸리지 않았다면 flag를 true로
		if(sCnt == 0) flag = true;
	}
}