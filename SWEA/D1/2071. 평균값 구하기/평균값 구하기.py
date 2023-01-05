import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int[] arr = new int[10];
			int tot = 0;
			for(int j=0; j<arr.length; j++) {
				arr[j] = sc.nextInt();
				tot += arr[j];
			}
			int res = (int)Math.round((double)tot/10);
			System.out.println("#" + (i+1) + " " + res);
		}
	}
}