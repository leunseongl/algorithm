import java.util.*;
/*
완전탐색 - 다 해봐야 한다 (둘다 0으로 점수 받기 포기, 어피치 이기기, 어피치한테 지기)
근데 너무 많지 않나? 점수가 10갠데, 백트래킹 생각해야 할듯
라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
이런 조건이 있었구나...하하
*/
class Solution {
    static int N, maxMinus;
    static int[] arr;
    static int[] answer = {-1};
    public int[] solution(int n, int[] info) {
        N = n;
        maxMinus = -1;
        arr = new int[11];
        dfs(info, 0, 0);

        return answer;
    }
    
    //idx는 점수 0~10까지 접근, cnt는 사용한 화살 수
    private static void dfs(int[] apeach, int idx, int cnt) {
        if(idx == 11) { //점수 접근을 다 했으면
            //화살 다 썼는지 확인하고 다 썼으면 점수 계산
            if(cnt == N) {
                //System.out.println(Arrays.toString(arr));
                int apScore = 0, liScore = 0;
                for(int i = 0; i<11; i++) {
                    if(apeach[i] == 0 && arr[i] == 0) {
                        //System.out.println(i);
                        continue;
                    }
                    if(apeach[i]>=arr[i]) apScore += 10-i;
                    else liScore += 10-i;
                    //System.out.println("lion " + liScore + " apeach " + apScore);
                }
                
                if(liScore>apScore) {
                    //라이언이 가장 큰 차이로 이기는 경우
                    if(liScore-apScore > maxMinus) {
                        maxMinus = liScore-apScore;
                        answer = arr.clone();
                        //System.out.print("큰차이" + maxMinus);
                        //System.out.println(Arrays.toString(arr));
                    }
                    //라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우
                    else if(liScore-apScore == maxMinus) {
                        //System.out.println(Arrays.toString(answer));
                        //System.out.print("여러가지" + maxMinus);
                        //System.out.println(Arrays.toString(arr));
                        for(int i = 10; i>=0; i--) {
                            if(answer[i]<arr[i]) {
                                answer = arr.clone();
                                return;
                            }
                            else if(answer[i]>arr[i]) return;
                        }
                    }
                }
            }
            return;
        }
        
        //둘다 0으로 점수 받기 포기
        if(apeach[idx] == 0) {
            dfs(apeach, idx+1, cnt);
        }
        
        //어피치 이기기
        if(cnt+1+apeach[idx] <= N) { //현재까지 사용한 화살 수+1에 어피치 화살 수를 더해도 전체 화살 수가 넘지 않으면
            arr[idx] = apeach[idx]+1;
            dfs(apeach, idx+1, cnt+1+apeach[idx]);
            arr[idx] = 0;
        }
        
        //어피치한테 지기
        if(apeach[idx] != 0) {
            for(int i = 0; i<=apeach[idx]; i++) {
                arr[idx] = i;
                dfs(apeach, idx+1, cnt+i);
                arr[idx] = 0;
            }
        }
        
    }
}