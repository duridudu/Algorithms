import sys

t = int(sys.stdin.readline())

# 테스트 케이스만큼 반복
for _ in range(t):
    n = int(sys.stdin.readline())
    m1 = list(map(int, sys.stdin.readline().split())) # 첫 번째 줄 스티커의 점수
    m2 = list(map(int, sys.stdin.readline().split())) # 두 번째 줄 스티커의 점수

    # 반복문을 통해 각 스티커 인덱스의 최댓값을 구한다.
    for i in range(1, n):
        # 인덱스가 1일때 최댓값은 이전 대각선의 스티커 점수이다.
        if i == 1:
            m1[1] += m2[0]
            m2[1] += m1[0]

        # 인덱스가 1보다 클 경우에는
        # 두칸 전에 스티커 값과 이전 스티커 값 중에서 큰 값과 현재 스티커의 값을 더한 값이 최댓값이 된다.
        else:
            m1[i] = max(m2[i - 1], m2[i - 2]) + m1[i]
            m2[i] = max(m1[i - 1], m1[i - 2]) + m2[i]

    print(max(m1[n - 1], m2[n - 1]))