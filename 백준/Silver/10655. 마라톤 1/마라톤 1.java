import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 젖소들의 마라톤 대회, 코스는 N개의 체크포인트로 구성
 * 1번 체크포인트에서 시작헤서 모든 체크포인트를 순서대로 방문 후 N번에서 종료 
 * 박승원 젖소는 1번, N번 체크 포인트 외에 체크포인트 하나를 몰래 건너 뛰려고 함
 * 하나를 건너 뛰어서 달린다면 승원이가 달려야 하는 최소 거리는?
 * 거리는 |x1-x2| + |y1-y2|로 계산
 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int all = 0;
		int[][] checkPoint = new int[N][2];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<2; j++) {
				checkPoint[i][j] = Integer.parseInt(st.nextToken());
			}
			if(i != 0) {
				all += calculate(checkPoint[i-1], checkPoint[i]);
			}
		}
		//입력 완료
		
		
		int answer = Integer.MAX_VALUE;
		for(int i = 1; i<N-1; i++) {

			// jump뛰는 시점 
			int original = Math.abs(checkPoint[i][0]-checkPoint[i-1][0]) 
							+ Math.abs(checkPoint[i][1]-checkPoint[i-1][1])
							+ Math.abs(checkPoint[i][0]-checkPoint[i+1][0]) 
							+ Math.abs(checkPoint[i][1]-checkPoint[i+1][1]);
			int jump = Math.abs(checkPoint[i-1][0] - checkPoint[i+1][0])
						+ Math.abs(checkPoint[i-1][1] - checkPoint[i+1][1]);
			
			answer = Math.min(answer, all - original + jump);
			
			
		}
		
		System.out.println(answer);
		
	}
	
	private static int calculate(int[] from,int[] to) {
		return Math.abs(from[0]-to[0])+Math.abs(from[1]-to[1]);
	}

}