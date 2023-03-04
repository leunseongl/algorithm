import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 가능한 경우의 수에서 적은 비용 */
public class Solution {

	static int res;
	static int[] charge;
	static int[] plan;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			//이용권 가격들 입력
			charge = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<4; i++) {
				charge[i] = Integer.parseInt(st.nextToken());
			}
			
			//이용 계획 입력
			plan = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			//입력 완료
			
			res = charge[3]; //1년치 비용으로 초기화
			dfs(1, 0);
			System.out.printf("#%d %d%n", tc, res);
			
		}
	}
	
	private static void dfs(int month, int sum) {
		
		if(month >= 13) {
			res = Math.min(res, sum);
			return;
		}
		
		//이용안할 떄 안사기
		if(plan[month] == 0) dfs(month+1, sum);
		
		//1일 이용권 
		dfs(month+1, sum + plan[month] * charge[0]);
		
		//한 달 이용권
		dfs(month+1, sum + charge[1]);
		
		//3달 이용권
		dfs(month+3, sum + charge[2]);
		
	}
}