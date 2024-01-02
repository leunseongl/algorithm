import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 건물 1~N번, M개 도로
 * 도로는 양방향, 1시간
 * 모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단 시간의 총합을 최소화
 * 건물 조합이 여러 개면 번호 작은거, 작은 번호가 같다면 큰 번호가 더 작을수록
 */
public class Main {

	static int N, answer, one, two;
	static int[][] dist;
	static int[] picked;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dist = new int[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(i == j) dist[i][j] = 0;
				else dist[i][j] = 101;
			}
		}
		//초기화
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dist[a-1][b-1] = 1;
			dist[b-1][a-1] = 1;
		}
		
		for(int k = 0; k<N; k++) {
			for(int i = 0; i<N; i++) {
				if(i == k) continue;
				for(int j = 0; j<N; j++) {
					if(i == j || j == k) continue;
					if(dist[i][j] > dist[i][k]+dist[k][j]) dist[i][j]=dist[i][k]+dist[k][j];
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		picked = new int[2];
		one = 0;
		two = 0;
		combi(0,0);
		
		System.out.println(one + " " + two + " " + answer);
	}
	
	private static void combi(int cnt, int start) {
		
		if(cnt == 2) {
			//System.out.println(Arrays.toString(picked));
			int tmp = 0;
			for(int i = 0; i<N; i++) {
				if(dist[picked[0]][i] > dist[picked[1]][i]) {
					tmp += dist[picked[1]][i]*2;
				}
				else {
					tmp += dist[picked[0]][i]*2;
				}
			}
			
			if(answer>tmp) {
				answer = tmp;
				one = picked[0]+1;
				two = picked[1]+1;
			}
			return;
		}
		
		for(int i = start; i<N; i++) {
			picked[cnt] = i;
			combi(cnt+1, i+1);
		}
		
	}

}