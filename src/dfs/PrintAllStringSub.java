package dfs;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/23 19:17
 * @Description: 下面的这种做法是求所有的子序列
 */
public class PrintAllStringSub {
    public void printAllStringSub(LinkedList<String> list,String str, int i, String result) {
        if (i == str.length() + 1) {
            list.add(result);
            System.out.println(result);
            return;
        }
        printAllStringSub(list,str, i + 1, result);
        printAllStringSub(list,str, i + 1, result + str.substring(i - 1, i));
    }


    public void printAllStringSub2(LinkedList<String> list, String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String sub = str.substring(i, j);
                System.out.println(sub);
                list.add(sub);
            }
        }
    }



    @Test
    public void test() {
        LinkedList<String> list = new LinkedList<>();
        printAllStringSub2(list,"abc");
        System.out.println(list.size());
    }
}
