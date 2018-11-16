package number;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class Duplicate1 {
    /**
     * 剑指offer 面试题三 找出数组中重复的数字
     * 在一个长度为n的数组中的所有数字都在0~n-1的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字是重复的，也不知道每个数字重复了几次。请找到数组中任意
     * 一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3},那么对应的输
     * 出重复数字为2或者3
     * <p>
     * 按照书上的第一种解法，时间复杂度为O(n) 空间复杂度为O(1)
     */

    public Integer[] findDuplicate(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();

        if (numbers == null || numbers.length == 0) {
            return null;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {
                return null;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    hashSet.add(numbers[i]);
                } else {
                    int tmp = numbers[i];
                    numbers[i] = numbers[numbers[i]];
                    numbers[tmp] = tmp;

//                    System.out.println(Arrays.toString(numbers));

                }
            }
        }

        return hashSet.toArray(new Integer[hashSet.size()]);
    }

    @Test
    public void testDuplicate1() {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(findDuplicate(numbers)));
    }
}
