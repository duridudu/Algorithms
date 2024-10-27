n = int(input())
result = 0
bombo = [list(input()) for _ in range(n)]

def check_bombo():
    global result
    for i in range(n): # 가로 맥스 카운팅
        cnt = 1
        for j in range(n - 1):
            if bombo[i][j] == bombo[i][j + 1]:
                cnt += 1
                result = max(result, cnt)
            else:
                cnt = 1

    for i in range(n): # 세로 맥스 카운팅
        cnt = 1
        for j in range(n - 1):
            if bombo[j][i] == bombo[j + 1][i]:
                cnt += 1
                result = max(result, cnt)
            else:
                cnt = 1

for i in range(n):
    for j in range(n - 1):
            bombo[i][j], bombo[i][j + 1] = bombo[i][j + 1], bombo[i][j] # 가로 교체
            check_bombo()
            bombo[i][j + 1], bombo[i][j] = bombo[i][j], bombo[i][j + 1] # 원복

            bombo[j][i], bombo[j + 1][i] = bombo[j + 1][i], bombo[j][i] # 세로 교체
            check_bombo()
            bombo[j + 1][i], bombo[j][i] = bombo[j][i], bombo[j + 1][i] # 원복
print(result)