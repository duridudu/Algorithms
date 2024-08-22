N = int(input())
for _ in range(N):
  lst = list(input())
 
  stack = [lst[0]]
  first = stack[-1]
  
  for i in range(1,len(lst)):
    ##lst[i]
    if len(stack)>0 and (stack[-1] + lst[i] == "()") :
      stack.pop()
    else: 
      stack.append(lst[i])
      
  if len(stack)>0 :
    print("NO")
  else:
    print("YES")
  