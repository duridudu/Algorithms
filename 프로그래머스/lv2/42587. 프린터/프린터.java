import java.util.*;
import java.lang.*;

class Solution {
    class Pair {
        int idx, value;
        public Pair(int idx, int value){
            this.idx = idx;
            this.value= value;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<priorities.length; i++){
            q.add(new Pair(i, priorities[i]));
        }
        int answer = 0;
        while (!q.isEmpty()){
            int cur = q.peek().value;
            boolean check=false;
            for (Pair pair : q){
                if (pair.value > cur){
                    check=true;
                    break;
                }
            }
            
            if (check){
                q.add(q.poll());
            }
            else{
                Pair nowBiggest = q.poll();
                answer++;
                if (nowBiggest.idx == location){
                    return answer;
                }
            }
        }
        return answer;
    }
}