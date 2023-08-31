
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N*2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N*2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//입력 완료

		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i<N*2; i++) {
			list.add(arr[i]);
		}

		int answer = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			int tmp = 0;
			tmp += list.get(0);
			tmp += list.get(list.size()-1);
			list.remove(0);
			list.remove(list.size()-1);
			answer = Math.min(answer, tmp);
		}

		System.out.println(answer);
	}
}

