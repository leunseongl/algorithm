import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

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
		
		int left = 0, right = 0, answer = 0;
		int[] check = new int[100001];
		
		while(right<arr.length) {
			while(right<arr.length && check[arr[right]]+1<=K) {
				check[arr[right]]++;
				right++;
			}
			answer = Math.max(right-left, answer);
			check[arr[left]]--;
			left++;
		}
		
		System.out.println(answer);
	}

}