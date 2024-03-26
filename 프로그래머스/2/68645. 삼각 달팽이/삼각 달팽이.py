def solution(n):
    snail = []
    num = 1
    answer=[]
    for i in range(1,n+1):
        temp=[]
        for j in range(i):
            temp.append(0)
        snail.append(temp)

    #snail[0][0] = 1
    #하 우 상 좌 
    dx = [1,0,-1]
    dy = [0,1,0]
    num = 1
    # 방향 인덱스 (4되면 초기화)
    k = 0 
    time = n
    x = -1
    y = 0
    while(time > 0):
        if k > 2 :
            k = 0
        for _ in range(time):
            x = x + dx[k]
            y = y + dy[k]
            if k==2 :
                y-=1
            elif k == 3 : 
                x+=1
                y+=1
            else:
                x=x
                y=y
            snail[x][y] = num
            num+=1
        k+=1
        time-=1
    for s in snail:
        for ss in s:
            answer.append(ss)
        
    return answer