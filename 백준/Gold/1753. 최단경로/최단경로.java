import java.io.*;
import java.util.*;


public class Main {
	
	static class Node {
		int idx;
		int cost;
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	
	static ArrayList<Node>[] graph; //노드 정보
	static boolean[] visit; //방문 여부
	static int[] dist; //최단 거리
	
	
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ve = br.readLine().split(" ");
		int V = Integer.parseInt(ve[0]);
		int E = Integer.parseInt(ve[1]);
		int K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		visit = new boolean[V+1];
		dist = new int[V+1];
		
		for(int i = 0; i<=V; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph[A].add(new Node(B, C));
		}
		
		dijkstra(K);
		
		for(int i = 1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}	
		
	}
	
	static void dijkstra(int start) {
		//가중치 기준 오름차순
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(!visit[now.idx]) {
				visit[now.idx] = true;
			}
			
			for(Node next: graph[now.idx]) {
				if(!visit[next.idx] && dist[next.idx] > now.cost + next.cost) {
					dist[next.idx] = now.cost + next.cost;
					q.add(new Node(next.idx, dist[next.idx]));
				}
			}
			
		}
		
	}
	
}