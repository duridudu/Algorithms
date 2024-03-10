def solution(n):
    #dp=[[0]*n for _ in range(n+1)]
    #dp[1] = 1
    #dp[2] = 2
    a=1
    b=2
    
    for i in range(3, n+1):
       # dp[i] = (dp[i-1]+dp[i-2])%1000000007
        answer = (a+b)%1000000007
        a = b
        b = answer
        
    return answer%1000000007