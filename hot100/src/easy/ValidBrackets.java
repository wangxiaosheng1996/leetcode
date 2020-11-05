package easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author wxs
 * @create 2020/9/13   16:03
 */
public class ValidBrackets {

    public boolean isValid2(String s){
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack = new Stack<>();
        stack.push('?');

        for(Character c:s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            }else{
                if(map.get(stack.pop())!=c){
                    return false;
                }
            }
        }
        if(stack.peek()=='?'){
            return true;
        }else{
            return false;
        }

    }





    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        if(s.length()==1){
            return false;
        }
        char front='0';
        StringBuffer sb = new StringBuffer();
        if(s.length()>1){
            for(int i=0;i<s.length();i++){
                if(sb.length()==0){
                    char current = s.charAt(i);
                    //sb第一个字符必须为(或{或[
                    if(!(current=='(' || current=='{' || current=='[')){
                        return false;
                    }
                    front = current;
                    sb.append(current);
                }else{
                    if(front=='('){
                        if(s.charAt(i)==')'){
                            sb.deleteCharAt(sb.length()-1);
                            if(sb.length()==0){
                                front = '0';
                            }else{
                                front = sb.charAt(sb.length()-1);
                            }
                        }else if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                            sb.append(s.charAt(i));
                            front = s.charAt(i);
                        }else{
                            return false;
                        }

                    }else if(front=='{'){
                            if(s.charAt(i)=='}'){
                                sb.deleteCharAt(sb.length()-1);
                                if(sb.length()==0){
                                    front = '0';
                                }else{
                                    front = sb.charAt(sb.length()-1);
                                }

                            }else if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                                sb.append(s.charAt(i));
                                front = s.charAt(i);
                            }else{
                                return false;
                            }

                        }else{//[
                            if(s.charAt(i)==']'){
                                sb.deleteCharAt(sb.length()-1);
                                if(sb.length()==0){
                                    front = '0';
                                }else{
                                    front = sb.charAt(sb.length()-1);
                                }
                        }else if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                            sb.append(s.charAt(i));
                            front = s.charAt(i);
                        }else{
                            return false;
                        }
                    }

                }

            }


        }
        if(sb.length()>0){
            return false;
        }else{
            return true;
        }
    }
}