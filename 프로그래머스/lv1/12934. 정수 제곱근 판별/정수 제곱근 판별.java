import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        double temp = Math.sqrt(n);
        String t = Double.toString(temp);
        if (t.charAt(t.length()-1)=='0'){
            int x1 = (int) temp + 1;
            answer =(long) Math.pow(x1, 2);
        }
        else{
            answer=-1;
        }
        return answer;
    }
}