package number;

//答案来源
//https://blog.csdn.net/surp2011/article/details/51168272

/**
 * 描述
 * 设计一个算法，计算出n阶乘中尾部零的个数
 *
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 11! = 39916800，因此应该返回 2
 *
 * 挑战
 * O(logN)的时间复杂度
 *
        小结
        从最终的代码来看，问题是挺简单的。之所以折腾这么久都没有切入要害，直接做到真正的时间复杂度为O(logN)的效果，个人觉得是因为从分析题目的时候就没有真正理解O(logN)的真正含义。
        类似于二叉搜索树，从根节点开始比较，比根节点小则与左子树比较，比根节点大则与右子树比较，相等或到达叶子节点则退出。如此循环迭代。
        每次判断后，下一次可搜索的数据量均为上一次的1/2，如此循环复杂度为O(logN)。
        */
public class TrailingZeros {
    /**
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */

    //第一种时间复杂度位O(N)
    public long trailingZeros1(long n){
        // write your code here, try to do it without arithmetic operators.
        //分解因式的有多少个5就有多少个0
        long m = 0;
        for (long i = 1; i <= n; i++) {
            long j = i;
            while (j % 5 == 0) {
                j /= 5;
                m++;
            }
        }
        return m;
    }
    //第二种时间复杂度位O(N/5)-=O(N)
    public long trailingZeros2(long n) {
        // write your code here, try to do it without arithmetic operators.
        //分解因式的有多少个5就有多少个0
        long m = 0;
        for (long i = 5; i <= n; i+=5) {
            long j = i;
            while (j % 5 == 0) {
                j /= 5;
                m++;
            }
        }
        return m;
    }

    //第三种时间复杂度位O(logN)每次减少1/5
    public long trailingZeros3(long n) {
        // write your code here, try to do it without arithmetic operators.
        //分解因式的有多少个5就有多少个0
        long m = 0;
        long x = 0;
        while ((x=(n/=5))!=0){
            m+=n;
            System.out.println("x:"+x);
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(new TrailingZeros().trailingZeros3(14));
    }
}
