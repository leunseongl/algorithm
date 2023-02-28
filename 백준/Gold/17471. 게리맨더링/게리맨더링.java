import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* 부분집합, BFS */
public class Main {

	static int N;
	static int[] population;
	static boolean[] select;
	static List<List<Integer>> graph = new ArrayList<>();
	static int res = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //구역의 개수 N
		
		population = new int[N]; //각 구역별 인원 수
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
				int tmp = Integer.parseInt(st.nextToken());
				graph.get(i).add(tmp-1);
			}
		}
		//입력 완료
		
		//부분집합 돌리기
		select = new boolean[N];
		divide(0);
		
		
		System.out.println(res == Integer.MAX_VALUE? -1 : res);
	}
	
	//부분집합으로 선거구 나누기
	private static void divide(int cnt) {
		if(cnt == N) {
			List<Integer> listA = new ArrayList<>();
			List<Integer> listB = new ArrayList<>();
			for(int i = 0; i<N; i++) {
				if(select[i]) {
					listA.add(i);
				}
				
				else {
					listB.add(i);
				}
			}
			
			//조건처리 -> 선거구는 구역을 적어도 하나 포함해야 함, 몰빵되면 bfs를 돌리지 않음
			if(listA.size() == 0 || listB.size() == 0) return;
			
			if(bfs(listA) && bfs(listB)) { //두 선거구 모두 연결이 됐을 경우
				//두 개의 인구 차 최솟값
				int sumA = 0;
				int sumB = 0;
				for(int a : listA) {
					sumA += population[a];
				}
				for(int b : listB) {
					sumB += population[b];
				}
				res = Math.min(res, Math.abs(sumA-sumB));
			}
			
			return;
			
		}
		
		select[cnt] = true;
		divide(cnt+1);
		
		select[cnt] = false;
		divide(cnt+1);
		
	}
	
	//시작점부터 갈 수 있는 곳 다 가기
	private static boolean bfs(List<Integer> list) {
		//몇 개 구가 연결 되어있는지 count를 세고
		//탐색 후에 list.size()랑 count랑 같으면 true반환
		
		boolean[] visit = new boolean[N];
		
		Queue<Integer> q = new ArrayDeque<>(); //큐에는 구역이 들어가고, 내 코드는 0번부터
		q.offer(list.get(0));
		visit[list.get(0)] = true; //시작점 방문처리 (까먹지 말자..)
		int count = 0;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			count++;
			for(int o : graph.get(tmp)) {
				if(!visit[o] && list.contains(o)) { //방문 안했고, 나한테서 갈 수 있고, 현재 리스트에 있는 경우
					visit[o] = true;
					q.offer(o);
				}
			}
		}
		return count == list.size();
	}

}