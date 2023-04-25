import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, -1, 0, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	
	//시작 지점, 끝 지점 저장
	static class Pos {
		int l, r, c;
		public Pos(int l, int r, int c) {
			this.l = l;
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Pos [l=" + l + ", r=" + r + ", c=" + c + "]";
		}
	}
	
	static int L, R, C;
	static char[][][] map;
	static boolean[][][] visit;
	static int[][][] time;
	static boolean flag;
	static Pos start, end;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			flag = false; //탈출 할 수 있으면 true로 만들거임
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L==0 && R==0 && C==0) break;
			
			map = new char[L][R][C];
			visit = new boolean[L][R][C];
			time = new int[L][R][C];
			
			for(int i = 0; i<L; i++) {
				for(int j = 0; j<R; j++) {
					String line = br.readLine();
					for(int k = 0; k<C; k++) {
						char c = line.charAt(k);
						map[i][j][k] = c;
						if(c == 'S')
							start = new Pos(i, j, k);
						if(c == 'E')
							end = new Pos(i, j, k);
					}
				}
				br.readLine();
			}
			//입력 완료
			
			bfs();
			if(!flag) { //탈출 못했으면 trap 출력
				System.out.println("Trapped!");
			}
			else { //탈출 했으면 초 넣어서 출력
				System.out.printf("Escaped in %d minute(s).%n", time[end.l][end.r][end.c]);
			}
		}
		
	}
	
	private static void bfs() {
		Queue<Pos> q = new ArrayDeque<>(); 
		q.offer(new Pos(start.l, start.r, start.c)); //시작지점 큐에 넣어주기
		visit[start.l][start.r][start.c] = true; //시작지점 방문처리
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			if(cur.l==end.l && cur.r==end.r && cur.c==end.c) {
				flag = true;
				return;
			}
			
			for(int k = 0; k<6; k++) {
				int nl = cur.l + dx[k];
				int nr = cur.r + dy[k];
				int nc = cur.c + dz[k];
				
				if(isRange(nl, nr, nc) && !visit[nl][nr][nc] && map[nl][nr][nc] != '#') {
					time[nl][nr][nc] = time[cur.l][cur.r][cur.c]+1;//time에 시간 표시
					visit[nl][nr][nc] = true;//방문 처리
					q.offer(new Pos(nl, nr, nc));//큐에 넣어주기
				}
			}
			
		}
		
		
	}
	
	private static boolean isRange(int x, int y, int z) {
		if(x<0 || x>=L || y<0 || y>=R || z<0 || z>=C) return false;
		return true;
	}

}