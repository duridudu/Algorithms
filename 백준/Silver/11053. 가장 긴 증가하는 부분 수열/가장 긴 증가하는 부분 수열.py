n=int(input())
arr=[]
dp=[]
# for i in range(n):
#     arr[i]=int(input())
arr=list(map(int, input().split()))
dp=[1 for i in range(n)]

for i in range(n):
    for j in range(i+1):
        if (dp[j]>=dp[i]) and (arr[i]>arr[j]):
            dp[i]+=1
print(max(dp))