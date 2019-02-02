package gready_heap;

import org.junit.Test;
import utils.VerificationUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/26 14:02
 * @Description: 一个数据流中， 随时可以取得中位数
 * 一个大顶堆，一个小顶堆
 * 大顶堆里放小的里面大的
 * 小顶堆里放大的里面小的
 */
public class MedianQuick {
    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2, o1);
        }
    }


    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());

    private void modifyTwoHeapsSize() {
        if (this.maxHeap.size() == this.minHeap.size() + 2) {
            this.minHeap.add(this.maxHeap.poll());
        }
        if (this.minHeap.size() == this.maxHeap.size() + 2) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public void addNumber(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else {
            if (maxHeap.peek() >= num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
        modifyTwoHeapsSize();
    }

    private Integer getMedian() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();

        if (minSize + maxSize == 0) {
            return null;
        }
        if (minSize + maxSize == 1) {
            return maxSize > minSize ? maxHeap.peek() : minHeap.peek();
        }
        int max = maxHeap.peek();
        int min = minHeap.peek();
        //oooooos
        if (((minSize + maxSize) & 1) == 0) {
            return (max + min) / 2;
        } else {
            return maxSize > minSize ? max : min;
        }
    }

    @Test
    public void test() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Less_Money.MinHeapComparator());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Less_Money.MaxHeapComparator());
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
    }
    // for test, this method is ineffective but absolutely right

    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean err = false;
        int testTimes = 200000;
        for (int i = 0; i != testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = VerificationUtil.getRandomIntArray(len, maxValue);
            MedianQuick medianHold = new MedianQuick();
            for (int j = 0; j != arr.length; j++) {
                medianHold.addNumber(arr[j]);
            }
            if (medianHold.getMedian() != getMedianOfArray(arr)) {
                err = true;
                System.out.println("true:" + getMedianOfArray(arr));
                System.out.println("false:" + medianHold.getMedian());
                System.out.println("ArraySize:" + arr.length);
                printArray(arr);
                Arrays.sort(arr);
                printArray(arr);

                System.out.println("minSize:" + medianHold.minHeap.size());
                System.out.println("maxSize:" + medianHold.maxHeap.size());
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }
}
