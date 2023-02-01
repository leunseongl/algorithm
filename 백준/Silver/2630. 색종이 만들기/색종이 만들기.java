import java.io.*;
import java.util.*;


public class Main {
	
	static int white, blue;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divideConquer(0, n, 0, n);
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	static void divideConquer(int x1, int x2, int y1, int y2) {
		
		int now = arr[x1][y1];
		boolean flag = true;
		
		for(int i = x1; i<x2; i++) {
			for(int j = y1; j<y2; j++) {
				if(arr[i][j] != now) {
					flag = false;
					break;
				}
			}
			//if(!flag) break;
		}
		
		if(flag) {
			if(now == 0) white++;
			else blue++;
		}
		
		else {
			divideConquer(x1, (x1+x2)/2, y1, (y1+y2)/2);
			divideConquer(x1, (x1+x2)/2, (y1+y2)/2, y2);
			divideConquer((x1+x2)/2, x2, y1, (y1+y2)/2);
			divideConquer((x1+x2)/2, x2, (y1+y2)/2, y2);
		}
		
		
	}
	
}