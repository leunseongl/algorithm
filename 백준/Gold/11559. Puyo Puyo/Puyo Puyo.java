import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { -1, 0, 1, 0 };

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node [x=" + x + ", y=" + y + "]";
        }
    }

    static char[][] field;
    static Stack<Character> stack = new Stack<>(); //내리기 메소드용
    static boolean[][] visit;
    static int chain = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[12][6];
        for (int i = 0; i < 12; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                field[i][j] = cArr[j];
            }
        }
        // 입력 완료

        game();
        System.out.println(chain);
    }

    private static void game() {
        boolean isOver = false; // 게임이 끝났는지의 여부
        while (!isOver) {
            isOver = true;
            // 새 연쇄가 시작될 때마다 visit 배열 만들기
            visit = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] != '.') { // 빈 공간이 아니면
                    	if(bfs(i, j)) {
                            isOver = false; //하나라도 못깨면 isOver가 바뀌지 않음
                        }
                    }
                }
            }
            if(!isOver) { //하나라도 깼으면 연쇄+1
            	down();
            	chain++;
            }
        }
    }

    // 터질 수 있는 뿌요 찾고, 부시기
    private static boolean bfs(int x, int y) {
        List<Node> list = new ArrayList<>(); // 부술 애들 저장
        list.add(new Node(x, y)); //현재 값 꼭 넣어주기!!!!!
        
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
                    if (!visit[nx][ny] && field[cur.x][cur.y] == field[nx][ny]) {
                        // 조건을 다 충족하면
                        q.offer(new Node(nx, ny)); // 큐에 넣고
                        visit[nx][ny] = true; // 방문처리
                        list.add(new Node(nx, ny)); // 부수기 위해 list에 저장
                    }
                }
            }

        }

        // list에 부술 애들이 4개 이상이 아니라면 false 반환
        if (list.size() < 4) {
        	return false;
        }

        // 4개 이상이라면 부수고 true 반환
        else {
            for (int k = 0; k < list.size(); k++) {
                int bx = list.get(k).x;
                int by = list.get(k).y;
                field[bx][by] = '.';
            }
        }
        return true;
    }
    
    // 내리기
    private static void down() {
    	for(int i = 0; i<6; i++) {
    		for(int j = 0; j<12; j++) {
    			if(field[j][i] != '.' ) {
    				stack.push(field[j][i]);
    				field[j][i] = '.';
    			}
    		}
    		int x = 11; //12-1
    		while(!stack.isEmpty()) {
    			field[x--][i] = stack.pop();
    		}
    	}	
    }
}