/*
* @Author: Qi Hu
* @Date:   2016-07-22 10:06:06
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-07-22 10:25:06
* @Source: https://leetcode.com/problems/clone-graph/
*/


import java.util.HashMap;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneUndirectedGraph {
	// We use map to collect the nodes, in case of they are in the loop or circle and never get out!
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    public UndirectedGraphNode clone(UndirectedGraphNode node){
    	if (node == null) {
    		return null;
    	}


    	int l = node.label;
    	if (map.containsKey(l)) {
    		return map.get(l);
    	}

    	UndirectedGraphNode n = new UndirectedGraphNode(l);
    	map.put(l, n);
    	//To add every neighbor into the map and the new clone node
    	for(UndirectedGraphNode a: node.neighbors){
    		n.neighbors.add(clone(a));
    	}
    	return n;
    }
}