package dp;

import org.junit.Test;

public class IsInterleave {
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     * <p>
     * 29.交叉字符串
     * 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
     * <p>
     * <p>
     * <p>
     * 样例
     * 比如 s1 = "aabcc" s2 = "dbbca"
     * <p>
     * - 当 s3 = "aadbbcbcac"，返回  true.
     * <p>
     * - 当 s3 = "aadbbbaccc"， 返回 false.
     * <p>
     * 挑战
     * 要求时间复杂度为O(n^2)或者更好
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        if ((chars1.length + chars2.length) != chars3.length) {
            return false;
        } else {
            return dp(chars1, chars2, chars3, chars1.length, chars2.length);
        }
    }


    public boolean dp(char[] chars1, char[] chars2, char[] chars3, int i, int j) {
        if (i == 0 && j == 0) {
            return chars3.length == 0;
        }
        if (i == 0) {
            return chars2[j - 1] == chars3[j - 1];
        } else if (j == 0) {
            return chars1[i - 1] == chars3[i - 1];
        } else if ((chars1[i - 1] == chars3[i + j - 1] && dp(chars1, chars2, chars3, i - 1, j)) ||
                (chars2[j - 1] == chars3[i + j - 1] && dp(chars1, chars2, chars3, i, j - 1))) {
            return true;
        } else {
            return false;
        }

    }

    @Test
    public void testIsInterleave() {
        System.out.println(isInterleave("aa", "a", "aaa"));
    }
}
