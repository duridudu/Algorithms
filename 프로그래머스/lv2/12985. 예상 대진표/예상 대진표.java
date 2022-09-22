import java.lang.Math;
import java.util.Arrays;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int res = Math.abs(a-b);
        int answer = 1;
        int [] arr = new int[2];
        arr[0]=a;
        arr[1]=b;
        Arrays.sort(arr);
        
        if (res==1 && arr[0]%2==1){
                return answer;
        }
        
        while(true){
           
            if (a%2==0){
                a=a/2;
            }
            else if (a%2==1){
                a=a/2+1;
            }
            
            if (b%2==0){
                b=b/2;
            }
            else if (b%2==1){
                b=b/2+1;
            }
            
            arr[0]=a;
            arr[1]=b;
            Arrays.sort(arr);
            // System.out.println(Arrays.toString(arr));
            res = Math.abs(a-b);
            answer+=1;
            if (res==1 && arr[0]%2==1){
                break;
            }
            
        }
        
        return answer;
    }
}