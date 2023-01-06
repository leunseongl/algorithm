import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int tot = 0;
		
		while(n>0) {
			tot += n%10;
			n /= 10;
		}
		System.out.println(tot);
		
	}

}
