import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Virus {
		int x, y; 
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Virus [x=" + x + ", y=" + y + "]";
		}
	}
	
	static int N, M, zeroCnt, answer;
	static int[][] lab;
	static boolean[][] visit;
	static Virus[] activeVirus;
	static List<Virus> virusList = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 0) zeroCnt++; //빈칸 세주기
				else if(lab[i][j] == 2) virusList.add(new Virus(i, j)); //바이러스 칸 저장
			}
		}
		//입력 완료
		
		//빈칸이 없는 경우 0을 출력하고 바로 종료
		if(zeroCnt == 0) {
			System.out.println(0);
			return;
		}
		
		answer = Integer.MAX_VALUE;
		activeVirus = new Virus[M]; //조합용 배열
		combination(0, 0);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		
	}
	
	//바이러스 칸 중 활성화 조합 메서드
	private static void combination(int start, int cnt) {
		
		if(cnt == M) {
			bfs(zeroCnt);
			return;
		}
		
		for(int i = start; i<virusList.size(); i++) {
			activeVirus[cnt] = virusList.get(i);
			combination(i+1, cnt+1);
		}

	}
	
	//바이러스 확산
	private static void bfs(int zero) {
		
		int time = 0;
		Queue<Virus> q = new ArrayDeque<>();
		visit = new boolean[N][N];
		
		for(Virus v: activeVirus) {
			q.offer(v); //활성화 바이러스 큐에 넣기
			visit[v.x][v.y] = true;
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) { //동시 퍼짐 => 레벨별 bfs
				Virus cur = q.poll();
				
				for(int k = 0; k<4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					
					 if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	                 if (visit[nx][ny] || lab[nx][ny] == 1) continue;
						
					//빈칸이면 빈칸 수 낮추기
					if(lab[nx][ny] == 0) zero--;
						
					visit[nx][ny] = true;
					q.offer(new Virus(nx, ny));
					
				}
			}
			
			time++;
            
			// 만약 현재 최소 시간 보다 오래 걸린다면 더이상 검사할 필요가 없어 종료
            if(time >= answer) return;
            
            // 빈 칸이 더 이상 존재 하지 않는 경우 최소 시간을 갱신
            if(zero <= 0) answer = time;
		
		}
	}
	
}