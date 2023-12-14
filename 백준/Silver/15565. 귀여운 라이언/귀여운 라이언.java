import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 라이언 1, 어피치 2로 표시
 * 라이언 인형이 K개 이상 있는 가장 작은 연속된 인형들의 집합 크기를 구하여라
 * 두 포인터는 시간초과 남
 * -> 라이언 인형이 K개 이상 있는 가장 작은이므로 결국 라이언 인형은 K개면 된다..
 * 이 문제의 함정이었음..
 * 슬라이딩 윈도우로 해결 가능 - 라이언의 위치를 받아 슬라이딩 윈도우
 */

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		List<Integer> lion = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]==1) lion.add(i);
		}
		//입력 완료
		
		int answer = Integer.MAX_VALUE;
		if(K>lion.size()) answer = -1;
		else {
			int left = 0, right = K-1;
			
			while(right<lion.size()) {
				answer = Math.min(answer, lion.get(right)-lion.get(left)+1);
				
				left++;
				right++;
			}
		}
		
		System.out.println(answer);
	}

}