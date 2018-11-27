package gready_heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/26 13:30
 * @Description: 典型的使用堆解决的贪心问题
 * 输入： 参数1， 正数数组costs 参数2， 正数数组profits 参数3，
 * 正数k 参数4， 正数m
 * costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花
 * 费之后还能挣到的钱(利润) k表示你不能并行、 只能串行的最多
 * 做k个项目 m表示你初始的资金
 * 说明： 你每做完一个项目， 马上获得的收益， 可以支持你去做下
 * 一个 项目。
 * 输出： 你最后获得的最大钱数。
 */
public class IPO {
    public static class Node {
        public int profit;
        public int capital;

        public Node(int p, int c) {
            this.profit = p;
            this.capital = c;
        }
    }

    //小堆放的是capital
    public static class MinHeapComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.capital - o2.capital;
        }
    }

    //大堆放的是profit
    public static class MaxHeapComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }

    public static int getMaxProfit(int m, int k, int[] profits, int[] capitals) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new MinHeapComparator());
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new MaxHeapComparator());

        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], capitals[i]);
            minHeap.add(nodes[i]);
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && minHeap.peek().capital <= m) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.isEmpty()) {
                return sum;
            }
            sum += maxHeap.poll().profit;

        }
        return sum;
    }
}
