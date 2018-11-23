package pointer;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/17 21:34
 * @Description: 用数组模拟一个队列，通过size来控制有没有满的逻辑很重要
 */
public class ArrayQueue {
    private Integer[] arr;
    private Integer size;
    private Integer first;
    private Integer last;

    public ArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        first = 0;
        last = 0;
    }

    //    要求实现三个方法
    public void push(Integer value) {
        if (size.equals(arr.length)) {
            throw new IllegalArgumentException("The stack_queue is full");
        }
        //注意index指向最后一个数前一个
        if (last == arr.length - 1) {
            arr[last] = value;
            last = 0;
        } else {
            arr[last++] = value;
        }
        size++;
    }

    public Integer poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        if (first == arr.length - 1) {
            int result = arr[first];
            first = 0;
            size--;
            return result;
        } else {
            size--;
            return arr[first++];
        }
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[first];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push(1);
        arrayStack.push(2);
//        arrayStack.push(1);
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.poll());
        System.out.println(arrayStack.poll());
//        System.out.println(arrayStack.poll());
    }

}
