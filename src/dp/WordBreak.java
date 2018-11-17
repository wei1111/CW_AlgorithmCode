package dp;

import org.junit.Test;

import java.util.Set;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/16 0:49
 * @Description: Given a string s and a dictionary of words dict, determine
 * if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 * <p>
 * Return true because"leetcode"can be segmented as"leet code".
 * <p>
 * 状态转移方程：
 * f(i) 表示s[0,i]是否可以分词
 * f(i) = f(j) && f(j+1,i); 0 <= j < i;
 */
public class WordBreak {
    //典型的动态规划，需要存储中间过程
    public boolean wordBreak(String s, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return false;
        }
        //存储中间
        int len = s.length();
        //这里为len+1
        boolean[] isOk = new boolean[len + 1];
//        for (int i = 0; i < isOk.length; i++) {
//            System.out.println(isOk[i]);
//        }
        //这里要初始化
        isOk[0] = true;
        //这里是<=
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isOk[j] && dict.contains(s.substring(j, i))) {
                    isOk[i] = true;
                    break;
                }
            }
        }
        return isOk[len];
    }

    @Test
    public void test() {
        boolean[] isOk = new boolean[6];

        for (int i = 0; i < isOk.length; i++) {
            System.out.println(isOk[i]);
        }
    }
}
