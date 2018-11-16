package sort;

import org.junit.Test;

import java.util.*;

public class KthLargestElement {
    /**
     * @param k    : description of k
     * @param nums : array of nums
     * @return: description of return
     * 思路来自：https://www.cnblogs.com/dsj2016/p/5500204.html
     */

    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        //优先队列
        int ret = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
//        System.out.println(Arrays.toString(priorityQueue.toArray()));
//        Iterator iterator = priorityQueue.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        System.out.println("----------------");
        for (int i = 0; i < k; i++) {
            ret = priorityQueue.poll();
        }
        return ret;
    }

    /**
     * 第二种方法是用快速排序的思想。快速排序每次把一个元素交换到正确的位置，
     * 同时把左边的都方上大的，右边都放上小的。这个算法每一次选取一个枢纽元，
     * 排序之后，查看枢纽元的位置。如果它的位置大于K，就说明，要求出前面一个
     * 子序列的第K大的元素。反之，如果小于K，就说明要求出在后面一个序列的第
     * K - 前一个序列的长度个元素
     */
    public int kthLargestElement2(int k, int i, int j, int[] nums) {
        if (i > j) {
            return 0;
        }
        int flag = nums[i];
        int y = j;
        int x = i;
        int t = 0;
        while (y > x) {
            while (nums[y] <= flag && y > x) {
                y--;
            }
            while (nums[x] >= flag && y > x) {
                x++;
            }
            t = nums[y];
            nums[y] = nums[x];
            nums[x] = t;
        }
        nums[i] = nums[y];
        nums[y] = flag;

        if (k-1 < y) {
            return kthLargestElement2(k, i, y - 1, nums);
        } else if (k-1 > y) {
            return kthLargestElement2(k, y + 1, j, nums);
        } else {
            return nums[k-1];
        }
    }


    @Test
    public void testKthLargestElement() {
        int[] nums = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int ret = kthLargestElement2(3,0,nums.length-1, nums);
        System.out.println(ret);
    }
}
