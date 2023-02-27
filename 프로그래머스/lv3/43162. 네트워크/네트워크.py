def dfs(computers, visited, i):
    # global answer
    for j in range(len(computers[i])):
        # print("dfs의 i는 {}, j는 {}".format(i,j))
        # if i==3 and j==5:
        #     print("여기야아아아")
        #     print(computers[i][j])
        #     print(visited[j-1])
        if i!=j and computers[i][j]==1 and visited[j-1]!=True:
            # print("지굼 i는요~", i)
            # print("지굼 j는욕~~~~", j)
            visited[i-1]=True
            # answer+=1
            visited[j-1]=True

            dfs(computers, visited, j)
    
        

def solution(n, computers):
    # global answer
    answer=0
    visited=[False]*(n)
    # print(visited)
    for i in range(len(computers)):
        for j in range(len(computers[i])):
            if i!=j and computers[i][j]==1 and visited[j-1]!=True:
                dfs(computers, visited, i)
                answer+=1
    # print(visited)
    # print(answer)
    answer+=visited.count(False)
    return answer