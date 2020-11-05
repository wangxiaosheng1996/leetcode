package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxs
 * @create 2020/8/3   20:58
 */
public class Solution2 {
    //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合

    //暴力解法：1.求出所有的组合 2.把不符合条件的筛掉
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generateAll(new char[2*n],0,result);
        return result;

    }

    /**
     *
     * @param current      当前括号组合
     * @param pos           要添加括号的位置
     * @param result        存放结果字符串
     */
    public void generateAll(char[] current,int pos,List<String> result){
        if(pos==current.length){
            //检查是否有效
            if(valid(current)){
                result.add(new String(current));
            }
        }else{
            current[pos] = '(';
            generateAll(current,pos+1,result);
            current[pos] = ')';
            generateAll(current,pos+1,result);
        }

    }

    //检查是否有效
    //为了检查序列是否有效，我们遍历这个序列，并使用一个变量 balance 表示左括号的数量减去右括号的数量。如果在遍历过程中 balance 的值小于零，或者结束时 balance 的值不为零，那么该序列就是无效的，否则它是有效的。
    public boolean valid(char[] current){
        int balance=0;
        for(char c:current){
            if(c=='('){
                balance++;
            }else{
                balance--;
            }
            if(balance<0){
                return false;
            }
        }
        if(balance==0){
            return true;
        }else{
            return false;
        }
    }
}
