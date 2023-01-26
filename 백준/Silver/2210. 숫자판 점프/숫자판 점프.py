arr = []
# nums = []
visited = []
for i in range(5):
    arr.append(list(map(str, input().split())))
    visited.append([False, False, False, False, False])

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

res = []

def dfs(x, y, nums):
    # print(x,y, arr[x][y])
    # global nums
    if len(nums) == 6:
        if nums not in res:
            res.append(nums)
            # print(res)
        return

    for n in range(4):
        cx = x + dx[n]
        cy = y + dy[n]
        if 0 <= cx < 5 and 0 <= cy < 5:
            if not visited[cx][cy]:
                dfs(cx, cy, nums + arr[cx][cy])


for i in range(5):
    for j in range(5):
        if not visited[i][j]:
            # cnt = 0
            # res = []
            dfs(i, j, arr[i][j])
            # print("here", "".join(nums))

# print(res)
print(len(res))
