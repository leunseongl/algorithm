import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int res = 0;
		if(n%2 == 1) {
			res = arr[n/2];
		} else {
			int mid1 = arr[n/2-1];
			int mid2 = arr[n/2];
			int tmp1 = 0, tmp2 = 0;
			for(int i = 0; i<n; i++) {
				tmp1 += Math.abs(mid1 - arr[i]);
				tmp2 += Math.abs(mid2 - arr[i]);
			}
			if(tmp1>tmp2) res = mid2;
			if(tmp2>=tmp1) res = mid1;
		}
		
		System.out.println(res);
		
	}
}