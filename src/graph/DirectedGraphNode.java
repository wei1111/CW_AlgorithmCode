package graph;

import java.util.ArrayList;

public class DirectedGraphNode {
    //Definition for Directed graph.
    //有向图
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}