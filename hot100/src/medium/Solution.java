package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wxs
 * @create 2020/8/3   15:37
 */
class Solution {
    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");

    }};
    //保存结果
    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        //先判断next_digits长度是否为0
        if (next_digits.length() == 0) {
            //如果是,则添加到结果集合
            output.add(combination);
            return;
        }
        //获取剩余字符串的第一个数字字符
        String letter = next_digits.substring(0, 1);
        //获取当前数字字符对应的字母
        String letters = map.get(letter);
        for (int i = 0; i < letters.length(); i++) {
            String next_combination = combination + letters.substring(i, i + 1);
            backtrack(next_combination, next_digits.substring(1));
        }

    }


    public List<String> letterCombinations(String digits) {


        //检查输入字符串是否为空
        if (digits == null || digits.length() == 0) {
            return output;
        }
        backtrack("", digits);
        return output;


    }

}


