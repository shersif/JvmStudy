package club.aimath.study.base.leet;

import java.util.*;

/**
 * @Description 力扣练习
 * @Date 2022/11/7 00:37
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class LeetCodeTest {

    /**
     * n.383
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine){
        if (ransomNote.length()>magazine.length())
            return false;
        short[] chas=new short[26];
        for (char c:magazine.toCharArray())
            chas[c-'a']++;
        for (char c:ransomNote.toCharArray()){
            chas[c-'a']--;
            if (chas[c-'a']<0)
                return false;
        }
        return true;
    }

    public static void test2(){
        int num1=10;
        int num2=20;
        boolean flag=num1++>num2--&&num2++>num1--;
        System.out.println(flag+",num1="+num1+",num2="+num2);
    }

    public static void main(String[] args) {
        test2();
    }
}
