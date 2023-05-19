import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] population;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visit;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		population = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		//인접 리스트 초기화
		for(int i = 0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j<n; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken())-1);
			}
		
		}
		//입력 완료
		
		visit = new boolean[N];
		divide(0);
		
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
	
	//부분 집합
	private static void divide(int cnt) {

		//부분집합 한 개 완성 시
		if(cnt == N) {
			List<Integer> listA = new ArrayList<Integer>();
			List<Integer> listB = new ArrayList<Integer>();
			
			for(int i = 0; i<N; i++) {
				if(visit[i]) listA.add(i);
				else listB.add(i);
			}
			
			if(listA.size() == 0 || listB.size() == 0) return;
			
			if(bfs(listA) && bfs(listB)) {
				int one = 0;
				for(int o : listA) {
					one += population[o];
				}
				
				int two = 0;
				for(int o : listB) {
					two += population[o];
				}
				
				answer = answer>Math.abs(one-two)?Math.abs(one-two):answer;
			}
			
			return;
		}
		
		visit[cnt] = true;
		divide(cnt+1);
		
		visit[cnt] = false;
		divide(cnt+1);
	}

	private static boolean bfs(List<Integer> list) {

		boolean[] visit = new boolean[N];
		visit[list.get(0)] = true;
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(list.get(0));
		
		int count = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			count++;
			
			for(int o : graph.get(cur)) {
				if(!visit[o] && list.contains(o)) {
					visit[o] = true;
					q.offer(o);
				}
			}
		}
		
		if(count == list.size()) return true;
		else return false;
	}
	
}