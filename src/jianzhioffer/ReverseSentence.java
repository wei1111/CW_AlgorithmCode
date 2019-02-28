package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:27
 * @Description: “student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 翻转字符串
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if(str==null){
            return str;
        }
        char [] chs = str.toCharArray();
        //先反转整个
        int i = 0;
        int j = chs.length-1;
        ReverseChars(chs,i,j);
        int former = 0;
        int latter = 0;
        for(int k=0;k<chs.length;k++){
            if(chs[k]==' '){
                former = k;
                ReverseChars(chs,latter,former-1);
                latter = former+1;
            }
        }
        ReverseChars(chs,latter,chs.length-1);
        return new String(chs);
    }

    public void ReverseChars(char[] chs,int i,int j){
        while(i<j){
            char temp = chs[i];
            chs[i++] = chs[j];
            chs[j--] = temp;
        }
    }
}
