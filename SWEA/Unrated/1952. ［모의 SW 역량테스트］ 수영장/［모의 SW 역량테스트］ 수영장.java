import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] plan;
	static int[] charge;
	static int answer;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			charge = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<4; i++) {
				charge[i] = Integer.parseInt(st.nextToken());
			}
			
			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			//입력 완료
			
			answer = charge[3];
			dfs(0,0);
			
			System.out.printf("#%d %d%n", tc, answer);
		}
	}
	
	private static void dfs(int month, int sum) {
		
		if(month >= 12) {
			//System.out.println(sum);
			answer = Math.min(answer, sum);
			return;
		}
		
		//이용 안할 때
		if(plan[month] == 0) 
			dfs(month+1, sum);
		
		//1일 이용권
		dfs(month+1, sum + charge[0] * plan[month]);
		
		//1달 이용권
		dfs(month+1, sum + charge[1]);
		
		//3달 이용권
		dfs(month+3, sum + charge[2]);
		
	}

}