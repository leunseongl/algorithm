import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 길은 양방향 통행
 * 어디에 떨어질지 골라야 하므로, 모든 곳에서 시작해보기
 * 가다가 통행 거리 체크해서 bfs 돌리기
 */
public class Main {

	static int N, M, answer;
	static int[] item;
	static int[] dist;
	static boolean[] visit;
	static List<List<Info>> graph;
	
	static class Info {
		int num, value;
		public Info(int num, int value) {
			this.num = num;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //지역 개수
		M = Integer.parseInt(st.nextToken()); //수색 범위
		int R = Integer.parseInt(st.nextToken()); //길의 개수
		
		item = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
 		}
		
		graph = new ArrayList<>();
		for(int i = 0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Info(b, c));
			graph.get(b).add(new Info(a, c));
		}
		//입력 완료
		
		answer = 0;
		for(int i = 1; i<=N; i++) {
			reset();
			dijkstra(i);
			//System.out.println(Arrays.toString(dist));
		}
		
		System.out.println(answer);
	}
	
	private static void dijkstra(int start) {
		visit = new boolean[N+1];
		visit[start] = true;
		dist[start] = 0;
		
		PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.value-o2.value);
		pq.offer(new Info(start, 0));
		
		while(!pq.isEmpty()) {
			Info cur = pq.poll();
			
			if(!visit[cur.num]) visit[cur.num] = true;
			
			for(Info next: graph.get(cur.num) ) {
				if(!visit[next.num] && dist[next.num]>cur.value+next.value) {
					dist[next.num] = cur.value+next.value;
					pq.offer(new Info(next.num, dist[next.num]));
				}
			}
		}
		
		int sum = 0;
		for(int i = 1; i<=N; i++) {
			if(dist[i]<=M) sum += item[i];
		}
		answer = Math.max(sum, answer);
	}
	
	private static void reset() {
		dist = new int[N+1];
		for(int i = 1; i<=N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
	}

}