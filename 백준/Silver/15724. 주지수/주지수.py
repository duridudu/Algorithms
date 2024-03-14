n,m = map(int, input().split())
arr = [[0]*(m+1) for _ in range(n+1)]
dp = [[0]*(m+1) for _ in range(n+1)]

for i in range(1,n+1):
    temp = list(map(int, input().split()))
    for j in range(1,len(temp)+1):
        arr[i][j] = temp[j-1]

for i in range(1,n+1):
   for j in range(1,m+1):
      dp[i][j]  = dp[i][j-1] + dp[i-1][j] + arr[i][j] - dp[i-1][j-1]

k = int(input())
answer=[]

for _ in range(k):
    x1,y1,x2,y2 = map(int, input().split())
    a = dp[x2][y2] - dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1]
    #if x1 == 1 or y1 == 1 :
    #   a -= dp[1][1]
    answer.append(a)

for a in answer:
    print(a)
