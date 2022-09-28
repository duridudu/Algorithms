import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 정렬하고 실행해야 바로옆 거 비교하면서 진행 가능 
        Arrays.sort(phone_book);
        // System.out.println(Arrays.toString(phone_book));
        for (int i=0; i<phone_book.length-1; i++){
            if (phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                return answer;
            }
        }
        return answer;
    }
}