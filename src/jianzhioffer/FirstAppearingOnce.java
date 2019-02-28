package jianzhioffer;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:53
 * @Description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstAppearingOnce {
    LinkedList<Character> list = new LinkedList();
    HashMap<Character,Integer> map = new HashMap();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else{
            map.put(ch,1);
            list.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char result = '#';
        while(!list.isEmpty()){
            if(map.get(list.peekFirst())==1){
                return list.peek();
            }else{
                list.remove();
            }
        }
        return result;
    }
}
