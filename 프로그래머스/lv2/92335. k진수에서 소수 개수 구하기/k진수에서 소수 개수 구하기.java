import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        ArrayList<Integer> cNum = new ArrayList<>();
        int a = n;
        int temp = n;
        int b = 0;
        while(a>=k){
            //몫
            a=temp/k;
            //나머지
            b=temp%k;
            cNum.add(b);
            temp=temp/k;
        }
        cNum.add(temp);
        String str = "";
        for (int i=cNum.size()-1; i>=0; i--){
            int tmp = cNum.get(i);
            str+= String.valueOf(tmp);
        }
        
        String [] strArr = str.split("0");
        // System.out.println(Arrays.toString(strArr));
        int cnt=0;
        for (int i=0; i<strArr.length;i++){
            // System.out.println(strArr[i]);
            String temps = strArr[i];
            
            if (!(temps.equals("")) && (isPrime(Long.parseLong(temps)))){
                cnt++;
                // System.out.println(isPrime(Integer.parseInt(temps)));
            }
        }
        
        answer = cnt;
        return answer;
    }
    
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