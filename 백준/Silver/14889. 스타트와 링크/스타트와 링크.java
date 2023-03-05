import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int answer;
	static int[][] map;
	static boolean[] select;
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
		
		answer = Integer.MAX_VALUE;
		select = new boolean[N];
		combination(0,0);
		
		System.out.println(answer);
	}
	
	private static void combination(int cnt, int start) {

		if(cnt == N/2) {
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(select[i] && select[j]) sum1+=map[i][j];
					else if(!select[i] && !select[j]) sum2+=map[i][j];
				}
			}
			answer = Math.min(answer, Math.abs(sum1-sum2));
			return;
		}
		
		for(int i = start; i<N; i++) {
			select[i] = true;
			combination(cnt+1, i+1);
			select[i] = false;
		}
		
	}

}
