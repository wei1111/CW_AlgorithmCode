package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/16 19:28
 * @Description: Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * For example, given s ="aab",
 * Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 * <p>
 * palindrome：回文的意思，可怜的我题目看不懂
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/1025ffc2939547e39e8a38a955de1dd3
 * <p>
 * 动态规划的题，最主要就是写出状态转移方程
 * 状态转移，其实就是怎么把一个大的状态表示为两个或者多个已知的状态
 * 以此题为例，设f[i][j]为最小的切点数，那么有：
 * 1、s[i][j]为回文字符串，则f[i][j] = 0;
 * 2、增加一个切点p，将s[i][j]切割为两端s[i][p]、s[p+1][j],则f[i][j] = f[i][p]+f[p+1][j]
 * 所谓的状态转移方程就是上面的式子
 * <p>
 * 接着来看看怎么组织程序，先看看状态转移的思路：
 * 以"aab"为例，"aab"明显不是回文串
 * 所以 f("aab") = min( (f("a")+f("ab")) , (f("aa")+f("b")) ) + 1;
 * f("a") = 0;
 * f("ab") = f("a")+f("b") +1  = 0+0+1 = 1;
 * f("aa") = 0;
 * f("b") = 0;
 * 即f("aab") = 1;
 * <p>
 * 聪慧的你一定能看出来，这是一个递归调用的过程，计算f("ab")需要先计算f("a")、f("b")
 * 用递归实现动态规划，在思路上是最简单的，大部分的题目都可以用这种方式解决
 * <p>
 * 但是有一些数据变态的题目，加上测试机子给的堆栈太小，这种递归的算法很容易就爆栈了
 * 我们需要用我们的聪明智慧，把递归的程序写为非递归的。
 * 把解题思路从下往上看，假设我们先求出来了f("a")，f("b")
 * 那么我们可以求出f("aa"),f("ab")
 * 接着我们就可以得出答案f("aab")了
 * 在这个过程中，我们需要牺牲空间（f[1000][1000]）代替堆栈记录递归调用的返回值
 * 而且这种方式有个好处，就是可以减少计算量
 * 比如计算f("aab")时需要计算f("aa")+f("b")
 * 计算f("ab")事需要计算f("a")+f("b")
 * 这里就计算了两次f("b");
 * 在第一次计算f("b")之后,将f("b")记录下来，可以减少一次计算量
 * 动态规划本质上是暴力搜索，只不过咋这个暴力搜索的过程中，减少了不必要的计算，这样就提升了算法解决问题的速度
 * 在一些题目中，你还可以根据题目减少某些分支的计算
 * 比如只要判断这个字符串是回文串，就可以直接返回0，不需要一步步计算其中的子序列
 */
public class MinCut {
    //中间状态有n!个
    private int f[][] = new int[200][200];

    //先写出递归
    public int minCutRecursion(String s) {
        if (s == null) {
            return -1;
        }
        if (isPalindrome(s, 0, s.length() - 1)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, s.length());

            min = Math.min(minCutRecursion(s1) + minCutRecursion(s2) + 1, min);
        }
        return min;
    }

    public int minCutDP(String s) {
        if (s == null) {
            return -1;
        }
        if (isPalindrome(s, 0, s.length() - 1)) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            //巧妙的一笔，控制k和j的间距的增长，使得k往右移动，从小到大求出所有，dp牛皮 啊
            for (int j = 0, k = i; k < s.length(); j++, k++) {
                if (!isPalindrome(s, j, k)) {
                    int min = Integer.MAX_VALUE;
                    for (int x = j; x < k; x++) {
                        int a = f[j][x];
                        int b = f[x + 1][k];
                        min = Math.min(min, a + b + 1);
                    }
                    //找到j,k的最小值
                    f[j][k] = min;
                } else {
                    f[j][k] = 0;
                }
            }
        }
        return f[0][s.length() - 1];
    }

    private boolean isPalindrome(String s, int start, int end) {
//        char[] chars = s.toCharArray();
//        int start = 0;
//        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void test() {
//        String str = "aab";
        //0 1 1 1
        //0 0 0 1
        //0 0 0 1
        //0 0 0 0
        String str = "leet";
        System.out.println(minCutRecursion(str));
        System.out.println(minCutDP(str));
    }
}
