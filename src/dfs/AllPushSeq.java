package dfs;

import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/3/13 13:10
 * @Description: 已知出栈序列求所有的入栈序列
 *
 * 1 2 3 4 5
 * 如果第一个出栈的序列是5那么
 * （1 2 3 4）5
 * 5 （1 2 3 4）
 * 递归来求
 */
public class AllPushSeq {
    public static void main(String[] args) {
        allPushSeq(new int[]{1, 2, 3});
    }

    public static void allPushSeq(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        allPushSeq(arr, list,0);
    }

    public static void allPushSeq(int[] arr, LinkedList<Integer> list,int i) {
        if (i == arr.length) {
            System.out.println(list);
            return;
        }
        //这是先入栈的
        list.add(arr[i]);
        allPushSeq(arr, list, i + 1);
        list.remove(arr.length - 1);
        list.addLast(arr[i]);
        allPushSeq(arr, list, i + 1);
    }
//    1 2 3
//    3 2 1
//    3 1 2
//    1 2 3

}
