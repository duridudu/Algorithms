from sys import stdin
a = int(stdin.readline())

if a == 1 :
    print(3)
else:
    dp = [0]*(a+1)
    dp[1] = 3
    dp[2] = 7

    for i in range(3,a+1):
        dp[i] = (dp[i-1]*2 + dp[i-2])%9901

    print(dp[a]%9901)