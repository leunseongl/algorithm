import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] setA = new int[A];
		int[] setB = new int[B];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<A; i++) {
			setA[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<B; i++) {
			setB[i] = Integer.parseInt(st.nextToken());
		}
		//입력 완료
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<A; i++) {
			map.put(setA[i], 1);
		}
		
		for(int i = 0; i<B; i++) {
			if(map.containsKey(setB[i])) {
				map.put(setB[i], 2);
			}
		}
		
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		for(int o: map.keySet()) {
			if(map.get(o) == 1) {
				answer++;
				list.add(o);
			}
		}
		
		if(answer != 0) {
			Collections.sort(list);
			System.out.println(answer);
			
			for(int i = 0; i<list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
		
		else {
			System.out.println(answer);
		}
		
	}

}