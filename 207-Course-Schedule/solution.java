public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList();
        initilize(adjs, indegree, prerequisites);
        return solve(adjs, indegree);
    }
    
    private void initilize(List<List<Integer>> adjs, int[] indegree, int[][] pre) {
        for(int i = 0; i < indegree.length; i++) {
            adjs.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < pre.length; i++) {
            indegress[pre[i][0]]++;
            adjs.get(pre[i][1]).add(pre[i][0]);
        }
    }
    
    private boolean solve(List<List<Integer>> adjs, int[] indegree) {
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(indegree[i]);
            }
        }
        
        int visited = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            visited++;
            for(int j : adjs[cur]) {
                indegree[j]--;
                if (indegree[j] == 0) {
                    q.offer(j);
                }
            }
        }
        
        return visited == indegree.length;
    }
}