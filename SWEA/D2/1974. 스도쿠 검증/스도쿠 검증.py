import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Solution {
	
	public static boolean check(int[][] puzzle) {
		for(int i = 0; i<9; i++) {
			int[] ch1 = new int[10];
			int[] ch2 = new int[10];
			for(int j = 0; j<9; j++) {
				ch1[puzzle[i][j]] = 1;
				ch2[puzzle[j][i]] = 1;
			}
			
			int tot1 = IntStream.of(ch1).sum();
			int tot2 = IntStream.of(ch2).sum();
			if(tot1 != 9)
				return false;
			if(tot2 != 9)
				return false;
		}
		
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				int[] ch3 = new int[10];
				for(int m = 0; m<3; m++) {
					for(int k = 0; k<3; k++) {
						ch3[puzzle[i*3+m][j*3+k]] = 1;
					}
				}
				int tot3 = IntStream.of(ch3).sum();
				if(tot3 != 9)
					return false;
			}
		}
		return true;		
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<t; tc++) {
			int[][] puzzle = new int[9][9];
			
			for(int i = 0; i<9; i++) {
				String[] line = br.readLine().split(" ");
				for(int j = 0; j<9; j++) {
					puzzle[i][j] = Integer.parseInt(line[j]);
				}
			}
			
			if(check(puzzle) == true) {
				System.out.println("#" + (tc+1) + " " + 1);
			} else {
				System.out.println("#" + (tc+1) + " " + 0);
			}
		}
		
		
	}

}