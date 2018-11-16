package dfs;

import graph.DirectedGraphNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class TopSort {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     * <p>
     * 27. 拓扑排序
     * 给定一个有向图，图节点的拓扑排序被定义为：
     * <p>
     * 对于每条有向边A--> B，则A必须排在B之前
     * 拓扑排序的第一个节点可以是任何在图中没有其他节点指向它的节点
     * 找到给定图的任一拓扑排序
     * <p>
     * 样例
     * 对于下列图：
     * <p>
     * 这个图的拓扑排序可能是：
     * <p>
     * [0, 1, 2, 3, 4, 5]
     * <p>
     * 或者
     * <p>
     * [0, 2, 3, 1, 5, 4]
     * <p>
     * 或者
     * <p>
     * ....
     * 挑战
     * 能否分别用BFS和DFS完成？
     * <p>
     * 说明
     * Learn more about representation of graphs
     * <p>
     * 注意事项
     * 你可以假设图中至少存在一种拓扑排序
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        //这里使用  LinkedList 集合是因为使用dfs的算法，将出度为0的节点先放入集合，所以如果使用 ArrayList
        //在退出dfs后就要反转ArrayList的集合，因为ArrayList不能将元素放到开头
        LinkedList<DirectedGraphNode> result = new LinkedList<>();
        //这个dfs的color很特殊，使用传统boolean的color不能很好的完成，使用集合判断图的节点是否已经包含在拓扑排序中
        ArrayList<DirectedGraphNode> color = new ArrayList<>();

        if (graph == null && graph.size() == 0) {
            return new ArrayList<>();
        }
        int nums = graph.size();
        for (int j = 0; j < nums; j++) {
            if (!color.contains(graph.get(j)) && !result.contains(graph.get(j))) {
                dfs(result, graph.get(j), color);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(LinkedList<DirectedGraphNode> result, DirectedGraphNode vex,
                     ArrayList<DirectedGraphNode> color) {
        color.add(vex);
        for (DirectedGraphNode child : vex.neighbors) {
            if (!color.contains(child) && !result.contains(child)) {
                dfs(result, child, color);
            }
        }
        color.remove(vex);
        result.addFirst(vex);
    }


    @Test
    public void tets() {
        short s = 1;
        s++;
        s += 1;
//        s = s + 1;
    }
}
