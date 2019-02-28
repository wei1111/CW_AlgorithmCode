package jianzhioffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 19:16
 * @Description: 数据流中的中位数
 */
public class GetMedian {
    class MaxHeap implements Comparator<Integer> {
        @Override
        public int compare(Integer i1,Integer i2){
            return i2-i1;
        }
    }

    class MinHeap implements Comparator<Integer>{
        @Override
        public int compare(Integer i1,Integer i2){
            return i1-i2;
        }
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue(new MinHeap());
    PriorityQueue<Integer> maxHeap = new PriorityQueue(new MaxHeap());
    public void Insert(Integer num) {
        if(minHeap.isEmpty()){
            minHeap.add(num);
        }
        else if(num>minHeap.peek())
        {minHeap.add(num);}else{
            maxHeap.add(num);
        }
        if (this.maxHeap.size() == this.minHeap.size() + 2) {
            this.minHeap.add(this.maxHeap.poll());
        }
        if (this.minHeap.size() == this.maxHeap.size() + 2) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public Double GetMedian() {
        if(minHeap.size()>maxHeap.size()){
            return minHeap.peek()/1.0;
        }else if(minHeap.size()<maxHeap.size()){
            return maxHeap.peek()/1.0;
        }else{
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
}
