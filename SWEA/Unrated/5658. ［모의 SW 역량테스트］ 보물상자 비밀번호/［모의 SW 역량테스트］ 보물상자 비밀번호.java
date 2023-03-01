import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

//크기 순서를 셀 때 같은 수를 중복으로 세지 않도록 주의
public class Solution {

	static HashSet<Integer> set;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //숫자의 개수 N/4(4개 변)
			int K = Integer.parseInt(st.nextToken()); //크기 순서, K번째 수
			String line = br.readLine();
			StringBuilder sb = new StringBuilder();
			sb.append(line);
			//입력 완료
			
			set = new HashSet<>();
			
			//초기 회전, 0번째
			String tmp = "";
			for(int i = 0; i<N; i++) {
				tmp += sb.charAt(i); 
				if(tmp.length() == N/4) { //tmp가 N/4개가 되면
					int demical = Integer.parseInt(tmp, 16); //16진수를 10진수로 바꾸고
					set.add(demical); //집합에 넣어주기
					tmp = ""; //tmp 초기화
				}
			}
			
			//회전 수는 N/4-1?
			//아니고 걍 두번?
			
			//회전 시작
			tmp = "";
			for(int i = 0; i<N/4-1; i++) {
				sb.insert(0, sb.charAt(sb.length()-1)); //sb의 맨 뒤에 값을 앞에 붙이고
				sb.deleteCharAt(sb.length()-1); //맨 뒤에 값 삭제
				//1회 회전 완료
				
				for(int j = 0; j<N; j++) {
					tmp += sb.charAt(j);
					if(tmp.length() == N/4) {
						int demical = Integer.parseInt(tmp, 16); //16진수를 10진수로 바꾸고
						set.add(demical);
						tmp = "";
					}
				}
			}
			
			//K번째 수 찾기
			List<Integer> list = new ArrayList<>();
			for(Integer d: set) {
				list.add(d);
			}

			Collections.sort(list, Collections.reverseOrder()); //내림차순 정렬
			
			System.out.printf("#%d %d%n", tc, list.get(K-1));
		}
		
	}

}