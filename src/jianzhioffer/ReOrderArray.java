package jianzhioffer;

import java.util.Stack;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:32
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证
 * 奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        Stack<Integer> stack = new Stack();
        int less = 0;

        for(int i = 0;i<array.length;i++){
            if(array[i]%2==0){
                stack.push(array[i]);
            }else{
                swap(array,less++,i);
            }
        }
        for(int i=array.length-1;i>=less;i--){
            array[i] = stack.pop();
        }

    }
    public void swap(int[]arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
