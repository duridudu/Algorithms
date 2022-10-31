def solution(m, n, board):
    global b, dr, dc, check
    dr=[0,1,1]
    dc=[1,0,1]
    answer = 0
    b = []
    for i in range(m):
        b.append(list(board[i]))
        
    while(True):
        check=[[False]*n for _ in range(m)]
        ## 전체 돌면서 2*2 블럭 찾고, check 리스트를 true로 바꿔준다.
        chk=False
        for i in range(m):
            for j in range(n):
                ## 한번이라도 true가 반환되면 chk는 True로 변한다.
                ## 그렇지 않으면 (다 돌았는데 다 false면, 2*2 블럭 없으면 )
                res = block(i,j,m,n)
                if res==True:
                    chk=True
        restock(m,n)
        if (chk==False):
            break   

    for i in range(m):
        for j in range(n):
            if b[i][j]=="Bomb!":
                answer+=1
    
    return answer

def restock(m,n):
    global check
    for i in range(n):
        temp=[]
        for j in range(m):
            ## 터진 블럭이 아니면 임시 리스트에 값 보관
            if check[m-1-j][i]==False:
                temp.append(b[m-1-j][i])
        ## 안터진 블록 수만큼 아래부터 채움        
        for k in range(len(temp)):
            b[m-1-k][i]=temp[k]
        ## 터진 블록 수만큼 Bomb!으로 채움
        for k in range(m-len(temp)):
            b[k][i]='Bomb!'
            
def block(i,j,m,n):
    w = b[i][j]
    if w=='Bomb!':
        return False
    for k in range(3):
        nr = i+dr[k]
        nc = j+dc[k]
        if nr<0 or nr>=m or nc<0 or nc>=n or b[nr][nc]!=w or  b[nr][nc]=="Bomb!":
            return False
    ## 위 세 방향 다 통과한다면 2*2 블럭임. 
    check[i][j]=True
    check[i+dr[0]][j+dc[0]]=True
    check[i+dr[1]][j+dc[1]]=True
    check[i+dr[2]][j+dc[2]]=True
    return True
    
            