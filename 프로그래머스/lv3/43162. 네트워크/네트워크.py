def dfs(computers, visited, i):
    for j in range(len(computers[i])):
        if i!=j and computers[i][j]==1 and visited[j-1]!=True:
            visited[i-1]=True
            visited[j-1]=True
            dfs(computers, visited, j)

def solution(n, computers):
    answer=0
    visited=[False]*(n)
    for i in range(len(computers)):
        for j in range(len(computers[i])):
            if i!=j and computers[i][j]==1 and visited[j-1]!=True:
                dfs(computers, visited, i)
                answer+=1
    answer+=visited.count(False)
    return answer