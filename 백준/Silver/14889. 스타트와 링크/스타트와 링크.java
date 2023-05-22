import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,answer;
	static int[][] map;
	static boolean[] isSelect;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		answer = Integer.MAX_VALUE;
		isSelect = new boolean[N];
		combination(0,0);
		
		System.out.println(answer);
	}

	private static void combination(int cnt, int start) {
		
		if(cnt == N/2) {
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(isSelect[i] && isSelect[j]) sum1+=map[i][j];
					else if(!isSelect[i] && !isSelect[j]) sum2+=map[i][j];
				}
			}
			answer = Math.min(answer, Math.abs(sum1-sum2));
			return;
		}
		
		for(int i = start; i<N; i++) {
			isSelect[i] = true;
			combination(cnt+1, i+1);
			isSelect[i] = false;
		}
	}
}