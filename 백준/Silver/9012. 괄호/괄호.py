n = int(input())

for _ in range(n):
    word = input()
    stk = []
    
    for w in word:
        if w == '(':
            stk.append(w)
        elif w==')':
            if stk:
                stk.pop()
            else:
                print("NO")
                break
    else:        
        if not stk:
            print("YES")
        else:
            print("NO")