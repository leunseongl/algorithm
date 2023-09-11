import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //센서의 개수
		int K = Integer.parseInt(br.readLine()); //집중국의 개수
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//입력 완료
		
		if(N<=K) {
			System.out.println(0);
		}
		
		else {
			Arrays.sort(arr); //정렬
			
			Integer[] diff = new Integer[N-1]; //차이 배열
			for(int i = 0; i<N-1; i++) {
				diff[i] = Math.abs(arr[i+1]-arr[i]);
			} 
			
			Arrays.sort(diff, Collections.reverseOrder()); //내림차순 정렬

			int answer = 0;
			for(int i = K-1; i<N-1; i++) {
				answer += diff[i];
			}
			
			System.out.println(answer);
		}
		
	}
	
}