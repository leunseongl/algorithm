import java.util.*;

class Solution {
    
    static List<List<Data>> graph;
    static boolean[] visit;
    
    static class Data {
        int num, cost;
        public Data(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        graph = new ArrayList<>();
        for(int i = 0; i<=n; i++) {
            graph.add(new ArrayList());
        }
        
        for(int i = 0; i<fares.length; i++) {
            int x = fares[i][0];
            int y = fares[i][1];
            int z = fares[i][2];
            graph.get(x).add(new Data(y, z));
            graph.get(y).add(new Data(x, z));
        }
        
        int[] together = dijkstra(s, n); //함께 타는 거 계산
        int[] aloneA = dijkstra(a, n); //a 혼자
        int[] aloneB = dijkstra(b, n); //b 혼자
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i<=n; i++) {
            int tmp = together[i] + aloneA[i] + aloneB[i];
            if(answer>tmp) answer = tmp;
        }
        
        return answer;
    }
    
    private static int[] dijkstra(int start, int N) {
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
        pq.offer(new Data(start, 0));
        
        while(!pq.isEmpty()) {
            Data cur = pq.poll();
            
            if(dist[cur.num] < cur.cost) continue;
            
            for(Data next: graph.get(cur.num)) {
                if(dist[next.num]>cur.cost+next.cost) {
                    dist[next.num] = cur.cost+next.cost;
                    pq.offer(new Data(next.num, dist[next.num]));
                }
            }
            
        }
        
        //System.out.println(Arrays.toString(dist));
        return dist;
    }
}