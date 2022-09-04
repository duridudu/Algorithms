import sys
n = int(sys.stdin.readline())
lst = []
for _ in range(n) : 
    order = sys.stdin.readline().split()
    
    if order[0] == 'push':
        lst.append(order[1])
        
    elif order[0] == 'pop':
        if len(lst)==0:
            print(-1)
        else :
            a = lst.pop()
            print(a)
            
    elif order[0] == 'size':
        print(len(lst))
        
    elif order[0] == 'empty':
        if len(lst)==0:
            print(1)
        else :
            print(0)
            
    elif order[0] == 'top':
        if len(lst) == 0:
            print(-1)
        else:
            print(lst[-1])