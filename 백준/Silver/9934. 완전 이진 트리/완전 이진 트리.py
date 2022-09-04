
def binary(b, depth):
    if len(b)==1:
        tree[depth].extend(b)
        return
    length=len(b)
    mid = length//2
    tree[depth].append(b[mid])
    binary(b[:mid], depth+1)
    binary(b[mid+1:], depth+1)

N=int(input())
# 순회한 값으로 역으로 트리를 유추함 
# 깊이가 K인 이진 트리는 총 2 * K - 1 개의 노드로 이루어져 있다!!
buildings = list(map(int, input().split()))
tree = [[] for _ in range(N)]
# 빌딩 리스트와 인덱스 0 입력
binary(buildings, 0)
for i in range(N):
    if i==0:
        print(tree[i][0])
    else:
        print(*tree[i])