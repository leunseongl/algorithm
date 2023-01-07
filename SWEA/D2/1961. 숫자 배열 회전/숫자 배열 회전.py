import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n]; //input 받을 배열
			
			//입력 받아 2차원 배열에 넣어주기
			for(int i = 0; i<n; i++) {
				String[] tmp = br.readLine().split(" ");
				for(int j = 0; j<n; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			//90도 회전
			int[][] arr_90 = new int[n][n];
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					arr_90[i][j] = arr[n-j-1][i];
				}
			}
			
			//180도 회전
			int[][] arr_180 = new int[n][n];
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					arr_180[i][j] = arr[n-i-1][n-j-1];
				} 
			}
			
			//270도 회전
			int[][] arr_270 = new int[n][n];
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					arr_270[i][j] = arr[j][n-i-1];
				} 
			}
			
			//출력
			System.out.println("#" + (tc+1));
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					System.out.print(arr_90[i][j]);
				}
				System.out.print(" ");
				for(int m = 0; m<n; m++) {
					System.out.print(arr_180[i][m]);
				}
				System.out.print(" ");
				for(int k = 0; k<n; k++) {
					System.out.print(arr_270[i][k]);
				}
				System.out.println();
			}
		}
		
	}

}