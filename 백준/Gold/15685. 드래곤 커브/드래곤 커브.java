import java.io.*;
import java.util.*;

class Main {

	static int x, y, d, g = 0;
	static boolean[][] map = new boolean[101][101];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			draw(x, y, getDirections(d, g));
			
		}
		
		System.out.println(check());
	
	}
	
    public static List<Integer> getDirections(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);
 
        while (g-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int direction = (directions.get(i) + 1) % 4;
                directions.add(direction);
            }
        }
        return directions;
    }
	
    public static void draw(int x, int y, List<Integer> directions) {
        map[x][y] = true;
 
        for (int direction : directions) {
            switch (direction) {
                case 0:
                    map[++x][y] = true;
                    break;
                case 1:
                    map[x][--y] = true;
                    break;
                case 2:
                    map[--x][y] = true;
                    break;
                case 3:
                    map[x][++y] = true;
                    break;
            }
        }
    }
	
	public static int check() {
		int res = 0;
		
		for(int i = 0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					res++;
				}
			}
		}
		return res;
	}
	
}