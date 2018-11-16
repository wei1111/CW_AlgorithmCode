package utils;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/5 19:57
 * @Description:
 */
public class SwapUtil {
    public static <T extends Comparable> void swap(T[] comparables, int x, int y) {
        T t = comparables[y];
        comparables[y] = comparables[x];
        comparables[x] = t;
    }
}
