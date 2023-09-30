import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //걸그룹의 수
		int M = Integer.parseInt(st.nextToken()); //문제의 수
		
		HashMap<String, List<String>> map = new HashMap<>();
		for(int i = 0; i<N; i++) {
			List<String> list = new ArrayList<>();
			
			String teamName = br.readLine();
			int memberCnt = Integer.parseInt(br.readLine());
			
			for(int j = 0; j<memberCnt; j++) {
				list.add(br.readLine());
			}
			
			Collections.sort(list);
			map.put(teamName, list);
		}
		
		//System.out.println(map);
		for(int i = 0; i<M; i++) {
			String target = br.readLine();
			int type = Integer.parseInt(br.readLine());
			
			if(type == 1) { //멤버가 속한 팀이름 출력
				for(String key : map.keySet()) {
					if(map.get(key).contains(target)) {
						System.out.println(key);
						break;
					}
				}
			}
			
			else if(type == 0) { //팀이름에 속한 멤버 사전순 출력
				for(String key : map.keySet()) {
					if(key.equals(target)) {
						for(String member: map.get(key)) {
							System.out.println(member);
						}
					}
				}
			}
		}
		
	}

}