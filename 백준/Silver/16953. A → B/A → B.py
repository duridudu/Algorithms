from collections import deque
A, B = map(int, input().split())

def bfs(A):
    global B
    q = deque([(A,1)])
    # print(temp)
    # h=0
    while q:
        # if not q:
        #     return -1
        now=q.popleft()
        # print(now)
        # print(q)
        for i in range(2):
            # 곱하기 먼저~
            if i==0:
                if now[0]<B:
                    q.append((now[0]*2, now[1]+1))
                elif now[0]>B:
                    # return -1
                    continue
                elif now[0]==B:
                    # h=1
                    return now[1]
            # 1 붙이기~ 
            else:
                if now[0]<B:
                    now_t=str(now[0])+str(1)
                    now_t=int(now_t)
                    q.append((now_t, now[1]+1))
                elif now[0]>B:
                    # return -1
                    continue
                elif now[0]==B:
                    # h=1
                    return now[1]

res=bfs(A)
if res==None:
    print(-1)
else:
    print(res)