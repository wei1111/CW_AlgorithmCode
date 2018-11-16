package dp;

import org.junit.Test;

import java.util.*;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/9 20:02
 * @Description:
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is["cats and dog", "cat sand dog"].
 * <p>
 * 这题要用dp不然时间会超时，思路就是从后往前递归算，普通的从前往后的dfs时间不够
 */
public class WordBreakii {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        HashMap<String, ArrayList<String>> dpMap = new HashMap<>(16);
        ArrayList<String> results = dfs(s, dict, dpMap);
        Collections.reverse(results);
        return results;
    }

    //这题可以写个十遍，背下来
    private ArrayList<String> dfs(String s, Set<String> dict,
                                  HashMap<String, ArrayList<String>> dpMap) {
        //退出条件
        if (dpMap.containsKey(s)) {
            return dpMap.get(s);
        }

        //即使dp中要存起来的中间计算结果，又是我们要返回的结果
        ArrayList<String> lists = new ArrayList<>();

        if (s.equals("")) {
            lists.add("");
            return lists;
        }

        for (int i = 0; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (dict.contains(sub)) {
                //在这里进入下一层，在下一层判断是否计算过这个s，如果计算了就直接返回原來计算的结果
                //在这个test中第二个结果中的s第二次=dog的结果就不用计算
                ArrayList<String> list = dfs(s.substring(i, s.length()), dict, dpMap);
                if (list.size() != 0) {
                    for (int j = 0; j < list.size(); j++) {
                        //这里的StringBuilder放在循环里的，因为每次都是不是一个结果
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(sub + " " + list.get(j));
                        lists.add(stringBuilder.toString().trim());
                    }
                }
            }
        }
        dpMap.put(s, lists);
        return lists;
    }

    @Test
    public void test() {
        List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
        Set<String> dict = new HashSet<>(list);
        String s = "catsanddog";
        ArrayList<String> arrayList = wordBreak(s, dict);

        System.out.println(Arrays.toString(arrayList.toArray()));
    }

}
