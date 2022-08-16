import sys
input = sys.stdin.readline

N=int(input()) ### 지방의 개수
lsts = list(map(int, input().split())) ### 각 지방의 예산 요청
M = int(input()) ### 총 예산

def binary(lsts, start, end) :
    while start <= end : ### 쪼개고 쪼개서 중간이랑 끝이랑 같거나 작아질때까지 반복
        mid = (start + end) // 2
        total = 0
        for budg in lsts : 
            if budg > mid : ### 중간값보다 예산이 크면 중간값을 더함
                total += mid
            else :
                total += budg 
        if total > M: ### 상한이 mid인 요청의 합이 예산보다 크면
            end = mid - 1 ### 중간의 왼쪽 범위에서 다시 돌림
        else : ### 상한이 mid인 요청의 합이 예산보다 작으면
              start = mid + 1 ### 중간의 오른쪽 범위에서 다시 돌림
    return end
  
if sum(lsts) <= M :
    print(max(lsts))
else :
    ends=binary(lsts,0,max(lsts)) ### 시작 0, 끝 지역별 예산 요청의 최댓값 
    print(ends)