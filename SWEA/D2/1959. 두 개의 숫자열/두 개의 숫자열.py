import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<t; tc++) {
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			
			String[] a = br.readLine().split(" ");
			String[] b = br.readLine().split(" ");
			ArrayList<Integer> a_arr = new ArrayList<>();
			ArrayList<Integer> b_arr = new ArrayList<>();
			
			for(int i = 0; i<n; i++) {
				a_arr.add(Integer.parseInt(a[i]));
			}
			for(int j = 0; j<m; j++) {
				b_arr.add(Integer.parseInt(b[j]));
			}
			
			int res = 0;
			if(n==m) {
				for(int i = 0; i<n; i++) {
					res += a_arr.get(i) * b_arr.get(i);
				}
			} else {
				if(n>m) {
					for(int j = 0; j<n-m+1; j++) {
						int tmp = 0;
						for(int k = 0; k<m; k++) {
							tmp += a_arr.get(j+k) * b_arr.get(k);
						}
						if(tmp>res)
							res = tmp;
					}
				} else {
					for(int j = 0; j<m-n+1; j++) {
						int tmp = 0;
						for(int k = 0; k<n; k++) {
							tmp += a_arr.get(k) * b_arr.get(j+k);
						}
						if(tmp>res)
							res = tmp;
					}
				}
			}
			System.out.println("#" + (tc+1) + " " + res);
		}
		
	}

}