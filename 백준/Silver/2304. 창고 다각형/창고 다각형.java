
import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//1. 입력받고 L을 기준으로 정렬
		//2. 가장 높은 H 찾기
		//3. 가장 높은 H를 기준으로 왼쪽 오른쪽 탐색
		//4. 높은 H가 나오면 갱신, 아니면 그대로 면적 +
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			return o1[0]-o2[0];
			});
		
		int idx = 0;
		int big_h = 0;
		for(int i = 0; i<n; i++) {
			if(arr[i][1]>big_h) {
				big_h = arr[i][1];
				idx = i;
			}
		}
		
		int res = 0;
		
		//왼쪽 탐색
		int tmp1 = 0;
		for(int i = 0; i<idx; i++) {
			if(arr[i][1]>tmp1) {
				tmp1 = arr[i][1];
			}
			res += (tmp1*(arr[i+1][0]-arr[i][0]));
		}
		
		//오른쪽 탐색
		int tmp2 = 0;
		for(int i = n-1; i>idx; i--) {
			if(arr[i][1]>tmp2) {
				tmp2 = arr[i][1];
			}
			res += (tmp2*(arr[i][0]-arr[i-1][0]));
		}
		
		res += big_h;
		System.out.println(res);
	
	}
}