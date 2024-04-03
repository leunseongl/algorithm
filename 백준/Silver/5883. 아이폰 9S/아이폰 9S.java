import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		int[] numbers = new int[N];
		for(int i = 0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			numbers[i] = input;
			set.add(input);
		}
		//입력 완료

		int answer = 1;
		for(int o: set) {
			//System.out.println("cur " + o);
			int cnt = 1;
			int pre = 1000001;
			
			for(int j = 1; j<N; j++) {
				if(numbers[j] == o) continue;
				//System.out.println(pre + " " + numbers[j]);
				
				if(pre != numbers[j]) cnt = 1;
				else {
					cnt++;
					answer = Math.max(cnt,  answer);
				}
				
				pre = numbers[j];
			}
			//System.out.println();
			//System.out.println(cnt);
		}
		
		
		System.out.println(answer);
	}

}