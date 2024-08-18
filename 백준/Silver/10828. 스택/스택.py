import sys
input = sys.stdin.readline

n = int(input())
stack = []

for _ in range(n) :
    lst = input().split()
    a = lst[0]
   
    if a == "push" :
        b = lst[1]
        stack.append(b)
    elif a == "pop":
        if len(stack) != 0 : 
            print(stack.pop())
        else:
            print(-1)
    elif a == "size":
        print(len(stack))
    elif a == "empty":
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    elif a =="top":
        if len(stack) != 0:
            print(stack[-1])
        else:
            print(-1)