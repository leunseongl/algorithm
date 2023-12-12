import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int N = commands.length; //commands의 개수
        List<Integer> answerList = new ArrayList<>();
        
        for(int i = 0; i<N; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int num = commands[i][2];
            // int[] arr = new int[end-start+1];
            List<Integer> list = new ArrayList<>();
            
            for(int j = start-1; j<end; j++) {
                list.add(array[j]);
            }   
            
            Collections.sort(list);
            answerList.add(list.get(num-1));
        }
        
        int[] answer = new int[N];
        for(int i = 0; i<N; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}