import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 0; tc < 10; tc++) {
			int big = 0;
			int t = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String[] tmp = br.readLine().split(" ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}

			for (int i = 0; i < 100; i++) {
				int sum1 = 0;
				int sum2 = 0;
				for (int j = 0; j < 100; j++) {
					sum1 += arr[i][j];
					sum2 += arr[j][i];
				}
				if (sum1 > big)
					big = sum1;
				if (sum2 > big)
					big = sum2;
			}
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < 100; i++) {
				sum1 += arr[i][i];
				sum2 += arr[i][99 - i];
			}
			if (sum1 > big)
				big = sum1;
			if (sum2 > big)
				big = sum2;
			System.out.println("#" + t + " " + big);
		}

	}

}