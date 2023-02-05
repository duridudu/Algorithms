N,M=map(int, input().split())
arr=[]
for i in range(N):
    arr.append(list(map(int, input().split())))

## dp 배열 설정
dp=[]
for i in range(N):
    dp.append([0]*M)

dp[0][0]=arr[0][0]
for j in range(1,M):
    dp[0][j]=sum(arr[0][:j+1:])

for i in range(1,N):
    dp[i][0]=dp[i-1][0]+arr[i][0]
# print(dp)
for i in range(1,N):
    for j in range(1,M):
        # print(i,j,dp[i-1][j-1])
        ## 바로 위 vs 왼쪽 옆 중 큰 것 가져옴
        dp[i][j]=max(dp[i-1][j], dp[i][j-1]) + arr[i][j]

print(dp[N-1][M-1])