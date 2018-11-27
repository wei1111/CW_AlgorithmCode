package gready_heap;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/26 1:15
 * @Description: 一块金条切成两半， 是需要花费和长度数值一样的铜板的。 比如
 * 长度为20的 金条， 不管切成长度多大的两半， 都要花费20个铜
 * 板。 一群人想整分整块金 条， 怎么分最省铜板？
 * 例如,给定数组{10,20,30}， 代表一共三个人， 整块金条长度为
 * 10+20+30=60. 金条要分成10,20,30三个部分。 如果， 先把长
 * 度60的金条分成10和50， 花费60 再把长度50的金条分成20和30，
 * 花费50 一共花费110铜板。
 * 但是如果， 先把长度60的金条分成30和30， 花费60 再把长度30
 * 金条分成10和20， 花费30 一共花费90铜板。
 * 输入一个数组， 返回分割的最小代价。
 * <p>
 * 哈夫曼树的问题，使用堆
 */
public class Less_Money {
    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public Integer lessMoney(Integer[] nums) {
        if (nums == null) {
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
        Integer result = 0;
        Integer sum;
        while (minHeap.size() != 1) {
            sum = minHeap.poll() + minHeap.poll();
            result +=sum;
            minHeap.add(sum);
        }

        return result;
    }


    @Test
    public void test() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        minHeap.add(1);
        minHeap.add(3);
        minHeap.add(2);

        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(2);
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
        System.out.println("max");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }


        Integer[] nums = new Integer[]{10, 20, 30};
        Integer resule = lessMoney(nums);
        System.out.println(resule);
    }
}
