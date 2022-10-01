import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        ArrayList<Integer> cNum = new ArrayList<>();
        int a = n;
        int temp = n;
        int b = 0;
        // 지수 변환을 위해 나머지가 몫보다 작아질때까지 나누며 ArrayList에 저장 
        while(a>=k){
            //몫
            a=temp/k;
            //나머지
            b=temp%k;
            cNum.add(b);
            temp=temp/k;
        }
        cNum.add(temp);
        
        // 지수변환된 값을 뒤에서부터 문자열로 형변환 
        String str = "";
        for (int i=cNum.size()-1; i>=0; i--){
            int tmp = cNum.get(i);
            str+= String.valueOf(tmp);
        }
        
        // 0으로 split하여 조건에 맞게 변환
        String [] strArr = str.split("0");
        // 조건에 맞는 소수 개수 셀 변수 
        int cnt=0;
        
        // 0으로 split된 배열 돌며 소수 체크
        for (int i=0; i<strArr.length;i++){
            String temps = strArr[i];
            // 빈 문자열이 아니고 소수가 맞다면 카운트 +1
            if (!(temps.equals("")) && (isPrime(Long.parseLong(temps)))){
                cnt++;
            }
        }
        answer = cnt;
        return answer;
    }
    
    // 소수 판별 함수
    public boolean isPrime(long n) {
        if (n==1){
            return false;
        }
        
        for (long i = 2; i<= Math.sqrt(n); i++) {
          if (n % i == 0) {
              return false;
          }
        }
	    return true;
    }
}