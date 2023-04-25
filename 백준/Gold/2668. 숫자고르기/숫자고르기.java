import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N;
	static int[] numbers;
	static boolean[] visit;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N+1];
		for(int i = 1; i<=N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		//입력 완료

		visit = new boolean[N+1];
		for(int i = 1; i<=N; i++) {
			dfs(i, i);
		}
		
		System.out.println(list.size());
		for(int i: list) {
			System.out.println(i);
		}
	}
	
	private static void dfs(int start, int num) {

		//기저 조건 - 현재 재귀함수의 num이 시작 노드와 같으면
		if(numbers[num] == start) {
			list.add(start);
		}
		
		visit[num] = true;
		
		if(!visit[numbers[num]]) {
			dfs(start, numbers[num]);
		}
		
		visit[num] = false;
		
	}
}