import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i<N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i<N-1; i++) {
			String[] line = br.readLine().split(" ");
			list.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
			list.get(Integer.parseInt(line[1])).add(Integer.parseInt(line[0]));
		}
		
		//System.out.println(list);
		
		int[] parents = new int[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(list.get(cur).size() != 0) {
				for(int o: list.get(cur)) {
					if(parents[o] == 0) {
						parents[o] = cur;
						q.offer(o);
					}
				}
			}
		}
		
		for(int i = 2; i<N+1; i++) {
			System.out.println(parents[i]);
		}
	}

}