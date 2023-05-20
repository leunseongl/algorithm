import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, protein, fat, carbo, vitamin, answer;
	static int[][] info;
	static boolean[] isSelect;
	static List<String> answerList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		protein = Integer.parseInt(st.nextToken());
		fat = Integer.parseInt(st.nextToken());
		carbo = Integer.parseInt(st.nextToken());
		vitamin = Integer.parseInt(st.nextToken());
		
		info = new int[N][5];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		answer = Integer.MAX_VALUE;
		answerList = new ArrayList<>();
		isSelect = new boolean[N];
		subset(0);
		
		if(answer == Integer.MAX_VALUE) { //조건을 만족하는 값이 없었다면
			System.out.println(-1);
		}
		else {
			Collections.sort(answerList); //여러 개일 경우 사전순으로 출력하기 위한 정렬
			System.out.println(answer);
			System.out.println(answerList.get(0)); //정렬 후 첫 번째 값 출력
		}
		
	}
	
	//부분집합
	private static void subset(int cnt) {
		
		if(cnt == N) {
			List<Integer> picked = new ArrayList<>();
			for(int i = 0; i<N; i++) {
				if(isSelect[i]) picked.add(i);
			}
			//System.out.println(picked); 
			//공집합은 빼고 조건 확인하러 고고
			if(picked.size()>0) check(picked);
			return;
		}
		
		isSelect[cnt] = true;
		subset(cnt+1);
		
		isSelect[cnt] = false;
		subset(cnt+1);
		
	}
	
	//조건을 만족하는지 체크
	private static void check(List<Integer> list) {
		
		//단백질, 지방, 탄수화물, 비타민, 가격 더해 줄 변수
		int p = 0, f = 0, c = 0, v = 0, cost = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<list.size(); i++) {
			int cur = list.get(i); //재료 하나 꺼내서
			p += info[cur][0];
			f += info[cur][1];
			c += info[cur][2];
			v += info[cur][3];
			cost += info[cur][4];
			cur++;
			sb.append(cur + " ");
		}
		
		//조건을 만족한다면
		if(p>=protein && f>=fat && c>=carbo && v>= vitamin) {
			if(answer > cost) { //현재 저장되어 있는 값보다 cost가 싸다면
				answer = cost; //저장되어 있는 값 갱신
				answerList.clear();
				answerList.add(sb.toString()); //정답 리스트에 현재 선택된 재료들 이어붙인 거 넣기
			}
			else if(answer == cost) { //현재 저장되어 있는 값과 cost가 같다면
				answerList.add(sb.toString());
			}
		}
		
	}
	
}