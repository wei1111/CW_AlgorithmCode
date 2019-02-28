package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/18 14:56
 * @Description:
 */
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        //这个题目难懂
        //作者：Ballontt
        //链接：https://www.nowcoder.com/questionTerminal/e84e273b31e74427b2a977cbfe60eaf4
        //来源：牛客网
        //
        //Ballontt ：首先简单介绍一下Anagram（回文构词法）。Anagrams是指由颠倒字母顺序组成的单词，“tea”会变成“eat”。
        //
        //回文构词法有一个特点：单词里的字母的种类和数目没有改变，只是改变了字母的排列顺序。
        //
        //For example:
        //
        //Input:  ["tea","and","ate","eat","den"]
        //
        //Output:   ["tea","ate","eat"]
        ArrayList<String> result = new ArrayList();
        if(strs==null||strs.length<1){
            return result;
        }
        HashMap<String,ArrayList<String>> hm = new HashMap();
        for(String s: strs){
            String str = sortStr(s);
            if(hm.containsKey(str)){
                hm.get(str).add(s);
            }else{
                ArrayList<String> al = new ArrayList();
                al.add(s);
                hm.put(str,al);
            }
        }
        for(String str : hm.keySet()){
            if(hm.get(str).size()>1){
                result.addAll(hm.get(str));
            }
        }
        return result;
    }

    public String sortStr(String str){
        if(str==null){
            return str;
        }
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }

    @Test
    public void test() {
        String[] strs = {"and", "dan"};
        ArrayList<String> anagrams = anagrams(strs);
        System.out.println(anagrams);
    }
}
