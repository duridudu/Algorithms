import java.util.*;
import java.lang.*;

class Solution {
    
    public boolean isRight(String str){
        // System.out.println(str);
        Stack <Character> st = new Stack<>();
        
        for (int i = 0 ;i<str.length(); i++){
            
            char tmp = str.charAt(i);
            // 여는 괄호면 스택에 넣고 큐에서 poll
            if (tmp=='('|| tmp =='{' || tmp=='['){
                st.push(tmp);
                // System.out.print("지금 스택에는 "+st.toString()+"\n");
            }
            
            // 닫는 괄호면 스택에 있던거 빼서 종류별로 확인
            if (tmp==')'){
                // 닫는 괄호가 있는데 스택이 비어있으면 땡! false 반환
                if (st.isEmpty()){
                    return false;
                }
                // 스택 비어있지 않으면
                else {
                    // 스택에 있던거 뽑아서 일치하는 괄호인지 확인 
                    char tmp2 = st.peek();
                    if (tmp2=='('){
                        st.pop();
                    }
                    // 스택이 비어있지 않지만 일치하지 않는 괄호면 false 
                    else{
                        return false;
                    }
                }
            }
            else if (tmp=='}'){
                if (st.isEmpty()){
                    return false;
                }
                else {
                    char tmp2 = st.peek();
                    if (tmp2=='{'){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
            else if (tmp==']'){
                if (st.isEmpty()){
                    return false;
                }
                else {
                    char tmp2 = st.peek();
                    if (tmp2=='['){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if (!st.isEmpty()){
            return false;
        }

        return true;
    }
    
    public int solution(String s) {
        int answer = 0;
        boolean res;
        Queue <Character> q = new LinkedList<>();
        
        for (int i=0; i<s.length(); i++){
            q.offer(s.charAt(i));
        }
        
        // 회전 1회~s.length회
        for (int i=0;i<s.length();i++){
            q.offer(q.poll());
            String temp = q.toString();
            int a = temp.length()-1;
            String str = temp.substring(1, a);
            res = isRight(str);
            // System.out.println(res);
            // System.out.println();
             if (res){
                answer+=1;
            }
        }
        return answer;
    }   
    
}