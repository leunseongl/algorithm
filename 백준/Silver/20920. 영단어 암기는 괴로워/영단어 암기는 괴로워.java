import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			if(s.length() < M) continue;
		
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}
			else {
				map.put(s, 1);
			}
		}
		
		//System.out.println(map);
		List<String> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 자주 등장하는 단어 순서대로 정렬
		        if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
		            return Integer.compare(map.get(o2), map.get(o1));
		        }
		        // 등장 횟수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
		        if (o1.length() != o2.length()) {
		            return o2.length() - o1.length();
		        }
		        // 등장 횟수와 길이가 같으면 사전 순으로 정렬
		        return o1.compareTo(o2);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<keyList.size(); i++) {
			sb.append(keyList.get(i) + "\n");
		}
		System.out.println(sb);
	}

}