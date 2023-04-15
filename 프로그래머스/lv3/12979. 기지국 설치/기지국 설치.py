import math

def solution(n, stations, w):
    answer = 0
    rest = []
    
    before_end = 0
    for s in stations:
        start, end = max(s-w,1), min(s+w, n)
        if not before_end:
            rest.append(start - 1)
            before_end = end
        else:
            if before_end+1 < start:
                # 안 겹치는 경우
                rest.append(start - before_end - 1)
            before_end = end
                
    rest.append(n-before_end)
    
    for r in rest:
        cover = 1 + 2 * w
        answer += math.ceil(r / cover)

    return answer

# def solution(n, stations, w):
#     # n = 아파트 수
#     # stations = 이미 기지국 있는 아파트 번호
#     # w = 5G로 바꿨을 때 전파 도달 범위
#     answer = 0
#     apart=[False for i in range(n+1)]
#     sgmt=[]
#     for s in stations:
#         ## 중간에 쏙
#         if s-w>=1 and s+w<=n:
#             sgmt.append([0,s-w-1])
#             apart[s-w:s+w+1]=[True for i in range(2*w+1)]
#         ## 인덱스 1부터 s+w까지
#         elif s-w<1 and s+w<=n:
#             # sgmt.append([])
#             apart[1:s+w+1]=[True for i in range(s+w)]
#         ## 인덱스 s-w부터 n까지
#         elif s-w>=1 and s+w>n+1:

#             apart[s-w:n]=[True for i in range(n-s+w)]
    
#     print(apart)
    
#     segmt=[]
#     t=0
#     for i in range(1, n+1):
#         if apart[i]==False:
#             segmt.append([])
            
            
#     # for 
#     # apart=apart.split("True")
#     ### segmt 조각 세기 위함
#     # num=0
#     # signal=1
#     # for i in range(1, n+1):
#     #     ## 초기 - 전파 닿는 곳이면 패스 
#     #     if apart[i]==signal:
#     #         continue
#     #     ## 전파 안 닿는 곳이면 num 증가
#     #     ## 이제 패스할 시그널을 전파 안 닿는 곳(-1)으로 바꿔야 함. 
#     #     else:
#     #         num+=1
#     #         signal=(-1)*signal
#     # segmt=[0]*num
#     # t=0
#     # print("",num, segmt)
#     # for s in segmt:
#     #     if s <= (2*w+1):
#     #         answer+=1
#     #     else:
#     #         print("흥~~")
#     return answer