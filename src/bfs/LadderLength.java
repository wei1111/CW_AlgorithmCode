package bfs;

import org.junit.Test;

import java.util.*;

public class LadderLength {
    /**
     * @param start: a string
     * @param end:   a string
     * @param dict:  a set of string
     * @return: An integer
     * <p>
     * 120. 单词接龙
     * 给出两个单词（start和end）和一个字典，找到从start到end的最短转换序列
     * <p>
     * 比如：
     * <p>
     * 1.每次只能改变一个字母。
     * 2.变换过程中的中间单词必须在字典中出现。
     * 样例
     * 给出数据如下：
     * <p>
     * start = "hit"
     * <p>
     * end = "cog"
     * <p>
     * dict = ["hot","dot","dog","lot","log"]
     * <p>
     * 一个最短的变换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog"，
     * <p>
     * 返回它的长度 5
     * <p>
     * 注意事项
     * 如果没有转换序列则返回0。
     * 所有单词具有相同的长度。
     * 所有单词都只包含小写字母。
     * <p>
     * 求图的最短路径使用bfs
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        //hashSet用于过滤已经使用的dict中的元素，防止再走一遍
        HashSet<String> hashSet = new HashSet<>();
        //queue中放每一层的节点
        LinkedList<String> linkedList = new LinkedList<>();

        hashSet.add(start);
        linkedList.add(start);
        //可能dict中没有end，但是会有end的上一步的word
        dict.add(end);

        //下面开始遍历一层中所有的next，想象成一颗二叉树的层次遍历
        int result = 1;
        while (!linkedList.isEmpty()) {
            //遍历的层数就是路径的长度
            result++;
            int layerSize = linkedList.size();
            for (int i = 0; i < layerSize; i++) {
                String poll = linkedList.poll();
                for (String nextWord : getNextWords(poll,dict)) {
                    if (hashSet.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return result;
                    }
                    hashSet.add(nextWord);
                    linkedList.add(nextWord);
                }
            }
        }
        return 0;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        char[] chars = word.toCharArray();
        ArrayList<String> nextWords = new ArrayList<>();
        for (int j = 0; j < chars.length; j++) {
            for (char i = 'a'; i <= 'z'; i++) {
                if (chars[j] == i) {
                    continue;
                }
                String nextString = replace(word, j, i);
                if (dict.contains(nextString)) {
                    nextWords.add(nextString);
                }
            }
        }
        return nextWords;
    }

    @Test
    public void testGetNextWords() {
        String word = "chen";
        Set<String> dict = new HashSet<>();
        dict.add("chea");
        dict.add("cheb");
        dict.add("chec");
        dict.add("chan");
        dict.add("chbn");
        dict.add("chba");
        dict.add("chca");
        dict.add("cdca");

//        ArrayList<String> nextWords = getNextWords(word, dict);
//        System.out.println(Arrays.toString(nextWords.toArray()));
        System.out.println(ladderLength(word,"cdca",dict));
    }

}
