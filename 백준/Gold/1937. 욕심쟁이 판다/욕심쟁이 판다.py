import sys

sys.setrecursionlimit(10**7)

def dfs(i,j):
    if eaten[i][j]==-1:
        eaten[i][j]=0
    # eaten[i][j] = 1
        for k in range(4):
            nx=i+dx[k]
            ny=j+dy[k]
            # cnt=cnt+1
            # print(i,j,"/",nx,ny)
            if nx<n and ny<n and nx>=0 and ny>=0 and pandas[nx][ny]>pandas[i][j]:
                # print("{} 그리고 다음 좌표는 {}".format(pandas[i][j],pandas[nx][ny]))

                eaten[i][j]=max(eaten[i][j], dfs(nx,ny))
                # dfs(nx,ny,cnt)
                # print("eaten[{}][{}] is {}".format(nx,ny,eaten[nx][ny]))
        # cnt-=1
    return eaten[i][j]+1

n=int(input())
pandas=[]
eaten=[]
global dx,dy

dx=[0,0,-1,1]
dy=[-1,1,0,0]
for i in range(n):
    pandas.append(list(map(int, input().split())))
    eaten.append([-1]*n)

answer=0
for i in range(n):
    for j in range(n):
        # print("------------")
        answer=max(dfs(i,j),answer)
#         # print(eaten)

# for r in range(n):
#     # temp=max(eaten[r])
#     answer=max(dfs(i,j), answer)
print(answer)