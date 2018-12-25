package map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/22 20:59
 * @Description:
 */
public class CloneGraph {

    //最喜欢的BFS
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        Stack<UndirectedGraphNode> stack = new Stack();
        stack.push(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap(16);
        hm.put(node, root);
        while (!stack.isEmpty()) {
            UndirectedGraphNode r = stack.pop();
            ArrayList<UndirectedGraphNode> al = new ArrayList();
            if (r.neighbors.size() != 0) {
                for (UndirectedGraphNode u : r.neighbors) {
                    if (hm.containsKey(u)) {
                        al.add(hm.get(u));
                    } else {
                        UndirectedGraphNode temp = new UndirectedGraphNode(u.label);
                        al.add(temp);
                        hm.put(u, temp);
                        stack.push(u);
                    }
                }
            }
            hm.get(r).neighbors = al;
        }
        return root;
    }

    private HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneGraphDFS(node);
    }

    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        root = map.get(node);
        for (UndirectedGraphNode u : node.neighbors) {
            if (map.containsKey(u)) {
                root.neighbors.add(map.get(u));
            } else {
                root.neighbors.add(cloneGraphDFS(u));
            }
        }
        return root;
    }

    @Test
    public void test() {
//        UndirectedGraphNode undirectedGraphNode = cloneGraphBFS(new UndirectedGraphNode(-1));
        UndirectedGraphNode undirectedGraphNode = cloneGraph(new UndirectedGraphNode(-1));
        System.out.println(undirectedGraphNode.label);
    }


}
