

n,m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
lst = []
check = [False]*n

def dfs():
  if len(lst) == m :
    print(*lst)
    return

  temp = 0  
  for i in range(len(arr)):
    if not check[i] and temp != arr[i]:
        lst.append(arr[i])
        check[i] = True
        dfs()
        temp = lst.pop()
        check[i] = False
     
dfs()