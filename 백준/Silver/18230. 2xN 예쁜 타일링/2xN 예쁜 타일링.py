n,a,b = map(int, input().split())
x = list(map(int,input().split()))
y = list(map(int,input().split()))
x.sort()
y.sort()

ans = 0

if n % 2 == 1: 
    ans += x[-1] 
    x.pop(-1) 
    n -= 1 
     
for _ in range(0, n, 2): 
    t1, t2 = 0, 0 
    if len(x) >= 2: 
        t1 = x[-1] + x[-2] 
    if len(y) >= 1: 
        t2 = y[-1] 
         
    if t1 > t2: 
        ans += t1 
        x.pop(); x.pop() 
    else: 
        ans += t2 
        y.pop() 

print(ans)

