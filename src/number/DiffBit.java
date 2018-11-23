package number;

import org.junit.Test;

import java.util.Comparator;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/22 19:05
 * @Description:
 */
public class DiffBit implements Comparator {
    public int diffBit(int a, int b) {
        a = a ^ b;
        return Integer.bitCount(a);
    }

    @Test
    public void test() {
        System.out.println(Integer.bitCount(1));
        System.out.println(Integer.bitCount(-1));
        String string = Integer.toBinaryString(-1);
        System.out.println();

        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(string);
        System.out.println();

        System.out.println(diffBit(1,-1));

        char a = 'a';
        char A = 'A';
        System.out.println((byte)a);
        System.out.println((byte)A);

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
