import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* 부분집합, bfs */
/**
 * 인덱스는 1부터 받아줄 필요가 없다
 * 각 구는 1부터 N까지지지만 간선 정보를 -1해서 받아주고 0부터 처리해주면 됨
 */
public class Main {

	static int N;
	static int[] population;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] isSelected;
	static int res = Integer.MAX_VALUE;
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
		
		for(int i  = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j<cnt; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken())-1);
			}
		}
		//입력 완료
		
		isSelected = new boolean[N];
		divide(0);
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
		
	}

	private static void divide(int idx) {
		//기저 조건
		if(idx == N) {
			List<Integer> listA = new ArrayList<>();
			List<Integer> listB = new ArrayList<>();
			for(int i = 0; i<N; i++) {
				if(isSelected[i]) listA.add(i);
				else if(!isSelected[i]) listB.add(i);
			}
			
			//bfs 돌리기 전 몰빵된 곳 제거
			if(listA.size() == 0 || listB.size() == 0) return;
			
			if(bfs(listA) && bfs(listB)) {
				//최소값 연산
				int sum = 0;
				for(int a : listA) {
					sum += population[a];
				}
				for(int b : listB) {
					sum -= population[b];
				}
				res = Math.min(res, Math.abs(sum));
			}
			return;
		}
		
		isSelected[idx] = true;
		divide(idx+1);
		
		isSelected[idx] = false;
		divide(idx+1);
	}

	private static boolean bfs(List<Integer> list) {
		
		boolean[] visit = new boolean[N];
		int count = 0;
		
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(list.get(0));
		visit[list.get(0)] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			count++;
			for(int o : graph.get(tmp)) {
				if(!visit[o] && list.contains(o)) {
					visit[o] = true;
					q.offer(o);
				}
			}
		}
		return count == list.size();
	}
}
