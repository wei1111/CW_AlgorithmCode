package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:45
 * @Description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList();
        if(str==null){
            return result;
        }
        char[] chs = str.toCharArray();
        dfs(chs,0,result);
        Collections.sort(result);
        return result;
    }

    private void dfs(char[] chs,int k,ArrayList<String> result){
        if(k==chs.length-1){
            String str = String.valueOf(chs);
            if(!result.contains(str)){
                result.add(str);
            }
            return;
        }
        for(int i = k;i<chs.length;i++){
            swap(chs,i,k);
            dfs(chs,k+1,result);
            swap(chs,i,k);
        }
    }

    private void swap(char[] chs, int i,int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
