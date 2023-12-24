import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static boolean[] visit;
	static int[] distance;
	static List<List<Integer>> graph;
	
	static class Data {
		int num, cnt;
		public Data(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i = 0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
		}
		
		visit = new boolean[N+1];
		distance = new int[N+1];
		for(int i = 1; i<=N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		dijkstra(X);
		
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			if(distance[i] == K) {
				flag = true;
				sb.append(i + "\n");
			}
		}
		
		if(flag) System.out.println(sb);
		else System.out.println(-1);
	}

	private static void dijkstra(int start) {
		
		visit[start] = true;
		distance[start] = 0;
		
		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
		pq.offer(new Data(start, 0));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			//System.out.println("Cur " + cur.num + " " + cur.cnt);
			if(!visit[cur.num]) visit[cur.num] = true;
			
			for(Integer next: graph.get(cur.num)) {
				//System.out.println(next);
				if(!visit[next] && distance[next]>cur.cnt+1) {
					distance[next] = cur.cnt+1;
					pq.offer(new Data(next, distance[next]));
				}
			}
			
		}
		
	}
	
}