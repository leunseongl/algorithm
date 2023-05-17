import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int D,W,K,answer;
	static int[][] map;
	public static void main(String[] args) throws IOException {

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
			
			if(K==1) {
				System.out.printf("#%d %d%n", tc, 0);
			}
			else {
				answer = Integer.MAX_VALUE;
				subset(0,0);
				System.out.printf("#%d %d%n", tc, answer);
			}
		}
		
	}
	
	//약품 넣기 부분집합
	private static void subset(int cnt, int drug) {
		
		//이미 현재 저장되어 있는 약품 수보다 크면 return
		if(drug>=answer) return;
		
		if(cnt == D) {
			//부분집합 완성
//			System.out.println(drug);
//			for(int i = 0; i<D; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}System.out.println();
			if(check()) { //성능 검사 통과했으면
				answer = Math.min(answer, drug);
			}
			return;
		}
		
		//한 줄 저장
		int[] save = new int[W];
		for(int i=0; i<W; i++) {
			save[i] = map[cnt][i];
		}
		
		//아무것도 안하기
		subset(cnt+1, drug);
		
		//a 넣기
		for(int i=0; i<W; i++) {
			map[cnt][i] = 0;
		}
		subset(cnt+1, drug+1);
		
		//b 넣기
		for(int i=0; i<W; i++) {
			map[cnt][i] = 1;
		}
		subset(cnt+1, drug+1);
		
		//원래대로 돌리기
		for(int i=0; i<W; i++) {
			map[cnt][i] = save[i];
		}
	}
	
	private static boolean check() {
		
		//한줄이라도 성능검사 통과 못하면 return
		int cnt = 0;
		for(int i=0; i<W; i++) {
			int tmp = 1;
			boolean flag = false;
			for(int j=0; j<D-1; j++) {
				if(map[j][i] == map[j+1][i]) tmp++;
				else tmp=1;
				if(tmp>=K) {
					cnt++;
					flag = true;
					break;
				}
			}
			if(!flag) return false;
		}
		if(cnt == W) return true;
		else return false;
	}

}