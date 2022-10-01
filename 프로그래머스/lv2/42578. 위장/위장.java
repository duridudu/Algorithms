import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> c = new HashMap<>();
        int answer = 0;
        // 맵에 종류별 개수 카운트
        for (int i=0; i<clothes.length;i++){
            String type = clothes[i][1];
            // 종류가 기록 안되어있으면 넣고 
            if (! c.containsKey(type)){
                c.put(type, 1);
            }
            // 이미 맵에 들어가있는 종류면 꺼내서 값 +1 시킴
            else {
                c.replace(type, c.get(type)+1);
            }
        }

        // System.out.print("num of clothes = "+answer+"\n");
        int temp  = 1;
        for (int val : c.values()){
            // System.out.println(val);
            temp *= (val+1);
        }
                
        // 총 의상 개수
        // answer = clothes.length;
        
        // 종류 개수에 종류별 개수 곱하기 
        // if (c.size()>1){
        //     for (int val : c.values()){
        //     // System.out.println(val);
        //     temp *= val;
        //     }
        // }
        // else{
        //     temp=0;
        // }
        
        answer = temp -1 ;
        return answer;
    }
}