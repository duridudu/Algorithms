import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> q = new LinkedList<>();
        int[] answer = new int [prices.length];
        
        for (int i=0;i<prices.length;i++){
            q.add(prices[i]);
        }// stack 완성 
    
        int i=0;
        // 큐에서 하나씩 꺼내며 다음 원소가 현재보다 작으면 break
        while (!q.isEmpty()){
            int now = q.poll();
            // 매 반복때마다 몇 초 동안 떨어지지 않는지 봐야하므로 카운트 변수 0으로 초기화
            // 맨 마지막 원소면 그대로 0 들어감
            int cnt=0;
            // 큐에 있는 원소 순회
            for (int tmp : q){
                // 안에 원소가 존재해서 들어왔으면 cnt ++
                cnt++;
                // 현재 원소보다 작으면 가격 떨어진 것이므로 for문 중단
                if (tmp < now){
                    break;
                }
            }
            // 가격 얼마동안 떨어지는지 순회 후 해당 인덱스에 cnt 카운트한 것 저장 
            answer[i] = cnt;
            i++;
        }
        
        return answer;
    }
}