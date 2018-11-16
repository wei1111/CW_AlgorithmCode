package stringQuestion;

public class StrStr {
    /**
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     * 13. Implement strStr()
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (source.equals(target)) {
            return 1;
        } else if (target.length()==0) {
            return -1;
        }
        char[] t = source.toCharArray();
        char[] p = target.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        int[] next = getNext(target);
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                j = next[j]; // j回到指定位置
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                if (p[++j] == p[++k]) { // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
