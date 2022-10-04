import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for (int i=0; i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        
        while (pq.size()!=1){
            int first = pq.peek();
            if (first>=K){
                break;
            }
            
            int a = pq.poll();
            int b = 0;
            int news = 0;
            if (!pq.isEmpty()){
                b = pq.poll();
                news = a+b*2;
                pq.add(news);
                answer+=1;
            }
            
        }
        // pq.peek() < K 이 경우를 고려 못해서 16번만 오류났었음!!!!!!
        if (pq.size() == 1 && pq.peek() < K){
            answer=-1;
        }
        return answer;
    }
}