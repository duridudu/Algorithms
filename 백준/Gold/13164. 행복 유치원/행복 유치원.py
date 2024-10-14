n,k = map(int, input().split())
h = list(map(int,input().split()))
diff = []
for i in range(n-1):
    diff.append(h[i+1]-h[i])
diff.sort()

print(sum(diff[:n-k]))