def solution(triangle):
    answer = 0
    dp=[[0] for i in range(len(triangle))]
    dp[0][0]=triangle[0][0]
    # print(dp)
    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            if (j==0):
                dp[i][0]=dp[i-1][0]+triangle[i][0]
                # print(dp)
            elif (j==len(triangle[i])-1):
                dp[i].append(dp[i-1][j-1]+triangle[i][j])
                # print(dp)
            else:
                dp[i].append(max(dp[i-1][j-1]+triangle[i][j], dp[i-1][j]+triangle[i][j]))
                # print(dp)
    answer=max(dp[-1])
    

    return answer