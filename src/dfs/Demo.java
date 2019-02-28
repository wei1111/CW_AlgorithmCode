package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/19 17:43
 * @Description:
 */
public class Demo {
    @Test
    public void test() {
        String[] strs = {"i am a coder", "Coder Coder", "Code"};
        System.out.println(Arrays.toString(strs));
        String[] coder = findCoder(strs, 3);
        System.out.println(Arrays.toString(coder));
    }

    public String[] findCoder(String[] A, int n) {
        // write code here
        ArrayList<FCoder> list = new ArrayList();
        for (String str : A) {
            int num = getCoderNum(str.toLowerCase());
            if (num != 0) {
                list.add(new FCoder(num, str));
            }
        }
        Collections.sort(list, new Comparator<FCoder>() {
            @Override
            public int compare(FCoder o1, FCoder o2) {
                return o2.size - o1.size;
            }
        });
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).str;
        }
        return result;
    }

    public int getCoderNum(String str) {
        int sum = 0;
        int start = str.indexOf("coder");
        int len = "coder".length();
        while (start != -1) {
            sum++;
            start = start + len;
            start = str.indexOf("coder", start);
        }
        return sum;
    }
}

class FCoder {
    int size;
    String str;

    public FCoder(int size, String str) {
        this.size = size;
        this.str = str;
    }
}