import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] zero = new int[41];
    	int[] one = new int[41];
    	zero[0] = 1;
    	zero[1] = 0;
    	one[0] = 0;
    	one[1]  = 1;
    	
    	int T = Integer.parseInt(br.readLine());
	    for(int tc = 0; tc<T; tc++) {
	    	int num = Integer.parseInt(br.readLine());
	    	for(int i = 2; i<=num; i++) {
	    		zero[i] = zero[i-1] + zero[i-2];
	    		one[i] = one[i-1] + one[i-2];
	    	}
	    	System.out.printf("%d %d\n", zero[num], one[num]);
	    }

	}
	
}