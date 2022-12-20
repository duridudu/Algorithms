n=int(input())
height=list(map(int, input().split()))
speed=list(map(int, input().split()))
#trees={}
trees=[]
for i in range(n):
    trees.append((height[i], speed[i]))
    # trees[speed[i]]=height[i]
# trees=dict(sorted(trees.items()))
trees.sort(key=lambda x:x[1])
result=0
# k=0
for i in range(n):
    # result+=(trees[tree]+k*tree)
    result+= trees[i][0]+trees[i][1]*i
    # k+=1
print(result)