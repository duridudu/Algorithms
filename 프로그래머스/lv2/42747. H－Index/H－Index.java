import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int cnt=0;
        Arrays.sort(citations);
       
        for (int i=citations.length-1; i>=0;i--){
            int temp = citations[i];
            cnt +=1 ;
            
            if (cnt > temp){
                cnt -= 1;
                break;
            }
        }
        
        return cnt;
    }
}