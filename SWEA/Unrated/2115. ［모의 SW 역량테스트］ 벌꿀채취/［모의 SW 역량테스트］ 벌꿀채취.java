import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N,M,C,answer,tmp1,tmp2;
	static int[][] map;
	static int[][] select;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //N*N
			M = Integer.parseInt(st.nextToken()); //한 명의 일꾼이 채취할 수 있는 벌통의 수
			C = Integer.parseInt(st.nextToken()); //한 명의 일꾼이 채취할 수 있는 꿀의 최대 양
			
			map = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료
			
			answer = Integer.MIN_VALUE;
			select = new int[2][M];
			combination(0,0);
			
			System.out.printf("#%d %d%n", tc, answer);
		}
		
	}
	
	//벌통 선택 조합
	private static void combination(int cnt, int start) {
		
		//일꾼 두 명 벌꿀 선택 완료
		if(cnt == 2) {
//			for(int i = 0; i<2; i++) {
//				System.out.println(Arrays.toString(select[i]));
//			}
			//부분집합으로 수익 계산하러 이동
			tmp1 = 0; //현재 뽑은 조합 중 일꾼 1의 최대 수익
			tmp2 = 0; //현재 뽑은 조합 중 현재 일꾼 2의 최대 수익
			subset1(0,0,0);
			subset2(0,0,0);
			answer = Math.max(answer, tmp1+tmp2);
			return;
		}
		
		for(int i = start; i<N*N; i++) {
			int x = i/N;
			int y = i%N;
			if(N-M<y) continue; //어차피 못가는 곳 자르기
			
			for(int j = 0; j<M; j++) { //선택된 꿀 정보에 넣기
				select[cnt][j] = map[x][y+j];
			}
			
			//다음 일꾼 벌통 선택
			combination(cnt+1, i+M);
		}
	}
	
	//수익 계산 부분집합
	private static void subset1(int cnt, int sum, int profit) {
		
		if(sum>C) return;
		
		if(cnt==M) {
			if(C>=sum) { //최대양을 넘지 않으면
				//System.out.println(sum);
				tmp1 = Math.max(tmp1, profit);
			}
			return;
		}
		
		subset1(cnt+1, sum+select[0][cnt], profit+(select[0][cnt]*select[0][cnt]));
		subset1(cnt+1, sum, profit);
	}
	
	//수익 계산 부분집합
	private static void subset2(int cnt, int sum, int profit) {
		
		if(sum>C) return;
		
		if(cnt==M) {
			if(C>=sum) { //최대양을 넘지 않으면
				//System.out.println(sum);
				tmp2 = Math.max(tmp2, profit);
			}
			return;
		}
		
		subset2(cnt+1, sum+select[1][cnt], profit+(select[1][cnt]*select[1][cnt]));
		subset2(cnt+1, sum, profit);
	}
}