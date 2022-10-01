import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int [] left = new int [progresses.length];
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        
        // 100퍼센트-진도를 속도로 나누어 완성하는데 필요한 작업량을 구한다.
        // 구한 잔량을 스택에 넣기 위해 끝 인덱스부터 0번인덱스까지 거꾸로 실행 
        for (int i=left.length-1; i>=0;i--){
            left[i] = (int) Math.ceil((100-progresses[i])/(double) speeds[i]);
            st.push(left[i]);
        }
        
        // 스택에서 하나씩 pop 하며, 다음 작업 잔량이 현재 잔량보다 작거나 같을 때 함께 pop한다.
        while(! st.isEmpty()){
            int work = st.pop();
            int cnt = 1;
            // 빼낸 것 다음 잔량이 빼낸 것보다 작거나 같으면 같이 빼고, 해당 회차 작업량 개수를 하나 늘린다.
            while (!(st.isEmpty()) && st.peek() <= work){
                st.pop();
                cnt++;
            }
            
            // 한 회차가 끝날 때마다 tmp에 횟수를 추가해준다.
            tmp.add(cnt);
        }
        
        // 임시 ArrayList를 answer로 옮긴다.
        int[] answer = new int [tmp.size()];
        for (int i=0; i<tmp.size(); i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}