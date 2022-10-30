import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n,m = map(int, input().split())
campus = []
a=0
b=0

for num in range(n):
    tmp = list(input()) ### 이거 문자열로 받지 말고 리스트로 돼서 campus[][]로 읽을 수 있게 하기!!
    campus.append(tmp)
    if 'I' in tmp:
        a = num
        b = tmp.index('I')  

dx = [0,0,-1,1]
dy = [-1,1,0,0]

friends = 0
check = [[0]*m for _ in range(n)]


def dfs(x,y):
    global friends
    
    if (0 <= x < n and 0 <= y < m and check[x][y] == 0):
        #print(campus[x][y])
        check[x][y] = 1
        if campus[x][y] == 'P':
            #print("HI")
            friends += 1
                    
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if (0 <= nx < n and 0 <= ny < m and check[nx][ny] == 0):
                if campus[nx][ny]!='X':
                    #print("접근 성공", nx,ny,campus[nx][ny])
                    #check[nx][ny]=1
                    dfs(nx,ny)
              
                


dfs(a,b)

if friends == 0:
    print("TT")
else:
    print(friends)