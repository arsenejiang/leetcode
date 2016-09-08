public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (numCourses <= 0) {
            return new int[0];
        }
        else if (numCourses == 1) {
            return new int[]{0};
        }
        else if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length != 2) {
            for(int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        
        int[] indegree = new int[numCourses];
        List<List<Integer>> follows = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++) {
            follows.add(new ArrayList<Integer>());
        }
 
        for(int[] preq : prerequisites) {
            follows.get(preq[1]).add(preq[0]);
            indegree[preq[0]]++;
        }
        
        Queue<Integer> courses = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                courses.offer(i);
            }
        }
        
        int curIndex = 0;
        while(!courses.isEmpty()) {
            int c = courses.poll();
            res[curIndex++] = c;
            List<Integer> followers = follows.get(c);
            for (int f : followers) {
                indegree[f]--;
                if (indegree[f] == 0) {
                    courses.offer(f);
                }
            }
        }
        
        return curIndex == numCourses ? res : new int[0];
    }
}