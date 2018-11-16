package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    /**
     * @param s: A string
     * @return: A list of lists of string
     * <p>
     * 136. 分割回文串
     * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
     * <p>
     * 返回s所有可能的回文串分割方案。
     * <p>
     * 样例
     * 给出 s = "aab"，返回
     * <p>
     * [
     * ["aa", "b"],
     * ["a", "a", "b"]
     * ]
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        List<String> partList = new ArrayList<>();
        if (s == null||s.length() == 0) {
            return result;
        }
        int startIndex = 0;
        dfs(result, partList, startIndex, s);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> partList, int startIndex, String s) {
        //当最后一个字串得到后startIndex为s.length()
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(partList));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i + 1);
            if (isHuiWen(subString)) {
                partList.add(subString);
                dfs(result, partList, i + 1, s);
                partList.remove(partList.size() - 1);
            }
        }
    }

    public boolean isHuiWen(String str) {
        String reverseStr = new StringBuilder(str).reverse().toString();
        return reverseStr.equals(str);
    }

    @Test
    public void testPartition() {
        List<List<String>> result = partition("aab");
        for (List<String> partList : result) {
            System.out.println(partList.toString());
        }
    }
}
