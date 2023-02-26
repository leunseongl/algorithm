import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 순열 활용 */
//입력 1번 선수는 4번 타자로 고정, 그 외 나머지 타순을 순열로

public class Main {

	static int N;
	static int[][] players; //N번째 이닝에서 타자의 행동
	static boolean[] selected; //순열에서 사용
	static int[] lineUp; //타자 순서 (idx 순서에 value 값 선수번호)
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		players = new int[N+1][10]; // ? -> N까지 +1 하는 이유
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료
		
		selected = new boolean[10];
		lineUp = new int[10];
		
		//중요! 4번 타자는 1번 선수로 고정
		selected[4] = true;
		lineUp[4] = 1;
		
		answer = 0;
		permutation(2); //1번 선수는 4번 자리에 고정 되어 있으므로 2번 선수부터
		
		System.out.println(answer);
		
	}
	
	private static void permutation(int num) {
		
		if(num == 10) {
//			System.out.println(Arrays.toString(lineUp));
			play();
			return;
		}
		
		for(int i = 1; i<=9; i++) {
			if(!selected[i]) {
				selected[i] = true;
				lineUp[i] = num;
				permutation(num+1);
				selected[i] = false;
			}
		}
	}
	
	private static void play() {
		int score = 0;
		int startPlayer = 1; //이닝에서 처음 시작하는 타자
		boolean[] base; //홈, 1루, 2루, 3루
		
		for(int i = 1; i<=N; i++) { //N번째 이닝까지 실행 가능
			int outCnt = 0;
			base = new boolean[4]; //이닝 시작할 때마다 베이스 초기화
			
			outer: while(true) {
				for(int j = startPlayer; j<=9; j++) { //선수 순서 접근
					int hitter = players[i][lineUp[j]]; //i번째 이닝에 lineUp[j]번째 선수의 행동
					
					switch(hitter) {
					case 0: //아웃일 경우
						outCnt++;
						break;
					case 1: //안타일 경우
						for(int k = 3; k>=1; k--) { //1~3루
							if(base[k]) { //베이스에 한명이라도 선수가 있으면
								if(k == 3) { //3루에 선수가 있다면
									score++; //점수 획득
									base[k] = false; //3루는 비어있게 됨
									continue;
								}
								
								//1, 2루에 선수가 있다면 1루씩 진루하고 원래 있던 자리는 비어있게 됨
								base[k] = false;
								base[k+1] = true;
							}
						}
						base[1] = true; //홈에서 1루로 진루
						break; //switch case문 break
						
					case 2: //2루타일 경우
						for(int k = 3; k>=1; k--) {
							if(base[k]) {
								if(k == 2 || k == 3) { //2루, 3루에 선수가 있다면
									score++;
									base[k] = false;
									continue;
								}
								
								//1루에 선수가 있다면 2루씩 진루하고 원래 있던 자리는 비어있게 됨
								base[k] = false;
								base[k+2] = true;
							}
						}
						base[2] = true; //홈에서 2루로 진루
						break; //switch case문 break
						
					case 3: //3루타일 경우
						for(int k = 3; k>=1; k--) { //1~3루
							if(base[k]) { //홈 제외 모든 선수는 홈으로 들어옴
								score++;
								base[k] = false;
								continue;
							}	
						}
						base[3] = true; //홈에서 3루로
						break; //switch case문 break
						
					case 4: //홈런일 경우
						for(int k = 3; k>=1; k--) { //1~3루
							if(base[k]) { //모든 선수는 홈으로 들어옴
								score++;
								base[k] = false;
								continue;
							}	
						}
						score++; //홈런 친 타자의 점수 1점 추가
						break; //switch case문 break
					}
					
					if(outCnt == 3) { //아웃 카운트가 3개 일 경우
						//startPlayer를 그 다음 타자로 초기화 함
						startPlayer = j+1;
						if(startPlayer == 10) startPlayer = 1;
						break outer; //그 이닝 종료
					}
				}
				// 1~9번까지 타자가 한 이닝에 전부 안타를 쳐서 아웃카운트가 발생하지 않게 되면,
                // 위 반복문이 무한 루프를 돌기때문에 startPlayer = 1로 초기화해야 함.
				startPlayer = 1;
			}
		}
		answer = Math.max(answer, score);
	}

}
