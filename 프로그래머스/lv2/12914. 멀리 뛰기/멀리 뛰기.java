class Solution {
    public long solution(int n) {
        long answer = 0;
        long arr [] = new long [n+1];
        arr[1] = 1%1234567;
        // n=1인 경우 그대로 arr[1], arr[2] 작성하면 arr[2] 만들때 인덱스 에러남 
        // so if문으로 나눠줘야함 
        if (n>1){
            arr[2] = 2%1234567;
        }
        for (int i=3; i<n+1; i++){
            arr[i] = (arr[i-2]+arr[i-1])%1234567;
        }
        answer = arr[n]%1234567;
        return answer;
    }
}