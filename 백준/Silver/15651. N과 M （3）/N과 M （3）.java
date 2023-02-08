import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 230208 
 * 1. N과 M 3, 4
 * 2. 프로그래머스 완전탐색 레벨 1
 * 3. 조이스틱 코드 다시 보기
 * 4. 시간 남으면 하노이
 */

class Main {

	static int N;
	static int M;
	static int[] picked;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		picked = new int[M];
		
		duplicatePermutation(0);
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static void duplicatePermutation(int cnt) throws IOException {

		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				bw.write(String.valueOf(picked[i]) + " ");
			} 
			bw.newLine();
			return;
		}
		
		for(int i = 1; i<=N; i++) {
			picked[cnt] = i;
			duplicatePermutation(cnt+1);
		}
	}
		
}