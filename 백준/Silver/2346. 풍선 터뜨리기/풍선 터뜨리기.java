import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<int[]> deque = new ArrayDeque<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<N; i++) {
			deque.add(new int[] {i+1, Integer.parseInt(st.nextToken())});
		}
		
		int target = 0;
		while(!deque.isEmpty()) {
			
			int[] arr = deque.pollFirst();
			target = arr[1];
			sb.append(arr[0] + " ");
			
			if(target>0 && !deque.isEmpty()) {
				for(int i = 0; i<target-1; i++) {
					deque.addLast(deque.pollFirst());
				}
			}
			
			else if(target < 0 && !deque.isEmpty()) {
				for(int i = 0; i<Math.abs(target); i++) {
					deque.addFirst(deque.pollLast());
				}
			}
			
		}
		
		System.out.println(sb);
		
	}

}