import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 문제 읽기
 * 대각선 방향으로 움직이고 사각형 모양을 그리며 출발한 카페로 돌아와야 함
 * 해당 지역을 벗어나면 안되고, 같은 종류의 디저트도 안됨
 * 디저트를 가장 많이 먹을 수 있는 경로를 찾아 그 때의 디저트 수를 정답으로 출력
 * 만약 디저트를 먹을 수 없는 경우 -1 출력
 * 
 * 문제 접근
 * N*N, 모든 곳에서 다 dfs를 돌려봐야 함
 * 사각형 모양으로 돌아가는 방향이 정해져 있기 때문에 방향을 고정해줘야 함
 * 하나의 카페에서 사먹는 것 안됨 -> set의 갯수로 자르기
 * 왔던 길을 다시 돌아가는 것도 안됨 -> 이건 어차피 방향을 고정하는 것과 같은 종류의 디저트 조건에서 짤림
 * 시작할 수 있는 지점 찾기
 *
 */
public class Solution {

	//방향 고정: 우하, 좌하, 좌상, 우상
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};
	
	static int N, answer;
	static int[][] map;
	static boolean[][] visit;
	static HashSet<Integer> set;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료
			
			answer = -1;
			set = new HashSet<>();
			for(int i = 0; i<N-2; i++) {
				for(int j = 1; j<N-1; j++) {
					visit = new boolean[N][N];
					set.clear();
					visit[i][j] = true;
					set.add(map[i][j]);
					dfs(i, j, i, j, 0);
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
		}
		
	}
	
	private static void dfs(int sx, int sy, int x, int y, int dir) {
		
		for(int k = dir; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(set.size()>=4 && nx == sx && ny == sy) { //다음으로 갈 곳이 시작 위치면
				answer = Math.max(answer, set.size());
				return;
			}
			
			if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny]) {
				if(!set.contains(map[nx][ny])) { //해당 디저트를 포함하지 않으면
					visit[nx][ny] = true;
					set.add(map[nx][ny]);
					dfs(sx, sy, nx, ny, k);
					visit[nx][ny] = false;
					set.remove(map[nx][ny]);
				}
			}
		}
	}
}