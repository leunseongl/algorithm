import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];

		for(int i = 0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		//입력 완료
		
		int garo = 0, sero = 0;
		for(int i = 0; i<N; i++) {
			int garoCnt = 0;
			for(int j = 0; j<N; j++) {
				if(arr[i][j] == '.') {
					garoCnt++;
					if(garoCnt==2) {
						garo++;
					}
				}
				else if(arr[i][j] == 'X') garoCnt=0;
			}
			garoCnt = 0;
		}
		
		for(int j = 0; j<N; j++) {
			int seroCnt = 0;
			for(int i = 0; i<N; i++) {
				if(arr[i][j] == '.') {
					seroCnt++;
					if(seroCnt==2) {
						sero++;
					}
				}
				else if(arr[i][j] == 'X') seroCnt = 0;
			}
			seroCnt = 0;
		}
		
		System.out.println(garo + " " + sero);
		
	}

}