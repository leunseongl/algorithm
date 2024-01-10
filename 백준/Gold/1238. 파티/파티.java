import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * N명의 학생, X번 마을에 모이기, 단방향 
 * 파티 갔다가 돌아와야 함
 * 오고 가는데 가장 많은 시간을 소비하는 학생의 소요시간 출력
 */
public class Main {
	
	static int N, X;
	static List<List<Data>> graph1;
	static List<List<Data>> graph2;
	
	static class Data {
		int num, cost;
		public Data(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}
	
 	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph1 = new ArrayList<>();
		graph2 = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			graph1.add(new ArrayList<>());
			graph2.add(new ArrayList<>());
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			graph1.get(a).add(new Data(b, c));
			graph2.get(b).add(new Data(a, c));
		}
		//입력 완료
		
		int[] dist1 = dijkstra(graph1);
		int[] dist2 = dijkstra(graph2);
 		
// 		System.out.println(Arrays.toString(dist1));
// 		System.out.println(Arrays.toString(dist2));
		
		int answer = 0;
		for(int i = 0; i<N; i++) {
			answer = Math.max(answer, dist1[i]+dist2[i]);
		}
		
		System.out.println(answer);
	}
 	
 	private static int[] dijkstra(List<List<Data>> list) {
 		
 		int[] dist = new int[N];
 		Arrays.fill(dist, 987654321);
 		dist[X-1] = 0;
 		
 		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
 		pq.offer(new Data(X-1, 0));
 		
 		while(!pq.isEmpty()) {
 			Data cur = pq.poll();
 			if(dist[cur.num] < cur.cost) continue;
 			
 			for(Data o: list.get(cur.num)) {
 				if(dist[o.num] > cur.cost+o.cost) {
 					dist[o.num] = cur.cost+o.cost;
 					pq.offer(new Data(o.num, dist[o.num]));
 				}
 			}
 		}
 		
 		return dist;
 		
 	}
}