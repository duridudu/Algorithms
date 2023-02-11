N=int(input())
arr=list(map(int, input().split()))
dp=[1]*N

for i in range(N):
    dp[i]=arr[i]
    for j in range(i):
        if arr[i]>arr[j]:
            # print(i, j, dp)
            dp[i]=max(dp[i],dp[j]+arr[i])

print(max(dp))