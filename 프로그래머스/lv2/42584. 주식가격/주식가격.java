import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> q = new LinkedList<>();
        int[] answer = new int [prices.length];
        
        for (int i=0;i<prices.length;i++){
            q.add(prices[i]);
        }// stack 완성 
    
        int i=0;
        while (!q.isEmpty()){
            int now = q.poll();
            int cnt=0;
            // System.out.println(q.toString());
            for (int tmp : q){
                // System.out.print("now is "+now+", tmp is "+tmp+"\n");
                cnt++;
                if (tmp < now){
                    break;
                }
            }
            answer[i] = cnt;
            i++;
        }
        
        return answer;
    }
}