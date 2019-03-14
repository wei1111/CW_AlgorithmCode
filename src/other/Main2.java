package other;

import java.util.Scanner;
import java.util.PriorityQueue;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();
        String result = greedy(str);
        System.out.println(result);
    }

    public static String greedy(String s) {
        char[] sa = s.toCharArray();
        int[] f = new int[26];
        int count = 0;
        // 统计不同的字符个数
        for (char ch : sa) {
            if (f[ch - 'a']++ == 0) {
                count++;
            }
        }
        char[] result = new char[count];
        PriorityQueue<Character> heap = new PriorityQueue<>();
        int i = 0;
        int from = 0, to = 0;
        while (i < result.length) {
            // 找到最大可能靠后的候选字符位置
            while (to < sa.length) {
                if (f[sa[to] - 'a'] > 0) {
                    heap.offer(sa[to]);
                    if (--f[sa[to++] - 'a'] == 0) {
                        break;
                    }
                } else {
                    to++;
                }
            }
            char ch = (char) 0;
            do {
                ch = heap.poll();
                while (heap.remove(ch)) {
                    ;
                }
                result[i++] = ch;
                f[ch - 'a'] = 0;
                // 该字符前面的字符已经作废，从堆中删除
                while (sa[from++] != ch) {
                    heap.remove(sa[from - 1]);
                }
                // 如果最大可能靠后的候选字符已经被选择，则终止
            } while (ch != sa[to - 1]);
        }
        return new String(result);
    }
}
