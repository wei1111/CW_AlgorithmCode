package sort;

import org.junit.Test;
import utils.SwapUtil;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/12 20:55
 * @Description: 堆排序是一种选择排序，它的最坏，最好，平均时间复杂度均为O(nlogn)，空间复杂度维O(1)
 * 它也是不稳定排序。
 * 参考：
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 * https://blog.csdn.net/loveliuzz/article/details/77618530
 * <p>
 * 时间复杂度
 * 堆排序的时间复杂度，主要在初始化堆过程和每次选取最大数后重新建堆的过程；
 * 初始化建堆过程时间：
 * O(n)
 * 推算过程：
 * 首先要理解怎么计算这个堆化过程所消耗的时间，可以直接画图去理解；
 * 假设高度为k，则从倒数第二层右边的节点开始，这一层的节点都要执行子节点比较然后交换（如果顺序是对的就不用交换）；倒数第三层呢，则会选择其子节点进行比较和交换，如果没交换就可以不用再执行下去了。如果交换了，那么又要选择一支子树进行比较和交换；
 * 那么总的时间计算为：s =2^(i -1)*(k -i )；
 * 其中 i
 * 表示第几层，2^(i -1)表示该层上有多少个元素，(k -i)表示子树上要比较的次数，如果在最差的条件下，就是比较次数后还要交换；因为这个是常数，所以提出来后可以忽略；
 * S =2^(k-2)*1+2^(k-3)*2.....+2*(k-2)+2^(0)*(k-1)===>因为叶子层不用交换，
 * 所以i从 k-1开始到 1；
 * 这个等式求解，我想高中已经会了：等式左右乘上2，然后和原来的等式相减，就变成了：
 * S =2^(k -1)+2^(k -2)+2^(k -3).....+2-(k-1)
 * 除最后一项外，就是一个等比数列了，直接用求和公式：S =
 * {
 * a1[1 - (q ^ n)]
 * }  /(1-q)；
 * S =2^k -k -1；又因为k为完全二叉树的深度，
 * 所以(2^k) <=n<(2^k  -1)，总之可以认为：k =logn （
 * 实际计算得到应该是 log(n+1) <k <=logn ）;
 * 综上所述得到：S =n -longn -1，所以时间复杂度为：
 * O(n)
 * 更改堆元素后重建堆时间：
 * O(nlogn)
 * 推算过程：
 * 1、
 * 循环 n -1次，每次都是从根节点往下循环查找，
 * 所以每一次时间是 logn，总时间：
 * logn(n-1) =nlogn  -logn ；
 * 综上所述：堆排序的时间复杂度为：
 * O(nlogn)
 * 空间复杂度
 * 因为堆排序是就地排序，空间复杂度为常数：
 * O(1)
 */
public class HeapSort {
    public static void sort(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        //建立大顶堆前 [4, 6, 8, 5, 9]
        Integer length = nums.length;

        for (Integer i = length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, length);
            //建立大顶堆后 [9, 6, 8, 5, 4]
        }
        System.out.println("建堆后：" + Arrays.toString(nums));

        //调整堆 有点巧妙
        for (Integer i = length - 1; i > 0; i--) {
            //将堆顶元素与最后一个元素进行交换，在进行堆的调整
            SwapUtil.swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    private static void adjustHeap(Integer[] nums, Integer i, Integer length) {
        for (Integer j = 2 * i + 1; j < length; j = 2 * i + 1) {
            if (j + 1 < length && nums[j] < nums[j + 1]) {
                j = j + 1;
            }
            if (nums[j] > nums[i]) {
//                nums[i] = nums[j];
                SwapUtil.swap(nums, i, j);
                i = j;
            } else {
                break;
            }
        }
    }

    @Test
    public void test() {
        Integer[] nums = new Integer[]{4, 6, 8, 5, 9};
        System.out.println("堆排前：" + Arrays.toString(nums));

        sort(nums);
        System.out.println("堆排后：" + Arrays.toString(nums));
    }

}
