import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 읽기
 * D*W 크기의 보호필름
 * 각 셀들은 특성 a, b 둘 중 하나를 가지고 있음
 * 특성A는 0, 특성B는 1
 * 성능은 합격기준 K가 있는데, 
 * 모든 세로 방향에서 동일한 특성이 K개 이상 연속적으로 있는 경우에만 성능검사를 통과
 * 약품 투입 가능한데, a약품을 투입하면 그 행(가로)은 모두 a로 바뀜
 * 성능 검사를 통과하는 최소 약품 투입 횟수 출력
 * 약품을 투입하지 않고도 성능 검사를 통과하는 경우에는 0 출력
 * 
 * 문제 접근
 * 부분집합, 모든 셀에 a, b, 안넣기 해보고 성능 테스트 시작
 * K가 1일 때는 바로 0출력
 * 하나의 열이라도 성능 검사를 통과하지 못하면 커트
 * 현재 사용한 약품 횟수보다 많아지면 커트
 */
public class Solution {

	static int D,W,K,answer;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); //합격 기준
			
			map = new int[D][W];
			for(int i = 0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료
			
			//K가 1이면 0출력 로직
			if(K == 1) {
				System.out.printf("#%d %d%n", tc, 0);
			}
			else {
				answer = Integer.MAX_VALUE;
				subset(0,0);
				System.out.printf("#%d %d%n", tc, answer);
			}
		}
		
	}

	//cnt: 약품 횟수
	private static void subset(int idx, int cnt) {
		
		//cnt가 현재 answer에 저장되어 있는 값보다 크다면 return
		if(cnt>=answer) return;
		
		if(idx == D) {
//			for(int i = 0; i<D; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}System.out.println();
			//성능 테스트 통과하면 answer 값 갱신
			if(check()) {
				answer = Math.min(cnt, answer);
			}
			return;
		}
		
		//되돌릴 때 사용 할 배열 만들기
		int[] tmp = new int[W];
		for(int i = 0; i<W; i++) {
			tmp[i] = map[idx][i];
		}
//		System.out.println("복사 배열");
//		System.out.println(Arrays.toString(tmp));
		
		//안넣기
		subset(idx+1, cnt);

		//a
		for(int i = 0; i<W; i++) {
			map[idx][i] = 0;
		}
		subset(idx+1, cnt+1);
		
		//b
		for(int i = 0; i<W; i++) {
			map[idx][i] = 1;
		}
		subset(idx+1, cnt+1);
		
		
		//되돌리기
		for(int i = 0; i<W; i++) {
			map[idx][i] = tmp[i] ;
		}
		
	}
	
	private static boolean check() {
		
		int line = 0;
		for(int i = 0; i<W; i++) {
			int cnt = 1; //하나의 열 마다 cnt 초기화
			boolean flag = false;
			for(int j = 0; j<D-1; j++) {
				if(map[j][i] == map[j+1][i]) {
					cnt++;
					if(cnt>=K) { //합격 기준이 됐으면
						line++;
						flag = true; 
						break; //다음 열 보러 고고
					}
				}
				else cnt = 1;
			}
			//하나의 열이라도 성능 테스트를 통과 못했으면 false 반환
			if(!flag) return false;
		}
		if(line == W) return true;
		else return false;
	}
}