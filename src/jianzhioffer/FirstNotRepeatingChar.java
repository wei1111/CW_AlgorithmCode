package jianzhioffer;

import java.util.HashMap;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:19
 * @Description: 在一个字符串(0 < = 字符串长度 < = 10000 ， 全部由字母组成)
 * 中找到第一个只出现一次的字符, 并返回它的位置, 如果没有则返回
 * -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> hm = new HashMap();
        for(int i = 0;i<str.length();i++){
            if(hm.containsKey(str.charAt(i))){
                hm.put(str.charAt(i),hm.get(str.charAt(i))+1);
            }else{
                hm.put(str.charAt(i),1);
            }
        }
        for(int i = 0;i<str.length();i++){
            if(hm.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
