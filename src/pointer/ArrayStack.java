package pointer;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/17 21:01
 * @Description:使用一个数组实现一个stack 这题使用一个指针可以很好的解决
 */
public class ArrayStack {
    private Integer[] arr;
    private Integer index;
    private Integer size;

    public ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        size = initSize;
        arr = new Integer[initSize];
        index = 0;
    }

    //    要求实现三个方法
    public void push(Integer value) {
        if (index.equals(size)) {
            throw new IllegalArgumentException("The stack is full");
        }
        //注意index指向最后一个数前一个
        arr[index++] = value;
    }

    public Integer poll() {
        return arr[--index];
    }

    public Integer peek() {
        return arr[index - 1];
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
