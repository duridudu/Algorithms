N,M = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]
dp = [[0]*(M+1) for _ in range(N+1)]

for i in range(1,N+1):
  for j in range(1,M+1):
    ## 지금 칸은 lst[i-1][j-1]로 -1씩 한 거여야 함
    dp[i][j] = lst[i-1][j-1] + max(dp[i][j-1], dp[i-1][j])

print(dp[-1][-1])