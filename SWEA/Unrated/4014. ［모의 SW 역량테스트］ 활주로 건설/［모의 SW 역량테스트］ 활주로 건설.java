import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *경우의 수 4가지
 *1) 현재 위치가 이전과 같은 높이
 *2) 이전 칸이 현재 칸보다 한 칸 낮은 경우
 *3) 이전 칸이 현재 칸보다 한 칸 높은 경우
 *4) 높이 차이가 2이상, 불가능
 */
public class Solution {

	static int N, X;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //한 변의 크기
			X = Integer.parseInt(st.nextToken()); //경사로 길이
			
			map = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료
			
			int res = 0;
			for(int i = 0; i<N; i++) {
				if(make(i, 0, 0)) res++;
				if(make(0, i, 1)) res++;
			}
			
			System.out.printf("#%d %d%n", tc, res);
			
		}
		
	}

	//d가 0이면 행, d가 1이면 열
	private static boolean make(int x, int y, int d) {
		int[] tmp = new int[N]; //한줄 떼오기 위함
		boolean[] visit = new boolean[N]; //방문 체크
		
		//tmp 배열에 옮기기
		for(int i = 0; i<N; i++) {
			tmp[i] = (d == 0) ? map[x][y+i] : map[x+i][y]; 
		}
		
		for(int i = 0; i<N-1; i++) {
			
			//높이가 2이상 차이나는 경우, return false
			if(Math.abs(tmp[i]-tmp[i+1]) > 1) return false;
			
			//높이가 같으면 continue
			if(tmp[i] == tmp[i+1]) continue;
			
			//이전 칸이 현재 칸보다 한 칸 낮은 경우 -> 올라가야 함
			if(tmp[i]-tmp[i+1] == -1) {
				for(int j = i; j>i-X; j--) { //이 부분 중요, X 길이 만큼 체크
					 // j가 범위를 벗어나거나 높이가 다르거나 이미 경사로가 있는 경우
					if(j<0 || tmp[i] != tmp[j] || visit[j] == true)
						return false;
					visit[j] = true;
				}
			}
			
			//이전 칸이 현재 칸보다 한 칸 높은 경우 -> 내려가야 함
			if(tmp[i]-tmp[i+1] == 1) {
				for(int j = i+1; j<=i+X; j++) {
					if(j>=N || tmp[i+1] != tmp[j] || visit[j] == true) 
						return false;
					visit[j] = true;
				}
			}
		}
		return true;
	}
}