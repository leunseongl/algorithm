import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken()); //게임 횟수
		int Y = Integer.parseInt(st.nextToken()); //이긴 게임
		
		int cur = calculate(X, Y);
		int answer = -1;
		int left = 0, right = 1000000000;
		
		while(left <= right) {
			int mid = (left+right)/2;
			
			if(calculate(X+mid, Y+mid) != cur) {
				answer = mid;
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		System.out.println(answer);
		
	}
	
	private static int calculate(int x, int y) {
		
		return (int)((long) y * 100 / x);
		
	}

}