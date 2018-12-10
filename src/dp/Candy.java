package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/16 10:51
 * @Description: There are N children standing in a line. Each child is assigned a
 * rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy {
    /**
     * 遍历两边，首先每个人得一块糖，第一遍从左到右，若当前点比前一个点高就比前者多一块。
     * 这样保证了在一个方向上满足了要求。第二遍从右往左，若左右两点，左侧高于右侧，但
     * 左侧的糖果数不多于右侧，则左侧糖果数等于右侧糖果数+1，这就保证了另一个方向上满足要求
     */
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] results = new int[len];
        //给每个孩子一个糖果
        Arrays.fill(results, 1);

        //从左到右来一遍，比左边大的+1
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                results[i] = results[i - 1] + 1;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && results[i] <= results[i + 1]) {
                results[i] = results[i + 1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += results[i];
        }
        return sum;
    }

    @Test
    public void test() {
        int candy = candy(new int[]{1, 3, 5});
        System.out.println(candy);
    }
}
