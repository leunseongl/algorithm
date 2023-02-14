import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, R;
	static int mid;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		mid = Math.min(N, M)/2;
		
		for(int i = 0; i<R; i++) {
			rotate();
		}

		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				System.out.print(arr[i][j] + " ");
			} System.out.println();
		}

		
		
	}
	
	private static void rotate() {
		for(int start = 0; start<mid; start++) {
			
			int tmp = arr[start][start];
			
			int n = N-1-start;
			int m = M-1-start;
			
			//왼쪽
			for(int i = start; i<m; i++) {
				arr[start][i] = arr[start][i+1];
			}
						
			//위쪽
			for(int i = start; i<n; i++) {
				arr[i][m] = arr[i+1][m];
			}
			
			//오른쪽
			for(int i = m; i>start; i--) {
				arr[n][i] = arr[n][i-1];
			}
			
			//아래쪽
			for(int i = n; i>start; i--) {
				arr[i][start] = arr[i-1][start];
			}
			
			arr[start+1][start] = tmp;
			
		}
	}

}