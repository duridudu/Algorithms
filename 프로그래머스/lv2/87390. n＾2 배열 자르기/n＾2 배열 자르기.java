import java.util.*;
import java.lang.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        ArrayList <Integer> temp = new ArrayList<>();
        
        for (long i=left;i<=right;i++){
            int r = (int)(i/((long)n));
            int c = (int)(i%((long)n));
            if (r+1<=c){
                temp.add(c+1);
            }
            else{
                temp.add(r+1);
            }
        }
        
        int [] answer = new int[temp.size()];
        for(int i=0; i<temp.size();i++){
            answer[i]=temp.get(i);
        }
        return answer;
    }
}