package gready_heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/26 14:59
 * @Description: 最最典型的贪心，只不过这个贪心很好解决，就是不好证明
 * 每一个贪心算法都是一个数学题。。。
 * 给定一个字符串类型的数组strs， 找到一种拼接方式， 使得把所
 * 有字 符串拼起来之后形成的字符串具有最低的字典序
 */
public class LowestLexicography {
    public static class MyStrComparator implements Comparator<String> {

        //按升序进行
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }

        private static String lowestString(String[] strs) {
            StringBuilder result = new StringBuilder();
            Arrays.sort(strs, new MyStrComparator());
            for (int i = 0; i < strs.length; i++) {
                result.append(strs[i]);
            }
            return result.toString();
        }

        public static void main(String[] args) {
            String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
            System.out.println(lowestString(strs1));

            String[] strs2 = {"ba", "b"};
            System.out.println(lowestString(strs2));

        }

    }
}
