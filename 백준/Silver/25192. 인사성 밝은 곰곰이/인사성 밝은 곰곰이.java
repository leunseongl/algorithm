import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * ENTER가 나오면 맵 초기화 해가면서 처음 말하는건지 체크
 *
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i<N; i++) {
			String chat = br.readLine();
			
			if(chat.equals("ENTER")) {
				map = new HashMap<>();
			}
			
			else {
				if(map.containsKey(chat)) {
					map.put(chat, map.get(chat)+1);
				}
				else {
					answer++;
					map.put(chat, 1);
				}
			}
			
		}
		
		System.out.println(answer);
		
		
	}

}