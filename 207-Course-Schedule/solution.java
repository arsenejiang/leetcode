public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        
        int[] pres = new int[numCourses];
        ArrayList<Integer>[] adjs = new ArrayList[numCourses];
        for(int[] prerequisite : prerequisites) {
            pres[prerequisite[0]]++;
            if (adjs[prerequisite[1]] == null) {
                adjs[prerequisite[1]] = new ArrayList<Integer>();
            }
            adjs[prerequisite[1]].add(prerequisite[0]);
        }
        
        int count = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if (pres[i] == 0) {
                q.offer(i);
                count++;
            }
        }
        
        if (count == 0) {
            return false;
        }
        
        while(!q.isEmpty()) {
            int index = q.poll();
            for(int i : adjs[index]) {
                pres[i]--;
                if (pres[i] == 0) {
                    q.offer(i);
                    count++;
                }
            }
        }
        
        return count == numCourses;
    }
}