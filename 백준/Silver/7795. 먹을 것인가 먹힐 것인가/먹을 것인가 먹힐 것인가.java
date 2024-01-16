import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Integer[] arrA = new Integer[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			
			Integer[] arrB = new Integer[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			//입력 완료
			
			int answer = 0;
			Arrays.sort(arrB);
			for(int i = 0; i<N; i++) {
				int left = 0, right = M-1;
				
				while(left<=right) {
					int mid = (left+right)/2;
					
					if(arrB[mid]<arrA[i]) {
						left = mid+1;
					}
					
					else if(arrB[mid]>=arrA[i]) {
						right = mid-1;
					}
				}
				
				answer += left;
			}
			
			System.out.println(answer);
			
		}
		
	}

}