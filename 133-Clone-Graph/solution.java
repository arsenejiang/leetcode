/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        
        Queue<UndirectedGraphNode> q = new LinkedList();
        HashSet<UndirectedGraphNode> visited = new HashSet();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        q.offer(node);
        map.put(node, res);
        while(!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            visited.add(cur);
            UndirectedGraphNode newCur = map.get(cur);
            for(UndirectedGraphNode n : cur) {
                if (!visited.contains(n)) {
                    if(map.containsKey(n)) {
                        newCur.neighbors.add(map.get(n));
                    }
                    else {
                        UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
                        map.put(n, newNode);
                        newCur.neighbors.add(newNode);
                    }
                    q.offer(n);
                }
            }
        }
        
        return res;
    }
}