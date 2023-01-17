import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] x_arr = new int[n];
		int[] y_arr = new int[n];
	
		for(int tc = 0; tc<n; tc++) {
			x_arr[tc] = sc.nextInt();
			y_arr[tc] = sc.nextInt();
		}
		
		Arrays.sort(x_arr);
		Arrays.sort(y_arr);
		
		int x_mid = x_arr[n/2];
		int y_mid = y_arr[n/2];
		
		long res = 0L;
		
		for(int i = 0; i<n; i++) {
			res += Math.abs((x_mid - x_arr[i]));
			res += Math.abs((y_mid - y_arr[i]));
		}
		
		System.out.println(res);
		
		
	}

}