import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] info = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		//입력 완료
		
		int[] line = new int[N];
		
		for(int i = 0; i<N; i++) {
			int target = 0, cnt = 0;
			target = info[i];
			for(int j = 0; j<N; j++) {
				if(line[j] == 0) {
					cnt++;
					if(cnt == target+1) {
						line[j] = i+1;
					}
				}
			}
		}
		
		for(int i = 0; i<N; i++) {
			System.out.print(line[i] + " ");
		}
		
	}
	
}