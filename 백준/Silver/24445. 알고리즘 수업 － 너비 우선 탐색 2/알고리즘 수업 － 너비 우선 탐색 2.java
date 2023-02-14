import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<List<Integer>> graph = new ArrayList<>();
	static int[] visit;
	static int num = 1;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
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
		
		for(int i = 1; i<=N; i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		
		visit = new int[N+1];
		visit[R] = 1;
		BFS(R);
		
		for(int i = 1; i<=N; i++) {
			System.out.println(visit[i]);
		}

	}
	
	private static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>(); 
		q.add(start);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int z : graph.get(tmp)) {
				if(visit[z] == 0) {
					visit[z] = num+1;
					num++;
					q.add(z);
				}
			}
		}
	}

}