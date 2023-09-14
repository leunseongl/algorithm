import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 게임 종류에 따라 사람 명수(자기자신 포함) 세서 그 명수 되면 answer+1
 * 여태까지 한 사람을 세기 위해 set에 했던 사람들 다 집어넣기
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //게임 신청 횟수
		String type = st.nextToken(); //게임 종류
		
		int goalCnt = 0; //게임마다 목표 인원
		if(type.equals("Y")) goalCnt = 1;
		else if(type.equals("F")) goalCnt = 2;
		else if(type.equals("O")) goalCnt = 3;
		
		int answer = 0;
		int cnt = 0;
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0; i<N; i++) {
			String tmp = br.readLine();
			if(!set.contains(tmp)) {
				set.add(tmp);
				cnt++;
				if(cnt == goalCnt) {
					answer++;
					cnt = 0;
				}
			}
		}

		System.out.println(answer);
		
	}

}