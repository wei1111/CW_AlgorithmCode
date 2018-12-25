package map;

import java.util.ArrayList;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/22 20:57
 * @Description:
 */
public class UndirectedGraphNode {

    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
