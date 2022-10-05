import java.util.*;
import java.lang.ArithmeticException;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Deque<Integer> d = new ArrayDeque<>();
        Arrays.sort(people);
        for (int i=people.length-1; i>=0; i--){
            d.offerLast(people[i]);
        }
        // System.out.println(d.toString());
        while (! d.isEmpty()){
            int temp = d.pollFirst();
            if (!d.isEmpty() && d.peekLast()+temp<=limit){
                d.pollLast();
            }
            answer++;
        }
//         // 내림차순 정렬 ~~~~~~~~~~~~~~~~~~~~~~~~~효율성빵점코드~~~~~~~~~~~~~~~~~~~~~~~
        
//         int [] peoples = new int[people.length];
//         for (int i=people.length-1; i>=0; i--){
//             peoples[people.length-1-i] = people[i];
//         }
//         for (int i=0; i<peoples.length;i++){
//             int temp = peoples[i];
            
//             if (temp==0){
//                 continue;   
//             }
            
//             // System.out.println(temp);
//             for (int j=i+1; j<peoples.length; j++){
//                 if (peoples[j]!=0 && peoples[j] <= limit-temp){
//                     answer+=1;
//                     // 같이 태울 수 있으면 i와 j 모두 0으로 바꿔서 나갔다는 표시 해주기 
//                     peoples[i]=0;
//                     peoples[j]=0;
//                     break;
//                 }
//             }
//             // 같이 태울 수 없을 때 (위의 j for문에서 안걸려서 i번째 사람 0이 아닐때)
//             if (peoples[i]!=0){
//                 answer+=1;
//             }
//         }
        return answer;
    }
}