

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
	
	static ArrayList<Node>[] graph;
	static int[] dist;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		dist = new int[N+1];
		visit = new boolean[N+1];
		
		for(int i = 0; i<=N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = 200000000;
		}
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph[A].add(new Node(B, C));
			graph[B].add(new Node(A, C));
		}
		
		st = new StringTokenizer(br.readLine());
		int V1 = Integer.parseInt(st.nextToken());
		int V2 = Integer.parseInt(st.nextToken());
		
		int tmp1 = 0;
		tmp1 += dijkstra(1, V1);
		tmp1 += dijkstra(V1, V2);
		tmp1 += dijkstra(V2, N);
		
		int tmp2 = 0;
		tmp2 += dijkstra(1, V2);
		tmp2 += dijkstra(V2, V1);
		tmp2 += dijkstra(V1, N);
		
		int res = (tmp1 >= 200000000 && tmp2 >= 200000000) ? -1 : Math.min(tmp1, tmp2);
		System.out.println(res);
		
	}
	
	static int dijkstra(int start, int end) {
		Arrays.fill(dist, 200000000);
		Arrays.fill(visit, false);
		
		dist[start] = 0;
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		q.offer(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(!visit[now.idx]) visit[now.idx] = true;
			
			for(Node next: graph[now.idx]) {
				if(!visit[next.idx] && dist[next.idx] > dist[now.idx] + next.cost) {
					dist[next.idx] = now.cost + next.cost;
					q.offer(new Node(next.idx, dist[next.idx]));
				}
			}
			
		}
		
		return dist[end];
	}
	
}