import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//입력 완료
		
		int changeCnt = 0;
		List<Integer> answer = new ArrayList<>();
		
		A: for(int i = 0; i<N-1; i++) { //라운드 반복
			//System.out.println("i " + i);
			for(int j = 0; j<N-i-1; j++) {
				//System.out.println(j);
				if(arr[j] > arr[j+1]) {
					changeCnt++;
					if(changeCnt >= K) {
						answer.add(arr[j]);
						answer.add(arr[j+1]);
						break A;
					}
					
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		Collections.sort(answer);
		if(K <= changeCnt) {
			StringBuilder sb = new StringBuilder();
			for(int a: answer) {
				sb.append(a + " ");
			}
			System.out.println(sb);
		}
		
		else System.out.println(-1);
		
	}

}