import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			for(int i = 0; i<H; i++) {
				String line = br.readLine();
				for(int j = 0; j<W; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			//입력 완료
			
			//탱크 좌표 저장
			int tankX = 0;
			int tankY = 0;
			char tankDir = '0';
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						tankX = i;
						tankY = j;
						tankDir = map[i][j];
						map[i][j] = '.';
					}
				}
			}
			
			//시작
			for(int i = 0; i<N; i++) {
				if(input.charAt(i) == 'U') {
					tankDir = '^';
					if(tankX-1>=0 && map[tankX-1][tankY] == '.') {
						tankX -= 1;
					}
				}
				
				else if(input.charAt(i) == 'D') {
					tankDir = 'v';
					if(tankX+1<H && map[tankX+1][tankY] == '.') {
						tankX += 1;
					}
				}
				
				else if(input.charAt(i) == 'L') {
					tankDir = '<';
					if(tankY-1>=0 && map[tankX][tankY-1] == '.') {
						tankY -= 1;
					}
				}
				
				else if(input.charAt(i) == 'R') {
					tankDir = '>';
					if(tankY+1<W && map[tankX][tankY+1] == '.') {
						tankY += 1;
					}
				}
				
				else if(input.charAt(i) == 'S') {
					if(tankDir == '^') {
						for(int d = tankX; d>=0; d--) {
							if(map[d][tankY] == '*') {
								map[d][tankY] = '.';
								break;
							}
							else if(map[d][tankY] == '#') break;
						}
					}
					
					else if(tankDir == 'v') {
						for(int d = tankX; d<H; d++) {
							if(map[d][tankY] == '*') {
								map[d][tankY] = '.';
								break;
							}
							else if(map[d][tankY] == '#') break;
						}
					}
					
					else if(tankDir == '<') {
						for(int d = tankY; d>=0; d--) {
							if(map[tankX][d] == '*') {
								map[tankX][d] = '.';
								break;
							}
							
							else if(map[tankX][d] == '#') break;
						}
					}
					
					else if(tankDir == '>') {
						for(int d = tankY; d<W; d++) {
							if(map[tankX][d] == '*') {
								map[tankX][d] = '.';
								break;
							}
							
							else if(map[tankX][d] == '#') break;
						}
					}
				}
			}
			
			//전차 넣기
			map[tankX][tankY] = tankDir;
			 
			System.out.printf("#%d ", tc);
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					System.out.print(map[i][j]);
				} System.out.println();
			}
		
		}
		
	}
	
}