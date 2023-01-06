import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		int[] arr = new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		Arrays.sort(arr);
		System.out.println(arr[n/2]);

	}

}