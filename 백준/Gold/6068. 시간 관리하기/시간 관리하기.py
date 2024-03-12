n = int(input())
arr = [[0]*n for _ in range(n)]
for i in range(n):
    arr[i] = list(map(int, input().split()))
arr.sort(key = lambda x:x[1])

work = arr[-1][1]-arr[-1][0]

for i in range(n-2,-1,-1):
    if work<=arr[i][1] :
        work = work - arr[i][0]
    elif work > arr[i][1]:
        work = arr[i][1]
        work = work-arr[i][0]
if work>=0:
    print(work)
else:
    print(-1)