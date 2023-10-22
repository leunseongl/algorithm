import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Data {
		int idx, val;
		public Data(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		@Override
		public String toString() {
			return "Data [idx=" + idx + ", val=" + val + "]";
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		List<List<Data>> graph = new ArrayList<>();
		for(int i = 0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		//2차원 리스트 초기화
		
		for(int i = 0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Data(b, c));
			graph.get(b).add(new Data(a, c));
		}
		//인접 리스트 받기
		
//		for(int i = 0; i<N+1; i++) {
//			System.out.println(graph.get(i));
//		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			boolean[] visit = new boolean[N+1];
			visit[v] = true;
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(v);
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(Data d : graph.get(cur)) {
					if(!visit[d.idx] && d.val >= K) {
						q.offer(d.idx);
						visit[d.idx] = true;
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

}
