package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wei1
 * @Date: Create in 2019/3/7 19:54
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] nums = new int[N];
        if (N > 2 * M) {
            return;
        }
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        //这么多单座
        int dub = 2 * (N - M);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dub; i++, dub--) {
            max = Math.max((nums[i] + nums[dub - 1]), max);
        }
        System.out.println(max);
    }
}
