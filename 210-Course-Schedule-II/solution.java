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
        Map<Integer, List<Integer>> follows = new HashMap<Integer, List<Integer>>();
        for(int[] preq : prerequisites) {
            if (!follows.containsKey(preq[1])) {
                List<Integer> list = new ArrayList<Integer>();
                follows.put(preq[1], list);
            }
            
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
            if (follows.containsKey(c)) {
                List<Integer> followers = follows.get(c);
                for (int f : followers) {
                    indegree[f]--;
                    if (indegree[f] == 0) {
                        courses.offer(f);
                    }
                }
            }
        }
        
        return curIndex == numCourses ? res : new int[0];
    }
}