n = int(input())
l1 = list(map(int, input().split()))
l2 = list(map(int, input().split()))
trees = []
answer = 0

for a,b in zip(l1,l2):
    trees.append([a,b])
tree = []
tree = sorted(trees, key = lambda x : x[1])

for i in range(n):
    answer += tree[i][0]+tree[i][1]*i


print(answer)


