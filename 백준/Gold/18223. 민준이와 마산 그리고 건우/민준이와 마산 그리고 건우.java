import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V, E, P;
	static List<List<Data>> graph;
	static int[] dist;
	static String answer;
	
	static class Data {
		int num, cost;
		public Data(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Data [num=" + num + ", cost=" + cost + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); //정점 개수
		E = Integer.parseInt(st.nextToken()); //간선 개수
		P = Integer.parseInt(st.nextToken()); //건우 위치 정점
		
		graph = new ArrayList<>();
		for(int i = 0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Data(b, c));
			graph.get(b).add(new Data(a, c));
		}
		//입력 완료
		
//		for(int i = 1; i<=V; i++) {
//			System.out.println(graph.get(i));
//		}
		
		dist = new int[V+1];
		dijkstra(1);
		int minCost = dist[V];
		int pCost = dist[P];
		
		dijkstra(P);
		System.out.println(minCost == pCost+dist[V] ? "SAVE HIM": "GOOD BYE");
		
	}

	private static void dijkstra(int start) {
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		pq.add(new Data(start, 0));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			
			if(dist[cur.num] < cur.cost) continue;
			
			for(Data next: graph.get(cur.num)) {
				if(dist[next.num] > cur.cost+next.cost) {
					dist[next.num] = cur.cost+next.cost;
					pq.offer(new Data(next.num, dist[next.num]));
				}
			}
		}
		
	}
}