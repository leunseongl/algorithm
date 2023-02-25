import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* BFS, 인접리스트 버전 */
public class Solution {

	static int N, M;
	static List<List<Integer>> graph;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			
			//인접리스트는 초기화 필요
			for(int i = 0; i<=N; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			//입력 완료
			
			int count = 0;
			visit = new boolean[N+1];
			for(int i = 1; i<=N; i++) {
				if(!visit[i]) {
					count++;
					visit[i] = true;
					BFS(i);
				}
			}
			
			System.out.printf("#%d %d%n", tc, count);
		}
	}
	
	private static void BFS(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int pop = q.poll();
			
			for(int o : graph.get(pop)) {
				if(!visit[o]) {
					visit[o] = true;
					q.offer(o);
				}
			}
		}
		
	}

}