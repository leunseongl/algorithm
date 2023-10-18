import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Node = Integer.parseInt(br.readLine());
		int Edge = Integer.parseInt(br.readLine());
		
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i<=Node; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i<Edge; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
//		for(int i = 1; i<graph.size(); i++) {
//			System.out.println(graph.get(i));
//		}
		
	
		boolean[] visit = new boolean[Node+1];
		visit[1] = true;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		
		int answer = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int o : graph.get(cur)) {
				if(!visit[o]) {
					visit[o] = true;
					q.offer(o);
					if(o != 1) answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}