### 회의 개수 입력 받기 
num = int(input())

### 이차원 배열 저장할 리스트 
lst = []
### 회의 개수 셀 변수, 1로 초기화 
cnt = 1 

### 배열 입력 받기 
for i in range(num):
    lst.append(list(map(int, input().split())))

### 각 입력의 두번째 원소 (끝나는 시간) 기준 오름차순 정렬
lst.sort(key = lambda x: (x[1], x[0]))

### 가장 처음 비교할 회의 (가장 일찍 끝나는)
temp = lst[0][1]

### 가장 일찍 끝나는 회의는 무조건 들어가므로 인덱스 1부터 시작
for i in range(1,num):
    ### 현재 회의 바로 다음 회의 찾기 (현재 회의가 끝나는 시간과 같거나 그거보다 커야 함)
    if lst[i][0] >= temp:
        cnt+=1
        ### 다음 회의의 끝나는 시간을 temp에 저장해 다음 탐색에 사용
        temp=lst[i][1]
print(cnt)