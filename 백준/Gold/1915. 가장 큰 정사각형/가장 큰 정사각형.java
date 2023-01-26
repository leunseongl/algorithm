import java.io.*;
import java.util.*;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		if(n == 1 && m == 1) {
			System.out.println(1);
			return;
		}
		
		int res = 0;
		int[][] nemo = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			String[] input = br.readLine().split("");

			for (int j = 1; j <= m; j++) {
				int temp = Integer.parseInt(input[j - 1]);

				if (i == 1 && j == 1) { 
					nemo[i][j] = temp;
				} else { 
					if (temp == 1) {
						nemo[i][j] = Math.min(nemo[i - 1][j - 1], Math.min(nemo[i - 1][j], nemo[i][j - 1])) + 1;
						res = Math.max(res, nemo[i][j]);
					}
				}
			}
		}

		
		System.out.println(res*res);	
	}
}