class Solution {
	
	static int[] c_info;
	static int[][] c_edges;
	static int res = 0;
	
	public static int solution(int[] info, int[][] edges) {
        c_info = info;
        c_edges = edges;
        boolean[] visit = new boolean[info.length];
        dfs(0,visit,0,0);
        return res;
    }
	
	public static void dfs(int idx, boolean[] visit, int sheep, int wolf) {
		visit[idx] = true;
		if(c_info[idx] == 0) {
			sheep++;
			if(sheep>res) res = sheep;
		} else {
			wolf++;
		}
		
		if(sheep<=wolf) return;
		
		for(int[] edge: c_edges) {
			if(visit[edge[0]] && !visit[edge[1]]) {
				boolean[] new_visit = new boolean[visit.length];
				for(int i = 0; i<visit.length; i++) {
					new_visit[i] = visit[i];
				}
				
				dfs(edge[1], new_visit, sheep, wolf);
			}
		}
						
	}
	
}