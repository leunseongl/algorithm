import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //국가의 수
			int M = Integer.parseInt(st.nextToken()); //비행기의 종류
			
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
			}
			
			System.out.println(N-1);
		}
		
	}

}