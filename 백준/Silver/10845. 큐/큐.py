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
            #a = lst.pop()
            print(lst[0])
            del lst[0]
            
    elif order[0] == 'size':
        print(len(lst))
        
    elif order[0] == 'empty':
        if len(lst)==0:
            print(1)
        else :
            print(0)
            
    elif order[0] == 'front':
        if len(lst) == 0:
            print(-1)
        else:
            print(lst[0])
    
    elif order[0] == 'back':
        if len(lst) == 0:
            print(-1)
        else:
            print(lst[-1])
            