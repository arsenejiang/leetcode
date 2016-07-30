public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjs = new ArrayList();
        int[] indegree = new int[numCourses];
        initilize(adjs, indegree, prerequisites);
        return solve(adjs, indegree);
    }
    
    private void initilize(List<List<Integer>> adjs, int[] indegree, int[][] pres) {
        for(int i = 0; i < indegree.length; i++) {
            adjs.add(new ArrayList<Integer>());
        }
        
        for(int[] pre : pres) {
            indegree[pre[0]]++;
            adjs.get(pre[1]).add(pre[0]);
        }
    }
    
    private int[] solve(List<List<Integer>> adjs, int[] indegree) {
        int[] result = new int[indegree.length];
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int visited = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            result[visited++] = cur;
            for(int next : adjs.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        if (visited == indegree.length) {
            return result;
        }
        else {
            return new int[0];
        }
    }
}