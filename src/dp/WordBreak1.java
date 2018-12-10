package dp;

import org.junit.Test;

import java.util.*;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/9 20:02
 * @Description: Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is["cats and dog", "cat sand dog"].
 * <p>
 * 这题要用dp不然时间会超时，思路就是从后往前递归算，普通的从前往后的dfs不写
 */
public class WordBreak1 {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<>();
        if (dict == null || dict.size() == 0 || s == null || s.length() == 0) {
            return result;
        }

        ArrayList<String> list = new ArrayList<>();

        ArrayList<String> di = new ArrayList<>();
        Iterator<String> iterator = dict.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (s.contains(str)) {
                di.add(str);
            }
        }
        int nums = di.size();
        boolean[] color = new boolean[nums];
        for (int i = 0; i < nums; i++) {
            color[i] = false;
        }
        dfs(result, list, di, color, s);
        return result;
    }

    private void dfs(ArrayList<String> result, ArrayList<String> list, ArrayList<String> dict,
                     boolean[] color, String s) {
        if (toStr(list).equals(s)) {
            result.add(toSpaceStr(list));
        }

        for (int i = 0; i < dict.size(); i++) {
            if (!color[i]) {
                String toS = toStr(list) + dict.get(i);
                if (s.startsWith(toS)) {
                    list.add(dict.get(i));
                    color[i] = true;

                    dfs(result, list, dict, color, s);

                    list.remove(list.size() - 1);
                    color[i] = false;
                }
            }
        }
    }

    private String toSpaceStr(ArrayList<String> list) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            s.append(list.get(i) + " ");
        }
        String str = s.toString();

        return str.trim();
    }

    private String toStr(ArrayList<String> list) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            s.append(list.get(i));
        }
        return s.toString();
    }

    public ArrayList<String> wordBreak1(String s, Set<String> dict) {
        HashMap<String, List<String>> dpMap = new HashMap<>(16);
        return dfs(s, dict, dpMap);
    }

    public ArrayList<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return (ArrayList<String>) map.get(s);
        }
        ArrayList<String> lists = new ArrayList();
        if (s.equals("")) {
            lists.add("");
        } else {
            int len = s.length();
            for (int i = 1; i <= len; i++) {
                String sub = s.substring(0, i);
                if (dict.contains(sub)) {
                    ArrayList t = dfs(s.substring(i, len), dict, map);
                    if (t.size() == 0) {
                        continue;
                    } else {
                        for (int j = 0; j < t.size(); j++) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(sub).append(" ").append(t.get(j));
                            lists.add(sb.toString().trim());
                        }
                    }
                }
            }
        }
        map.put(s, lists);
        return lists;
    }

    @Test
    public void test() {
        List<String> list = Arrays.asList("aaaa", "aa", "a");
        /**
         ["a a a a a a a","aa a a a a a","a aa a a a a","a a aa a a a","aa aa a a a",
         "aaaa a a a","a a a aa a a","aa a aa a a","a aa aa a a","a aaaa a a",
         "a a a a aa a","aaa a aa a","a aa a aa a","a a aa aa a","aa aa aa a",
         "aaaa aa a","a a aaaa a","aa aaaa a","a a a a a aa","aa a a a aa",
         "a aa a a aa","a a aa a aa","aa aa a aa","aaaa a aa","a a a aa aa",
         "aa a aa aa","a aaaa aa","a aaaa aa","a a a aaaa","aa a aaaa","a aa aaaa"]
         */
        Set<String> dict = new HashSet<>(list);
        String s = "aaaaaaa";
        ArrayList<String> arrayList = wordBreak1(s, dict);

        System.out.println(Arrays.toString(arrayList.toArray()));
    }
}
