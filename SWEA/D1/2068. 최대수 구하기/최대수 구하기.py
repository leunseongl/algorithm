import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int[] arr = new int[10];
			String[] tmp = br.readLine().split(" ");
			int big = 0;
			for(int j=0; j<arr.length; j++) {
				arr[j] = Integer.parseInt(tmp[j]);
				if(arr[j]>big) {
					big = arr[j];
				}
			}
			System.out.println("#" + (i+1) + " " + big);
		}
		
	}

}